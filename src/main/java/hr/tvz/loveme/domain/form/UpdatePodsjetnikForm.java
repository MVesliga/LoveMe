package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UpdatePodsjetnikForm {

    private Integer id;
    private String naslov;
    private String ljubimac_ime;
    private String vrsta;
    private Date datum;
    private String vrijeme;
    private String naputak;
}
