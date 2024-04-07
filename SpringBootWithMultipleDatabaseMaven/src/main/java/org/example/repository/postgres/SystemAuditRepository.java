package org.example.repository.postgres;


import org.example.domain.postgres.SystemAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAuditRepository extends JpaRepository<SystemAudit, Long> {
}
