package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.Abstract;

public interface AbstractRepository extends JpaRepository<Abstract, Long> {
}
