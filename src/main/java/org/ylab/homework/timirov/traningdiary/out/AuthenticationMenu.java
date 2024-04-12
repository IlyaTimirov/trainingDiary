package org.ylab.homework.timirov.traningdiary.out;

import org.ylab.homework.timirov.traningdiary.service.AuthenticationService;

import java.util.Scanner;
/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Класс, предоставляющий методы для авторизации и регистрации пользователей.
 * */
public class AuthenticationMenu {
    private final Scanner scanner = new Scanner(System.in);

    private final AuthenticationService authenticationService = new AuthenticationService();

    public void login() {
        System.out.println("Авторизация");
        boolean isAuthentication;
        String username;
        do {
            System.out.println("Введите логин: ");
            username = scanner.nextLine();
            System.out.println("Введите пароль: ");
            String password = scanner.nextLine();

            isAuthentication = authenticationService.isAuthentication(username, password);

        } while (isAuthentication);
        authenticationService.authentication(username);
    }

    public void registration() {
        System.out.println("Регистрация");
        System.out.println("Введите логин: ");
        String username = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        authenticationService.registration(username, password);
    }
}
