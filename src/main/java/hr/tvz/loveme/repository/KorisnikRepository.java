package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    @Override
    List<Korisnik> findAll();

    @Override
    Optional<Korisnik> findById(Integer integer);

    Korisnik findByKorisnickoIme(String korisnickoIme);
}
