package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.KorisnikUloga;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface KorisnikUlogaRepository extends JpaRepository<KorisnikUloga, Integer> {
    @Transactional
    void deleteByKorisnickoIme(String korisnickoIme);
}
