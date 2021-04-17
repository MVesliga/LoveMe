package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class KorisnikConverter implements Converter<KorisnikForm, Korisnik> {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public Korisnik convert(KorisnikForm korisnikForm) {
        Korisnik korisnik = new Korisnik();
        korisnik.setIme(korisnikForm.getIme());
        korisnik.setPrezime(korisnikForm.getPrezime());
        try {
            if(korisnikForm.getDatumRodjenja() != null) {
                korisnik.setDatumRodjenja(new SimpleDateFormat("MM/dd/yyyy").parse(korisnikForm.getDatumRodjenja()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        korisnik.setEmail(korisnikForm.getEmail());
        korisnik.setKorisnickoIme(korisnikForm.getKorisnickoIme());
        korisnik.setLozinka(passwordEncoder.encode(korisnikForm.getLozinka()));
        return korisnik;
    }

    public KorisnikForm convertToForm(Korisnik korisnik) {
        KorisnikForm korisnikForm = new KorisnikForm();
        korisnikForm.setId(korisnik.getId());
        korisnikForm.setIme(korisnik.getIme());
        korisnikForm.setPrezime(korisnik.getPrezime());
        korisnikForm.setKorisnickoIme(korisnik.getKorisnickoIme());
        korisnikForm.setEmail(korisnik.getEmail());
        if(korisnik.getDatumRodjenja() != null) {
            korisnikForm.setDatumRodjenja(new SimpleDateFormat("MM/dd/yyyy").format(korisnik.getDatumRodjenja()));
        }

        return korisnikForm;
    }
}
