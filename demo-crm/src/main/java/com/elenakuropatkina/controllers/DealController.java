package com.elenakuropatkina.controllers;

import com.elenakuropatkina.entities.Deal;
import com.elenakuropatkina.services.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class DealController {

    private final DealService dealService;

    @GetMapping("/deals")
    public String dealsPage(Model model) {
        model.addAttribute("activePage", "Deals");
        model.addAttribute("deals", dealService.findAll());
        return "deals";
    }

    @GetMapping("/deal/{id}/edit")
    public String updateDeal(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Deals");
        model.addAttribute("deal", dealService.findOne(id));
        dealService.sendNotificationForClient("NOTIFICATION");
        return "deal_form";
    }

    @GetMapping("/deal/create")
    public String createDeal(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Deals");
        model.addAttribute("deal", new Deal());
        return "deal_form";
    }

    @PostMapping("/deal")
    public String update(Model model, RedirectAttributes redirectAttributes, Deal deal) throws IOException {
        model.addAttribute("activePage", "Deals");
        try {
            dealService.update(deal.getId(),
                    deal.getDate(),
                    deal.getClientId(),
                    deal.getManagerId(),
                    deal.getProductId(),
                    deal.getConnectionType(),
                    deal.getStatus());
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (deal.getId() == null) {
                return "redirect:/deal/create";
            }
            return "redirect:/deal/" + deal.getId() + "/edit";
        }
        return "redirect:/deals";
    }

    @PostMapping("/deal/{id}/delete")
    public String deleteDeal(Model model, @PathVariable("id") Long id) {
        dealService.delete(id);
        return "redirect:/deals";
    }

    @GetMapping("/deal/{id}/invoice")
    public String createInvoice(Model model, @PathVariable("id") Long id) {
        model.addAttribute("invoice", dealService.createInvoice(id));
        return "invoice";
    }

    @GetMapping("/deal/{id}/report")
    public String createReport(Model model, @PathVariable("id") Long id) {
        model.addAttribute("report", dealService.createReport(id));
        return "report";
    }

}
