package processor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import processor.entity.MH;

public interface MHRepository extends JpaRepository<MH, Long> {
}