package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.Ljubimac;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class KorisnikController {

    @GetMapping("/profil")
    public String getProfil(Model model) {
        return "profil";
    }

    @GetMapping(value = "/korisnicki-profil")
    public String read(Model model) {
        Korisnik korisnik = new Korisnik(1, "Jure", "Winter", "MaliJure", "jure123@gmail.com", "jure123");

        model.addAttribute("korisnik",korisnik);

        return "korisnickiProfil";
    }

    @GetMapping("/koirsnickiProfil")
    public String korisnik(){
        return "korisnickiProfil";
    }
}
