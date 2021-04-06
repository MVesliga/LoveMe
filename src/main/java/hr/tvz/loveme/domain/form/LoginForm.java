package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginForm {
    @NotBlank(message = "{loginForm.korisnickoIme.notBlank}")
    private String korisnickoIme;
    @NotBlank(message = "{loginForm.lozinka.notBlank}")
    private String lozinka;
}
