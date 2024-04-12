package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.Audit;
import org.ylab.homework.timirov.traningdiary.repository.AuditRepository;
import org.ylab.homework.timirov.traningdiary.repository.AuditRepositoryImpl;

import java.time.LocalDateTime;
import java.util.List;

public class AuditService {
    private final AuditRepository auditRepository = new AuditRepositoryImpl();


    public void d(){

    }

    public void audit(String action){
        auditRepository.save(new Audit(action, LocalDateTime.now()));
    }

    public List<Audit> getAll(){
        return auditRepository.findAll();
    }
}
