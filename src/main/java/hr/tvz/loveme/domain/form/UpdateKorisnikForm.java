package hr.tvz.loveme.domain.form;

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
public class UpdateKorisnikForm {

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
}
