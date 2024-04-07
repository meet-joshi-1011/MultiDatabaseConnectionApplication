package org.example.service;

import org.example.domain.postgres.SystemAudit;
import org.example.repository.postgres.SystemAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemAuditService {
    @Autowired
    private SystemAuditRepository systemAuditRepository;

    public SystemAudit findById(Long id)
    {
        return systemAuditRepository.findById(id).orElse(null);
    }
}
