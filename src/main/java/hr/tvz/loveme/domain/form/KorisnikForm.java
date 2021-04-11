package hr.tvz.loveme.domain.form;

import hr.tvz.loveme.validator.FieldsValueMatch;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldsValueMatch(field = "lozinka", fieldMatch = "ponovljenaLozinka", message = "{registracijaForm.fieldsValueMatch.lozinka}")
public class KorisnikForm {

    private Integer id;
    @NotBlank(message = "{registracijaForm.ime.notBlank}")
    private String ime;
    @NotBlank(message = "{registracijaForm.prezime.notBlank}")
    private String prezime;
    private String datumRodjenja;
    @NotBlank(message = "{registracijaForm.korisnickoIme.notBlank}")
    private String korisnickoIme;
    @NotBlank(message = "{registracijaForm.email.notBlank}")
    @Email(message = "{registracijaForm.email.format}")
    private String email;
    @NotBlank(message = "{registracijaForm.lozinka.notBlank}")
    private String lozinka;
    @NotBlank(message = "{registracijaForm.ponovljenaLozinka.notBlank}")
    private String ponovljenaLozinka;
}
