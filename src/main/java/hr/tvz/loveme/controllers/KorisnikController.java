package hr.tvz.loveme.controllers;

import hr.tvz.loveme.converter.KorisnikConverter;
import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.UpdateKorisnikForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

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
     * @param principal objekt pomocu kojeg se dohvacaju podaci trenutno ulogiranog korisnika
     * @return stranica sa prikazom detalja korisnika
     */
    @GetMapping("/profil")
    public String getProfil(Model model, Principal principal) {
        model.addAttribute("korisnik", korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName()));

        return "profil";
    }

    /**
     * Metoda koja se poziva nakon što se klikne gumb za azuriranje profila.
     * @param model objekt pomocu kojeg se korisnicki objekt salje u html template
     * @param principal objekt pomocu kojeg se dohvacaju podaci trenutno ulogiranog korisnika
     * @return stranica sa prikazom detalja korisnika za azuriranje
     */
    @GetMapping("/profil/update")
    public String getUpdateProfil(Model model, Principal principal) {
        if (!model.containsAttribute("updateKorisnikForm")) {
            Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
            UpdateKorisnikForm updateKorisnikForm = korisnikConverter.convertToForm(korisnik);
            model.addAttribute("updateKorisnikForm", updateKorisnikForm);
        }

        return "updateProfil";
    }

    /**
     * Metoda koja se poziva nakon što se klikne gumb za predaju forme za azuriranje profila.
     * @param updateKorisnikForm objekt koji predstavlja azuriranu korisničku formu
     * @param bindingResult objekt na koji se mapiraju validacijske greške
     * @param redirectAttributes objekt pomoću kojeg šaljemo podatke u zahtjevu za preusmjeravanje
     * @param principal objekt koji nam prikazuje koji je trenutni korisnik ulogiran
     * @return stranica sa prikazom detalja korisnika nakon azuriranja
     */

    @PostMapping("/profil/update")
    public String postUpadteProfil(@ModelAttribute @Valid UpdateKorisnikForm updateKorisnikForm,
                                   BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes,
                                   Principal principal) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateKorisnikForm", bindingResult);
            redirectAttributes.addFlashAttribute("updateKorisnikForm", updateKorisnikForm);

            return "redirect:/love-me/profil/update";
        }

        Korisnik editedKorisnik = korisnikConverter.convertUpdateKorisnikForm(updateKorisnikForm, korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName()));
        korisnikFacade.getKorisnikRepository().save(editedKorisnik);

        redirectAttributes.addFlashAttribute("updateProfilSuccess", true);
        return "redirect:/love-me/profil";
    }
}
