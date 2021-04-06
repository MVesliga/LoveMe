package hr.tvz.loveme.domain;

import lombok.*;

import javax.persistence.*;

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
    private String korisnickoIme;
    @Column
    private String email;
    @Column
    private String lozinka;
}
