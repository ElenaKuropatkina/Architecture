package com.elenakuropatkina.democrm.controllers;

import com.elenakuropatkina.democrm.entities.Manager;
import com.elenakuropatkina.democrm.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ManagerController {

    private ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/managers")
    public String managersPage(Model model) {
        model.addAttribute("activePage", "Managers");
        model.addAttribute("managers", managerService.findAll());
        return "managers";
    }

    @GetMapping("/manager/{id}/edit")
    public String updateManager(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Managers");
        model.addAttribute("manager", managerService.findOne(id));
        return "manager_form";
    }

    @GetMapping("/manager/create")
    public String createManager(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Managers");
        model.addAttribute("manager", new Manager());
        return "manager_form";
    }

    @PostMapping("/manager")
    public String update(Model model, RedirectAttributes redirectAttributes, Manager manager) throws IOException {
        model.addAttribute("activePage", "Managers");

        try {
            managerService.update(manager.getId(), manager.getName(), manager.getPhone(), manager.getEmail(), manager.getPassword(), manager.getLogin());
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (manager.getId() == null) {
                return "redirect:/manager/create";
            }
            return "redirect:/manager/" + manager.getId() + "/edit";
        }
        return "redirect:/managers";
    }

    @PostMapping("/manager/{id}/delete")
    public String deleteManager(Model model, @PathVariable("id") Long id) {
        managerService.delete(id);
        return "redirect:/managers";
    }
}
