package hr.tvz.loveme.facade.impl;

import hr.tvz.loveme.converter.PodsjetnikConverter;
import hr.tvz.loveme.domain.Podsjetnik;
import hr.tvz.loveme.domain.form.PodsjetnikForm;
import hr.tvz.loveme.facade.PodsjetnikFacade;
import hr.tvz.loveme.repository.PodsjetnikRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PodsjetnikFacadeImpl  implements PodsjetnikFacade {

    private PodsjetnikRepository podsjetnikRepository;
    private PodsjetnikConverter podsjetnikConverter;

    public PodsjetnikFacadeImpl(PodsjetnikRepository podsjetnikRepository, PodsjetnikConverter podsjetnikConverter) {
        this.podsjetnikRepository = podsjetnikRepository;
        this.podsjetnikConverter = podsjetnikConverter;
    }

    @Override
    public PodsjetnikRepository getPodsjetnikRepository() {
        return podsjetnikRepository;
    }

    @Override
    public List<Podsjetnik> findAll() {
        return podsjetnikRepository.findAll();
    }

    @Override
    public Podsjetnik findById(Integer id) {
        Optional<Podsjetnik> podsjetnikOptional = podsjetnikRepository.findById(id);
        return podsjetnikOptional.orElseGet(Podsjetnik::new);
    }

    @Override
    public void create(PodsjetnikForm podsjetnikForm) {
        Podsjetnik podsjetnik = podsjetnikConverter.convert(podsjetnikForm);
        podsjetnikRepository.save(podsjetnik);
    }

    @Override
    public void upade(PodsjetnikForm podsjetnikForm) {

    }

    @Override
    public void delete(Integer id) {

    }
}