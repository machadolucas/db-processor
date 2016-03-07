package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.AID;

public interface AIDRepository extends JpaRepository <AID, Long> {
}