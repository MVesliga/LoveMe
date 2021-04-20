package hr.tvz.loveme.domain;

import lombok.*;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "komentar")
public class Komentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Korisnik korisnik;
    @ManyToOne
    private Objava objava;
    @Column
    private String sadrzaj;
    @Column
    private Date datumKomentara;
}
