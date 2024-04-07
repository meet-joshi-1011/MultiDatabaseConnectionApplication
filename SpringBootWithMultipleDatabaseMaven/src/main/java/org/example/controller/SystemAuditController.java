package org.example.controller;

import org.example.domain.postgres.SystemAudit;
import org.example.service.SystemAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/system-audit")
public class SystemAuditController {

    @Autowired
    private SystemAuditService systemAuditService;

    @GetMapping("/{id}")
    public SystemAudit findBrandsMappingById(@PathVariable(name = "id") Long id)
    {
        return systemAuditService.findById(id);
    }
}
