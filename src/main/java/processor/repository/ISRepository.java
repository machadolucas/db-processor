package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.IS;

public interface ISRepository extends JpaRepository<IS, Long> {
}