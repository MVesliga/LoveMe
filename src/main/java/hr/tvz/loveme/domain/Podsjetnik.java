package hr.tvz.loveme.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "podsjetnik")
public class Podsjetnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String naslov;
    @Column
    private String ljubimac_ime;
    @ManyToOne
    private Korisnik korisnik;
    @Column
    private String vrsta;
    @Column
    private Date datum;
    @Column
    private String vrijeme;
    @Column
    private String naputak;
}
