package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Podsjetnik;
import hr.tvz.loveme.domain.form.PodsjetnikForm;
import hr.tvz.loveme.domain.form.UpdatePodsjetnikForm;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PodsjetnikConverter implements Converter<PodsjetnikForm, Podsjetnik> {

    @Override
    public Podsjetnik convert(PodsjetnikForm podsjetnikForm) {
        Podsjetnik podsjetnik = new Podsjetnik();
        podsjetnik.setNaslov(podsjetnikForm.getNaslov());
        podsjetnik.setKorisnik(podsjetnikForm.getKorisnik());
        podsjetnik.setLjubimac_ime(podsjetnikForm.getLjubimac_ime());
        podsjetnik.setVrsta(podsjetnikForm.getVrsta());
        podsjetnik.setDatum(podsjetnikForm.getDatum());
        podsjetnik.setVrijeme(podsjetnikForm.getVrijeme());
        podsjetnik.setNaputak(podsjetnikForm.getNaputak());
        return podsjetnik;
    }

    public Podsjetnik convertUpdatePodsjetnikForm(UpdatePodsjetnikForm updatePodsjetnikForm, Podsjetnik updatedPodsjetnik) {
        updatedPodsjetnik.setNaslov(updatePodsjetnikForm.getNaslov());
        updatedPodsjetnik.setLjubimac_ime(updatePodsjetnikForm.getLjubimac_ime());
        updatedPodsjetnik.setVrsta(updatePodsjetnikForm.getVrsta());
        updatedPodsjetnik.setDatum(updatePodsjetnikForm.getDatum());
        updatedPodsjetnik.setVrijeme(updatePodsjetnikForm.getVrijeme());
        updatedPodsjetnik.setNaputak(updatePodsjetnikForm.getNaputak());

        return updatedPodsjetnik;
    }

    public UpdatePodsjetnikForm convertToForm(Podsjetnik podsjetnik) {
        UpdatePodsjetnikForm updatePodsjetnikForm = new UpdatePodsjetnikForm();
        updatePodsjetnikForm.setId(podsjetnik.getId());
        updatePodsjetnikForm.setNaslov(podsjetnik.getNaslov());
        updatePodsjetnikForm.setLjubimac_ime(podsjetnik.getLjubimac_ime());
        updatePodsjetnikForm.setVrsta(podsjetnik.getVrsta());
        updatePodsjetnikForm.setDatum(podsjetnik.getDatum());
        updatePodsjetnikForm.setVrijeme(podsjetnik.getVrijeme());
        updatePodsjetnikForm.setNaputak(podsjetnik.getNaputak());

        return updatePodsjetnikForm;
    }
}
