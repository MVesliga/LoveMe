package hr.tvz.loveme.facade;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.repository.KorisnikRepository;
import hr.tvz.loveme.repository.KorisnikUlogaRepository;

import java.util.List;

public interface KorisnikFacade {

    KorisnikRepository getKorisnikRepository();
    KorisnikUlogaRepository getKorisnikUlogaRepository();

    List<Korisnik> findAll();
    Korisnik findById(Integer id);
    void create(KorisnikForm korisnikForm);
    void upade(KorisnikForm korisnikForm);
    void delete(Integer id);
}
