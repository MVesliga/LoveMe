package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
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

    private KorisnikRepository korisnikRepository;

    public KorisnikController(KorisnikRepository korisnikRepository) {
        this.korisnikRepository = korisnikRepository;
    }

    /**
     * Metoda koja se poziva prilikom dohvacanja profila ulogiranog korisnika.
     * @param model objekt pomocu kojeg se korisnicki objekt salje u html template
     * @param principal objek pomocu kojeg se dohvacaju podaci trenutno ulogiranog korisnika
     * @return stranica sa prikazom detalja korisnika
     */
    @GetMapping("/profil")
    public String getProfil(Model model, Principal principal) {
        //TODO makmnuti kasnije
        List<Korisnik> listaKorisnika = korisnikRepository.findAll();
        model.addAttribute("korisnik", korisnikRepository.findByKorisnickoIme(principal.getName()));
        System.out.println(principal.getName());
        System.out.println("tu sam!");

        return "profil";
    }
}
