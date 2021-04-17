package hr.tvz.loveme.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "korisnik_uloga")
public class KorisnikUloga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String korisnickoIme;
    @Column
    private String uloga;

    public KorisnikUloga(String korisnickoIme, String uloga) {
        this.korisnickoIme = korisnickoIme;
        this.uloga = uloga;
    }
}
