package hr.tvz.loveme.converter;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.form.KorisnikForm;
import hr.tvz.loveme.domain.form.UpdateKorisnikForm;
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

    public Korisnik convertUpdateKorisnikForm(UpdateKorisnikForm updateKorisnikForm, Korisnik updatedKorisnik) {
        updatedKorisnik.setIme(updateKorisnikForm.getIme());
        updatedKorisnik.setPrezime(updateKorisnikForm.getPrezime());
        try {
            if(updateKorisnikForm.getDatumRodjenja() != null) {
                updatedKorisnik.setDatumRodjenja(new SimpleDateFormat("MM/dd/yyyy").parse(updateKorisnikForm.getDatumRodjenja()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        updatedKorisnik.setEmail(updateKorisnikForm.getEmail());

        return updatedKorisnik;
    }

    public UpdateKorisnikForm convertToForm(Korisnik korisnik) {
        UpdateKorisnikForm updateKorisnikForm = new UpdateKorisnikForm();
        updateKorisnikForm.setId(korisnik.getId());
        updateKorisnikForm.setIme(korisnik.getIme());
        updateKorisnikForm.setPrezime(korisnik.getPrezime());
        updateKorisnikForm.setKorisnickoIme(korisnik.getKorisnickoIme());
        updateKorisnikForm.setEmail(korisnik.getEmail());
        if(korisnik.getDatumRodjenja() != null) {
            updateKorisnikForm.setDatumRodjenja(new SimpleDateFormat("MM/dd/yyyy").format(korisnik.getDatumRodjenja()));
        }

        return updateKorisnikForm;
    }
}
