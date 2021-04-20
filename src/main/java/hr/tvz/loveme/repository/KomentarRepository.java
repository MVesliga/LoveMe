package hr.tvz.loveme.repository;

import hr.tvz.loveme.domain.Komentar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KomentarRepository extends JpaRepository<Komentar, Integer> {
}
