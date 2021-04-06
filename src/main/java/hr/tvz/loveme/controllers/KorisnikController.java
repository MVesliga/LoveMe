package hr.tvz.loveme.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KorisnikController {

    @GetMapping("/profil")
    public String getProfil(Model model) {
        return "profil";
    }
}
