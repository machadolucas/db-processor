package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.PHST;

public interface PHSTRepository extends JpaRepository<PHST, Long> {
}