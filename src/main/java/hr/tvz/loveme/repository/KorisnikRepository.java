package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
}
