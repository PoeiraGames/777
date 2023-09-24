package patoes.bet.patoes.bet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import patoes.bet.patoes.bet.model.ImagemModel;

import java.util.Optional;

@Repository
public interface ImagemRepository extends JpaRepository<ImagemModel, Long> {

    Optional<ImagemModel> findByCodigo(Long codigo);
}
