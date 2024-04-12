package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Audit;
import org.ylab.homework.timirov.traningdiary.entity.Training;

import java.util.ArrayList;
import java.util.List;

import static org.ylab.homework.timirov.traningdiary.Main.principal;

public class AuditRepositoryImpl implements AuditRepository{
    @Override
    public void save(Audit audit) {
        List<Audit> userAudits = findAll();
        userAudits.add(audit);
        audits.put(principal, userAudits);
    }

    @Override
    public List<Audit> findAll() {
        List<Audit> userAudits = audits.get(principal);
        if(userAudits == null){
            return new ArrayList<>();
        }
        return userAudits;
    }
}
