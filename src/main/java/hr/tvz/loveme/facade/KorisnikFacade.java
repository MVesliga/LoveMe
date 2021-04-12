package hr.tvz.loveme.facade;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;

import java.util.List;

public interface KorisnikFacade {
    List<Korisnik> findAll();
    Korisnik findById(Integer id);
    void create(KorisnikForm korisnikForm);
    void upade(KorisnikForm korisnikForm);
    void delete(Integer id);
}
