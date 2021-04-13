package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Ljubimac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LjubimacRepository extends JpaRepository<Ljubimac, Integer> {
    @Override
    List<Ljubimac> findAll();

    @Override
    Optional<Ljubimac> findById(Integer integer);
}
