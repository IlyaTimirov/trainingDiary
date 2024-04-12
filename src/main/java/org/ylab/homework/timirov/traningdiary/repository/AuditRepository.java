package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Audit;
import org.ylab.homework.timirov.traningdiary.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AuditRepository {

    Map<User, List<Audit>> audits = new HashMap<>();


    void save(Audit audit);

    List<Audit> findAll();
}
