package hr.tvz.loveme.controllers;

import hr.tvz.loveme.converter.KorisnikConverter;
import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import hr.tvz.loveme.repository.KorisnikRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/love-me")
public class KorisnikController {

    private KorisnikFacade korisnikFacade;
    private KorisnikConverter korisnikConverter;

    public KorisnikController(KorisnikFacade korisnikFacade,
                              KorisnikConverter korisnikConverter) {
        this.korisnikFacade = korisnikFacade;
        this.korisnikConverter = korisnikConverter;
    }

    /**
     * Metoda koja se poziva prilikom dohvacanja profila ulogiranog korisnika.
     * @param model objekt pomocu kojeg se korisnicki objekt salje u html template
     * @param principal objek pomocu kojeg se dohvacaju podaci trenutno ulogiranog korisnika
     * @return stranica sa prikazom detalja korisnika
     */
    @GetMapping("/profil")
    public String getProfil(Model model, Principal principal) {
        model.addAttribute("korisnik", korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName()));

        return "profil";
    }

    @GetMapping("/profil/update")
    public String getUpdateProfil(Model model, Principal principal) {
        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());

        KorisnikForm korisnikForm = korisnikConverter.convertToForm(korisnik);

        model.addAttribute("korisnikForm", korisnikForm);

        return "updateProfil";
    }
}
