package cl.stringmachine.infra.adapters.outbound;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaRepositoryAdapter extends JpaRepository<CardEntity, Long> {
}
