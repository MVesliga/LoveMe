package hr.tvz.loveme.domain.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

import hr.tvz.loveme.domain.Korisnik;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class PodsjetnikForm {

    private Integer id;
    private Korisnik korisnik;
    private String ljubimac_ime;
    private String naslov;
    private String vrsta;
    private Date datum;
    private String vrijeme;
    private String naputak;
}
