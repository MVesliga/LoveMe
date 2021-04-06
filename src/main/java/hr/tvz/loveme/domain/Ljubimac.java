package hr.tvz.loveme.domain;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Ljubimac {
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
