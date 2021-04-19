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


    /**
     * Metoda koja se poziva prilikom navigiranja admin korisnika na ekran sa listom svih korisnika aplikacije.
     * @param model objekt preko kojeg šaljemo listu korisnika na html stranicu
     * @return html stranica sa tablicom svih korisnika aplikacije
     */
    @GetMapping("/korisnici")
    public String getKorisniciList(Model model){
        model.addAttribute("listaKorisnika", korisnikFacade.getKorisnikRepository().findAll());

        return "korisnici";
    }

    /**
     * Metoda koja se poziva prilikom klika na gumb za brisanje korisnika iz aplikacije
     * @param korisnikId id korisnika kojeg želimo obrisati
     * @param redirectAttributes objekt preko kojeg šaljemo varijablu u redirect metodi
     * @return preusmjerenje na listu korisnika
     */
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
