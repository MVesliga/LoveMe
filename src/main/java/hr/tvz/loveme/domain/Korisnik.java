package hr.tvz.loveme.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String ime;
    @Column
    private String prezime;
    @Column
    private Date datumRodjenja;
    @Column
    private String korisnickoIme;
    @Column
    private String email;
    @Column
    private String lozinka;
}
