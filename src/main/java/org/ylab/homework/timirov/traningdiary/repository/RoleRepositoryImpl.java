package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Реализация интерфейса RoleRepository.
 */
public class RoleRepositoryImpl implements RoleRepository {

    public static void initRole(){
        roles.add(new Role("USER"));
        roles.add(new Role("ADMIN"));
    }
    @Override
    public List<Role> findBy(String role) {
        List<Role> roless = new ArrayList<>();
        for(Role r: roles){
            if(r.getRole().equals(role)){
                roless.add(r);
            }
        }
        return roless;
    }
}
