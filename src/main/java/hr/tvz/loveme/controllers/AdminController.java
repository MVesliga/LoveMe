package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.facade.KorisnikFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/delete/korisnik")
    public String deleteKorisnik(@RequestParam("korisnikId") Integer korisnikId,
                                 RedirectAttributes redirectAttributes) {
        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findById(korisnikId).get();
        korisnikFacade.getKorisnikUlogaRepository().deleteByKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikFacade.getKorisnikRepository().deleteById(korisnikId);

        redirectAttributes.addFlashAttribute("deleteKorisnikSuccess", true);
        return "redirect:/love-me/korisnici";
    }
}
