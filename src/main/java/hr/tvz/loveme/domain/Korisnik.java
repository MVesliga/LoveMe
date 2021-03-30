package hr.tvz.loveme.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Korisnik {
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String email;
    private String lozinka;
}
