package com.elenakuropatkina.controllers;

import com.elenakuropatkina.entities.Client;
import com.elenakuropatkina.services.ClientService;
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
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/clients")
    public String clientsPage(Model model) {
        model.addAttribute("activePage", "Clients");
        model.addAttribute("clients", clientService.findAll());
        return "clients";
    }

    @GetMapping("/client/{id}/edit")
    public String updateClient(Model model, @PathVariable("id") Long id) {
        model.addAttribute("edit", true);
        model.addAttribute("activePage", "Clients");
        model.addAttribute("client", clientService.findOne(id));
        return "client_form";
    }

    @GetMapping("/client/create")
    public String createClient(Model model) {
        model.addAttribute("create", true);
        model.addAttribute("activePage", "Clients");
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping("/client")
    public String update(Model model, RedirectAttributes redirectAttributes, Client client) throws IOException {
        model.addAttribute("activePage", "Clients");

        try {
            clientService.update(client.getId(), client.getName(), client.getPhone(), client.getEmail(), client.getNotificationType());
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (client.getId() == null) {
                return "redirect:/client/create";
            }
            return "redirect:/client/" + client.getId() + "/edit";
        }
        return "redirect:/clients";
    }

    @PostMapping("/client/{id}/delete")
    public String deleteClient(Model model, @PathVariable("id") Long id) {
        clientService.delete(id);
        return "redirect:/clients";
    }

}



