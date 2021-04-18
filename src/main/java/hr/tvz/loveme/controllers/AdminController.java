package hr.tvz.loveme.controllers;

import hr.tvz.loveme.facade.KorisnikFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/love-me")
public class AdminController {

    private KorisnikFacade korisnikFacade;

    public AdminController(KorisnikFacade korisnikFacade) {
        this.korisnikFacade = korisnikFacade;
    }

    @GetMapping("/korisnici")
    public String getKorisniciList(Model model){
        model.addAttribute("listaKorisnika", korisnikFacade.getKorisnikRepository().findAll());

        return "korisnici";
    }
}
