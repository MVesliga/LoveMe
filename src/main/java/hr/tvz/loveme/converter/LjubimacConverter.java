package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Ljubimac;
import hr.tvz.loveme.domain.form.LjubimacForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LjubimacConverter implements Converter<LjubimacForm, Ljubimac> {

    @Override
    public Ljubimac convert(LjubimacForm ljubimacForm) {
        Ljubimac ljubimac = new Ljubimac();
        ljubimac.setIme(ljubimacForm.getIme());
        ljubimac.setVrsta(ljubimacForm.getVrsta());
        ljubimac.setDob(ljubimacForm.getDob());
        ljubimac.setVeterinar(ljubimacForm.getVeterinar());
        ljubimac.setHrana(ljubimacForm.getHrana());
        ljubimac.setIgracka(ljubimacForm.getIgracka());
        ljubimac.setCijepljen(ljubimacForm.getCijepljen());
        ljubimac.setObuka(ljubimacForm.getObuka());
        return ljubimac;
    }
}
