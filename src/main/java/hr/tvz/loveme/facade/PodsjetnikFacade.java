package hr.tvz.loveme.facade;

import hr.tvz.loveme.domain.Podsjetnik;
import hr.tvz.loveme.domain.form.PodsjetnikForm;
import hr.tvz.loveme.repository.PodsjetnikRepository;

import java.util.List;

public interface PodsjetnikFacade {

    PodsjetnikRepository getPodsjetnikRepository();

    List<Podsjetnik> findAll();
    Podsjetnik findById(Integer id);
    void create(PodsjetnikForm podsjetnikForm);
    void upade(PodsjetnikForm podsjetnikForm);
    void delete(Integer id);
}