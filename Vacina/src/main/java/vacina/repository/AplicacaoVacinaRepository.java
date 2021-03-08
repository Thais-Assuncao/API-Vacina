package vacina.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vacina.entity.AplicacaoVacina;


@Repository
public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long> {


}