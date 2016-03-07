package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.GR;

public interface GRRepository extends JpaRepository<GR, Long> {
}