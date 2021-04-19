package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.KorisnikUloga;
import hr.tvz.loveme.domain.form.KorisnikForm;

import hr.tvz.loveme.domain.form.LoginForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class IndexController {

    private KorisnikFacade korisnikFacade;

    public IndexController(KorisnikFacade korisnikFacade) {
        this.korisnikFacade = korisnikFacade;
    }

    /**
     * Metoda koja služi za dohvaćanje početne stranice.
     * @return
     */
    @GetMapping
    public String getIndexPage() {
        return "index";
    }

    /**
     * Metoda koja služi za dohvaćanje forme za registraciju korisnika.
     * @param model objekt preko kojeg u html stranicu šaljemo formu za popunjavanje podataka o korisniku.
     * @return html stranica sa formom za registraciju
     */
    @GetMapping("/registracija")
    public String getKorisnikRegistracijaForm(Model model) {
        if (!model.containsAttribute("korisnikForm")) {
            model.addAttribute("korisnikForm", new KorisnikForm());
        }

        return "registracija";
    }


    /**
     * Metoda koja se poziva nakon što se klikne gumb za predaju forme za registraciju.
     * Provjerava da li postoje validacijske greške te ukoliko postoje ponovno se preusmjeri korisnika na ekran za popunjavanje forme
     * sa prikladnim porukama o greškama.
     * Ako su svi podaci validni postavlja se korisnička uloga te se korisnik sprema u bazu.
     * @param korisnikForm objekt koji predstavlja korisničku formu
     * @param bindingResult objekt na koji se mapiraju validacijske greške
     * @param redirectAttributes objekt pomoću kojeg šaljemo podatke u zahtjevu za preusmjeravanje
     * @return forma za registraciju u slučaju greške, stranica za prijavu u slučaju uspješne registracije.
     */
    @PostMapping("/registracija")
    public String registerKokrisnik(@ModelAttribute @Valid KorisnikForm korisnikForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        Korisnik existing = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(korisnikForm.getKorisnickoIme());
        if (existing != null) {
            bindingResult.rejectValue("korisnickoIme", null, "Postoji korisnik sa unesenim korisničkim imenom!");
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.korisnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("korisnikForm", korisnikForm);

            return "redirect:/registracija";
        }

        KorisnikUloga korisnikUloga = new KorisnikUloga(korisnikForm.getKorisnickoIme(), "ROLE_USER");
        korisnikFacade.create(korisnikForm);
        korisnikFacade.getKorisnikUlogaRepository().save(korisnikUloga);

        redirectAttributes.addFlashAttribute("registerSuccess", true);
        return "redirect:/prijava";
    }

    /**
     * Metoda koja služi za dohvaćanje forme za prijavu korisnika.
     * @param model objekt preko kojeg u html stranicu šaljemo formu za popunjavanje podataka o korisniku.
     * @return
     */
    @GetMapping("/prijava")
    public String getLoginForm(Model model){
        if (!model.containsAttribute("loginForm")) {
            model.addAttribute("loginForm", new LoginForm());
        }
        return "login";
    }

    /**
     * Metoda koja se poziva nakon što se klikne gumb za predaju forme za prijavu.
     * Provjerava da li postoje validacijske greške te ukoliko postoje ponovno se preusmjeri korisnika na ekran za popunjavanje forme
     * sa prikladnim porukama o greškama.
     * @param loginForm objekt koji predstavlja login formu
     * @param bindingResult objekt na koji se mapiraju validacijske greške
     * @param redirectAttributes objekt pomoću kojeg šaljemo podatke u zahtjevu za preusmjeravanje
     * @return forma za prijavu, u slučaju greške javlja gresku.
     */
    @PostMapping("/prijava")
    public String login(@ModelAttribute @Validated LoginForm loginForm,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginForm", bindingResult);
            redirectAttributes.addFlashAttribute("loginForm", loginForm);

            return "redirect:/prijava";
        }

        return "redirect:/love-me";
    }

    /**
     * Metoda koja služi za dohvaćanje pocetne stranice aplikacije LoveMe.
     * @return
     */
    @GetMapping("/love-me")
    public String getLandingPage() {
        return "landing";
    }

    /**
     * Metoda koja se poziva nakon što se klikne gumb za odjavu.
     * @return 
     */
    @PostMapping("/logout")
    public String logout() {

        SecurityContextHolder.getContext().getAuthentication();

        System.out.println("tu sam");
        return "redirect:/";
    }
}
