package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdateLjubimacForm {

    private Integer id;
    @NotBlank(message = "{registracijaForm.imeLjubimca.notBlank}")
    private String ime;
    @NotBlank(message = "{registracijaForm.vrstaLjubimca.notBlank}")
    private String vrsta;
    @NotNull(message = "{registracijaForm.dobLjubimca.notBlank}")
    private Integer dob;
    private Date veterinar;
    private String hrana;
    private String igracka;
    private String cijepljen;
    private String obuka;
    private String najdrazaHrana;
    private String najdrazaIgracka;
}
