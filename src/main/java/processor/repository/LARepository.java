package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.LA;

public interface LARepository extends JpaRepository<LA, Long> {
}