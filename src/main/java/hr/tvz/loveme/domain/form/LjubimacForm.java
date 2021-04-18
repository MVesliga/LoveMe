package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class LjubimacForm {

    private Integer id;
    private String ime;
    private String vrsta;
    private Integer dob;
    private Date veterinar;
    private String hrana;
    private String igracka;
    private String cijepljen;
    private String obuka;
}
