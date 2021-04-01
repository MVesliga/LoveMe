package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class KorisnikForm {

    private Integer id;
    @NotEmpty(message = "Ne valja ime")
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
    private String ponovljenaLozinka;
}
