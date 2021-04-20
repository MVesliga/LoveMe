package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Korisnik;
import hr.tvz.loveme.domain.Podsjetnik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PodsjetnikRepository extends JpaRepository<Podsjetnik, Integer> {
    @Override
    List<Podsjetnik> findAll();

    @Override
    Optional<Podsjetnik> findById(Integer id);

    List<Podsjetnik> findByKorisnik(Korisnik korisnik);
}