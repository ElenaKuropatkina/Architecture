package com.elenakuropatkina.controllers;

import com.elenakuropatkina.entities.Product;
import com.elenakuropatkina.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("activePage", "Products");
        model.addAttribute("products", productService.findAll());
        return "products";
    }

    @GetMapping("/product/{id}/edit")
    public String updateProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", productService.findOne(id));
        return "product_form";
    }

    @GetMapping("/product/create")
    public String createProduct(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Products");
        model.addAttribute("product", new Product());
        return "product_form";
    }

    @PostMapping("/product")
    public String update(Model model, RedirectAttributes redirectAttributes, Product product) throws IOException {
        model.addAttribute("activePage", "Products");
        try {
            productService.update(product.getId(), product.getTitle(), product.getPrice());
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (product.getId() == null) {
                return "redirect:/product/create";
            }
            return "redirect:/product/" + product.getId() + "/edit";
        }
        return "redirect:/products";
    }

    @PostMapping("/product/{id}/delete")
    public String deleteProduct(Model model, @PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/products";
    }

}
