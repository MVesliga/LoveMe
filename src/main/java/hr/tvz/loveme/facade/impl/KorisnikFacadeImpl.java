package hr.tvz.loveme.facade.impl;

import hr.tvz.loveme.converter.KorisnikConverter;
import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.facade.KorisnikFacade;
import hr.tvz.loveme.repository.KorisnikRepository;
import hr.tvz.loveme.repository.KorisnikUlogaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KorisnikFacadeImpl  implements KorisnikFacade {

    private KorisnikRepository korisnikRepository;
    private KorisnikUlogaRepository korisnikUlogaRepository;
    private KorisnikConverter korisnikConverter;

    public KorisnikFacadeImpl(KorisnikRepository korisnikRepository,
                              KorisnikUlogaRepository korisnikUlogaRepository,
                              KorisnikConverter korisnikConverter) {
        this.korisnikRepository = korisnikRepository;
        this.korisnikUlogaRepository = korisnikUlogaRepository;
        this.korisnikConverter = korisnikConverter;
    }

    @Override
    public KorisnikRepository getKorisnikRepository() {
        return korisnikRepository;
    }

    @Override
    public KorisnikUlogaRepository getKorisnikUlogaRepository() {
        return korisnikUlogaRepository;
    }

    @Override
    public List<Korisnik> findAll() {
        return korisnikRepository.findAll();
    }

    @Override
    public Korisnik findById(Integer id) {
        Optional<Korisnik> korisnikOptional = korisnikRepository.findById(id);
        return korisnikOptional.orElseGet(Korisnik::new);
    }

    @Override
    public void create(KorisnikForm korisnikForm) {
        Korisnik korisnik = korisnikConverter.convert(korisnikForm);
        korisnikRepository.save(korisnik);
    }

    @Override
    public void upade(KorisnikForm korisnikForm) {

    }

    @Override
    public void delete(Integer id) {

    }
}
