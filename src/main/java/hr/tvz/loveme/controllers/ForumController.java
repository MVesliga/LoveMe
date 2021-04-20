package hr.tvz.loveme.controllers;

import hr.tvz.loveme.domain.*;
import hr.tvz.loveme.domain.form.PodsjetnikForm;
import hr.tvz.loveme.domain.form.UpdatePodsjetnikForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import hr.tvz.loveme.repository.KomentarRepository;
import hr.tvz.loveme.repository.ObjavaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/love-me")
public class ForumController {

    KorisnikFacade korisnikFacade;
    private ObjavaRepository objavaRepository;
    private KomentarRepository komentarRepository;

    public ForumController(KorisnikFacade korisnikFacade,
                           ObjavaRepository objavaRepository,
                           KomentarRepository komentarRepository) {
        this.korisnikFacade = korisnikFacade;
        this.objavaRepository = objavaRepository;
        this.komentarRepository = komentarRepository;
    }

    /**
     * Metoda koja se poziva prilikom dohvacanja foruma ulogiranog korisnika.
     * @param model objekt pomocu kojeg se korisnicki objekt salje u html template
     * @return stranica sa prikazom foruma korisnika
     */
    @GetMapping("/forum")
    public String getForum(Model model, Principal principal) {
        List<Objava> objave = objavaRepository.findAll();
        List<Komentar> komentari = komentarRepository.findAll();

        model.addAttribute("objave", objave);
        model.addAttribute("komentari", komentari);
        model.addAttribute("ulogiraniKorisnik", principal.getName());

        return "forum";
    }

    /**
     * Metoda koja se poziva kada korisnik želi unjeti novi podsjetnik.
     *
     * @return forma za unos novog podsjetnika
     */
    @GetMapping(value = "/nova-objava")
    public String getObjavaForm(Model model, Principal principal) {
        if (!model.containsAttribute("objava")) {
            model.addAttribute("objava", new Objava());
        }

        return "novaObjava";
    }

    /**
     * Metoda koja se poziva prilikom predaje forme za unos novog podsjetnika
     * @param objava forma koja sadrži podatke novog podsjetnika
     *
     * @return preusmjerenje na listu podsjetnika
     */
    @PostMapping("/nova-objava")
    public String addObjava(@ModelAttribute @Valid Objava objava,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.objava", bindingResult);
            redirectAttributes.addFlashAttribute("objava", objava);

            return "redirect:/love-me/nova-objava";
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        objava.setKorisnik(korisnik);

        objavaRepository.save(objava);

        redirectAttributes.addFlashAttribute("createObjavaSuccess", true);
        return "redirect:/love-me/forum";
    }

    /**
     * Metoda koja se poziva prilikom uređivanja podataka na podsjetniku
     * @param id id podsjetnika kojeg uređujemo
     *
     * @return forma sa podacima podsjetnika
     */
    @GetMapping("/uredi-objavu")
    public String getObjavaEdit(@RequestParam(value = "id")Integer id, Model model, Principal principal){

        if (!model.containsAttribute("objava")) {
            Objava objava = objavaRepository.findById(id).get();
            model.addAttribute("objava", objava);
        }

        model.addAttribute("objava", model.getAttribute("objava"));

        return "urediObjavu";
    }

    /**
     * Metoda koja se poziva kada se predaje forma za uređivanje podsjetnika
     * @param objava forma sa uređenim podacima podsjetnika
     *
     * @return preusmjerenje na listu podsjetnika
     */
    @PostMapping("/uredi-objavu")
    public String editPodsjetnik(@ModelAttribute @Valid Objava objava,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Principal principal) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.objava", bindingResult);
            redirectAttributes.addFlashAttribute("objava", objava);

            return "redirect:/love-me/uredi-objavu";
        }

        Korisnik korisnik = korisnikFacade.getKorisnikRepository().findByKorisnickoIme(principal.getName());
        objava.setKorisnik(korisnik);
        objavaRepository.save(objava);

        redirectAttributes.addFlashAttribute("updateObjavaSuccess", true);
        return "redirect:/love-me/forum";
    }

    /**
     * Metoda koja se poziva prilikom klika na gumb za brisanje objave
     * @param objavaId id objave kojeg želimo obrisati
     *
     * @return preusmjerenje na listu podsjetnika
     */
    @GetMapping("/delete/objava")
    public String deletePodsjetnik(@RequestParam("objavaId") Integer objavaId,
                                   RedirectAttributes redirectAttributes){
        objavaRepository.deleteById(objavaId);

        redirectAttributes.addFlashAttribute("deleteObjavaSuccess", true);
        return "redirect:/love-me/forum";
    }
}
