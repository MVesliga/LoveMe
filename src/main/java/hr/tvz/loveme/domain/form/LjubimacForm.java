package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LjubimacForm {

    private Integer id;
    private String ime;
    @NotBlank(message = "{registracijaForm.imeLjubimca.notBlank}")
    private String vrsta;
    @NotBlank(message = "{registracijaForm.vrstaLjubimca.notBlank}")
    private Integer dob;
    @NotBlank(message = "{registracijaForm.dobLjubimca.notBlank}")
    private Date veterinar;
    private String hrana;
    private String igracka;
    private String cijepljen;
    private String obuka;
}
