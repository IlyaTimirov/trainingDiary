package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Role;
import org.ylab.homework.timirov.traningdiary.entity.User;

import java.util.List;
import java.util.Optional;


/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Реализация интерфейса UserRepository.
 */
public class UserRepositoryImpl implements UserRepository{

    public static void initAdmin(){
        users.add(new User(0L, "admin", "admin", List.of(new Role("ADMIN"), new Role("USER"))));
    }
    public Optional<User> findByUsername(String username) {
        User user = null;
        for (User usr : users){
            if(usr.getUsername().equals(username)){
                user = usr;
            }
        }
        return Optional.ofNullable(user);
    }

    public void save(User user){
        user.setId((long) (users.size()));
        users.add(user);
    }

    public List<User> findAll(){
        return users;
    }

    public Optional<User> findById(int id){
        List<User> users = findAll();
        User user;
        if (id > users.size()) {
            user = null;
        } else {
            user = users.get(id);
        }
        return Optional.ofNullable(user);
    }
}
