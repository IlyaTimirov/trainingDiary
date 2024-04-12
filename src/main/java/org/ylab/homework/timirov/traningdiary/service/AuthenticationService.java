package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.UsernameNotFoundException;

import static org.ylab.homework.timirov.traningdiary.Main.principal;


/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Класс отвечает за авторизацию и регистрацию пользователей.
 */
public class AuthenticationService {
    private final UserService userService;

    public AuthenticationService() {
        this.userService = new UserService();
    }

    public boolean isAuthentication(String username, String password) {
        boolean isAuthentication = false;
        try {
            User user = userService.findByUsername(username);
            if (!user.getPassword().equals(password)) {
                System.out.println("Неправильный пароль!");
                isAuthentication = true;
            }
        } catch (UsernameNotFoundException e) {
            System.out.println(e.getMessage());
            isAuthentication = true;
        }
        return isAuthentication;
    }

    public void registration(String username, String password) {
        User user = new User(username, password);
        userService.save(user);
    }

    public void authentication(String username){
        principal = userService.findByUsername(username);
    }

}
