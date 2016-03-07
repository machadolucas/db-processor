package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.PT;

public interface PTRepository extends JpaRepository<PT, Long> {
}