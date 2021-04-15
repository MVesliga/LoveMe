package hr.tvz.loveme.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "ljubimac")
public class Ljubimac {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String ime;
    @ManyToOne
    private Korisnik korisnik;
    @Column
    private String vrsta;
    @Column
    private Integer dob;
    @Column
    private Date veterinar;
    @Column
    private String hrana;
    @Column
    private String igracka;
    @Column
    private String cijepljen;
    @Column
    private String obuka;
}
