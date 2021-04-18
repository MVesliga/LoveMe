package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Korisnik;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface KorisnikRepository extends CrudRepository<Korisnik, Integer> {
    @Override
    List<Korisnik> findAll();

    @Override
    Optional<Korisnik> findById(Integer integer);

    Korisnik findByKorisnickoIme(String korisnickoIme);

    @Transactional
    @Modifying
    @Query("update Korisnik k set k = :korisnik where k.id = :id")
    void update(@Param("id") Integer id, @Param("korisnik") Korisnik korisnik);
}
