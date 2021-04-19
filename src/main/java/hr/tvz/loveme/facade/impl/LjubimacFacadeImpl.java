package hr.tvz.loveme.facade.impl;

import hr.tvz.loveme.converter.LjubimacConverter;
import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import hr.tvz.loveme.facade.LjubimacFacade;
import hr.tvz.loveme.repository.LjubimacRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LjubimacFacadeImpl  implements LjubimacFacade {

    private LjubimacRepository ljubimacRepository;
    private LjubimacConverter ljubimacConverter;

    public LjubimacFacadeImpl(LjubimacRepository ljubimacRepository, LjubimacConverter ljubimacConverter) {
        this.ljubimacRepository = ljubimacRepository;
        this.ljubimacConverter = ljubimacConverter;
    }

    @Override
    public LjubimacRepository getLjubimacRepository() {
        return ljubimacRepository;
    }

    @Override
    public List<Ljubimac> findAll() {
        return ljubimacRepository.findAll();
    }

    @Override
    public Ljubimac findById(Integer id) {
        Optional<Ljubimac> ljubimacOptional = ljubimacRepository.findById(id);
        return ljubimacOptional.orElseGet(Ljubimac::new);
    }

    @Override
    public void create(LjubimacForm ljubimacForm) {
        Ljubimac ljubimac = ljubimacConverter.convert(ljubimacForm);
        ljubimacRepository.save(ljubimac);
    }

    @Override
    public void upade(LjubimacForm ljubimacForm) {

    }

    @Override
    public void delete(Integer id) {

    }
}