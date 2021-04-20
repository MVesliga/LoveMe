package hr.tvz.loveme.domain;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "objava")
public class Objava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Korisnik korisnik;
    @Column
    private String sadrzaj;
    @Column
    private Date datumObjave;
}
