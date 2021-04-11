package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class KorisnikConverter implements Converter<KorisnikForm, Korisnik> {

    @Override
    public Korisnik convert(KorisnikForm korisnikForm) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(korisnikForm.getIme());
        korisnik.setPrezime(korisnikForm.getPrezime());
        try {
            korisnik.setDatumRodjenja(new SimpleDateFormat("yyyy-mm-dd").parse(korisnikForm.getDatumRodjenja()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        korisnik.setEmail(korisnikForm.getEmail());
        korisnik.setKorisnickoIme(korisnikForm.getKorisnickoIme());
        korisnik.setLozinka(korisnikForm.getLozinka());
        return korisnik;
    }
}
