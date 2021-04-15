package hr.tvz.loveme.facade;

import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import hr.tvz.loveme.repository.LjubimacRepository;

import java.util.List;

public interface LjubimacFacade {

    LjubimacRepository getLjubimacRepository();

    List<Ljubimac> findAll();
    Ljubimac findById(Integer id);
    void create(LjubimacForm ljubimacForm);
    void upade(LjubimacForm ljubimacForm);
    void delete(Integer id);
}