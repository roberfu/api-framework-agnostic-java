package cl.stringmachine.infra.springboot.spi;

import cl.stringmachine.infra.springboot.spi.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardJpaRepository extends JpaRepository<CardEntity, Long> {
}
