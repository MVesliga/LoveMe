package hr.tvz.loveme.controllers;

import hr.tvz.loveme.converter.LjubimacConverter;
import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import hr.tvz.loveme.domain.form.UpdateLjubimacForm;
import hr.tvz.loveme.facade.LjubimacFacade;
import hr.tvz.loveme.facade.KorisnikFacade;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

@Controller
@RequestMapping("/love-me")
public class LjubimacController {

    private LjubimacFacade ljubimacFacade;
    private KorisnikFacade korisnikFacade;
    private LjubimacConverter ljubimacConverter;

    public LjubimacController(LjubimacFacade ljubimacFacade,
                              KorisnikFacade korisnikFacade,
                              LjubimacConverter ljubimacConverter) {
        this.ljubimacFacade = ljubimacFacade;
        this.korisnikFacade = korisnikFacade;
        this.ljubimacConverter = ljubimacConverter;
    }

    /**
     * Metoda koja se poziva prilikom dohvaćanja liste ljubimaca.
     *
     * @return stranica sa svim ljubimcima koje je korisnik unio
     */
    @GetMapping(value = "/moji-ljubimci")
    public String getLjubimci(Model model, Principal principal) {
        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        List<Ljubimac> listaLjubimaca = ljubimacFacade.getLjubimacRepository().findByKorisnik(korisnik);
        
        model.addAttribute("ljubimci", listaLjubimaca);
        return "moji_ljubimci";
    }

    /**
     * Metoda koja služi za dohvaćanje ljubimaca.
     * @return
     */
    @GetMapping("/ljubimac")
    public String getLjubimac(@RequestParam(value = "id")Integer id, Model model){
        Ljubimac ljubimac = ljubimacFacade.getLjubimacRepository().findById(id).get();

        model.addAttribute("ljubimac", ljubimac);
        return "ljubimac";
    }

    /**
     * Metoda koja služi za dohvaćanje forme za dodavanje novog ljubimca.
     * @return
     */
    @GetMapping("/novi-ljubimac")
    public String getLjubimacForm(Model model) {
        if (!model.containsAttribute("ljubimacForm")) {
            model.addAttribute("ljubimacForm", new LjubimacForm());
        }

        return "novi_ljubimac";
    }

    /**
     * Metoda koja se poziva prilikom predaje forme za kreiranje novog ljubimca
     * @return
     */
    @PostMapping("/novi-ljubimac")
    public String addLjubimac(@ModelAttribute @Valid LjubimacForm ljubimacForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes,
                                    Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ljubimacForm", bindingResult);
            redirectAttributes.addFlashAttribute("ljubimacForm", ljubimacForm);

            return "redirect:/love-me/novi-ljubimac";
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        ljubimacForm.setKorisnik(korisnik);

        ljubimacFacade.create(ljubimacForm);

        redirectAttributes.addFlashAttribute("createLjubimacSuccess", true);
        return "redirect:/love-me/moji-ljubimci";
    }

    /**
     * Metoda koja se poziva pirlikom klika na uređivanje podataka ljubimca
     * @param id id ljubimca čije podatke uređujemo
     * @return
     */
    @GetMapping("/uredi-ljubimca")
    public String getLjubimacEdit(@RequestParam(value = "id")Integer id, Model model){

        if (!model.containsAttribute("updateLjubimacForm")) {
            Ljubimac ljubimac = ljubimacFacade.getLjubimacRepository().findById(id).get();
            UpdateLjubimacForm updateLjubimacForm = ljubimacConverter.convertToForm(ljubimac);
            model.addAttribute("updateLjubimacForm", updateLjubimacForm);
        }

        model.addAttribute("updateLjubimacForm", model.getAttribute("updateLjubimacForm"));

        return "uredi_ljubimca";
    }

    /**
     * Metoda koja se poziva prilikom predaje forme sa uređenim podacima ljubimca
     * @param updateLjubimacForm forma sa uređenim podacima ljubimca
     * @return
     */
    @PostMapping("/uredi-ljubimca")
    public String editLjubimac(@ModelAttribute @Valid UpdateLjubimacForm updateLjubimacForm,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.updateLjubimacForm", bindingResult);
            redirectAttributes.addFlashAttribute("updateLjubimacForm", updateLjubimacForm);

            return "redirect:/love-me/uredi-ljubimca";
        }
        Ljubimac ljubimac = ljubimacFacade.getLjubimacRepository().findById(updateLjubimacForm.getId()).get();

        Ljubimac editedLjubimac = ljubimacConverter.convertUpdateLjubimacForm(updateLjubimacForm, ljubimac);
        ljubimacFacade.getLjubimacRepository().save(editedLjubimac);

        redirectAttributes.addFlashAttribute("updateLjubimacSuccess", true);
        return "redirect:/love-me/moji-ljubimci";
    }

    /**
     * Metoda koja se poziva prilikom klika na gumb za brisanje ljubimca.
     * @param ljubimacId id ljubimca kojeg želimo obrisati
     * @return
     */
    @GetMapping("/delete/ljubimac")
    public String deleteLjubimac(@RequestParam("ljubimacId") Integer ljubimacId,
                                 RedirectAttributes redirectAttributes){
        ljubimacFacade.getLjubimacRepository().deleteById(ljubimacId);

        redirectAttributes.addFlashAttribute("deleteLjubimacSuccess", true);
        return "redirect:/love-me/moji-ljubimci";
    }
}
