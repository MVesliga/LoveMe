package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KorisnikRepository extends JpaRepository<Korisnik, Integer> {
    @Override
    List<Korisnik> findAll();

    @Override
    Optional<Korisnik> findById(Integer integer);
}
