package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import hr.tvz.loveme.domain.form.UpdateLjubimacForm;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LjubimacConverter implements Converter<LjubimacForm, Ljubimac> {

    @Override
    public Ljubimac convert(LjubimacForm ljubimacForm) {
        Ljubimac ljubimac = new Ljubimac();
        ljubimac.setIme(ljubimacForm.getIme());
        ljubimac.setKorisnik(ljubimacForm.getKorisnik());
        ljubimac.setVrsta(ljubimacForm.getVrsta());
        ljubimac.setDob(ljubimacForm.getDob());
        ljubimac.setVeterinar(ljubimacForm.getVeterinar());
        ljubimac.setHrana(ljubimacForm.getHrana());
        ljubimac.setIgracka(ljubimacForm.getIgracka());
        ljubimac.setCijepljen(ljubimacForm.getCijepljen());
        ljubimac.setObuka(ljubimacForm.getObuka());
        return ljubimac;
    }

    public static Ljubimac convertUpdateLjubimacForm(UpdateLjubimacForm updateLjubimacForm, Ljubimac updatedLjubimac) {
        updatedLjubimac.setIme(updateLjubimacForm.getIme());
        updatedLjubimac.setVrsta(updateLjubimacForm.getVrsta());
        updatedLjubimac.setVeterinar(updateLjubimacForm.getVeterinar());
        updatedLjubimac.setDob(updateLjubimacForm.getDob());
        updatedLjubimac.setCijepljen(updateLjubimacForm.getCijepljen());
        updatedLjubimac.setHrana(updateLjubimacForm.getHrana());
        updatedLjubimac.setIgracka(updateLjubimacForm.getIgracka());
        updatedLjubimac.setObuka(updateLjubimacForm.getObuka());

        return updatedLjubimac;
    }

    public UpdateLjubimacForm convertToForm(Ljubimac ljubimac) {
        UpdateLjubimacForm updateLjubimacForm = new UpdateLjubimacForm();
        updateLjubimacForm.setIme(ljubimac.getIme());
        updateLjubimacForm.setVrsta(ljubimac.getVrsta());
        updateLjubimacForm.setDob(ljubimac.getDob());
        updateLjubimacForm.setVeterinar(ljubimac.getVeterinar());
        updateLjubimacForm.setHrana(ljubimac.getHrana());
        updateLjubimacForm.setIgracka(ljubimac.getIgracka());
        updateLjubimacForm.setObuka(ljubimac.getObuka());
        updateLjubimacForm.setCijepljen(ljubimac.getCijepljen());

        return updateLjubimacForm;
    }
}
