package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.UserIdNotFoundException;
import org.ylab.homework.timirov.traningdiary.exception.UsernameNotFoundException;
import org.ylab.homework.timirov.traningdiary.repository.RoleRepository;
import org.ylab.homework.timirov.traningdiary.repository.RoleRepositoryImpl;
import org.ylab.homework.timirov.traningdiary.repository.UserRepository;
import org.ylab.homework.timirov.traningdiary.repository.UserRepositoryImpl;

import java.util.List;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Класс предназначен для работы с пользователями.
 */
public class UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;
    public UserService() {
        this.userRepository = new UserRepositoryImpl();
        this.roleRepository = new RoleRepositoryImpl();
    }

    public User findByUsername(String username) throws UsernameNotFoundException{
        return userRepository.findByUsername(username).orElseThrow(UsernameNotFoundException::new);
    }

    public User getById(int id) throws UserIdNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
    }
    public void save(User user){
        user.setRoles(roleRepository.findBy("USER"));
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
