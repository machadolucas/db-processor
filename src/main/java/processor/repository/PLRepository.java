package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.PL;

public interface PLRepository extends JpaRepository<PL, Long> {
}