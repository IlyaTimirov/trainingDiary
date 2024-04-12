package org.ylab.homework.timirov.traningdiary.out;

import org.ylab.homework.timirov.traningdiary.entity.Role;
import org.ylab.homework.timirov.traningdiary.in.InputUser;
import org.ylab.homework.timirov.traningdiary.service.AuditService;


import static org.ylab.homework.timirov.traningdiary.Main.principal;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Класс Menu представляет собой меню приложения, отвечающее за отображение и управление главным меню.
 */
public class Menu {
    private final InputUser inputUser;
    private final static int MAX_NUMBER_MENU = 2;

    public Menu() {
        this.inputUser = new InputUser();
    }

    public void menu() {
        AuthenticationMenu authenticationMenu = new AuthenticationMenu();
        AuditService auditService = new AuditService();

        boolean isExit = true;
        while (isExit) {
            System.out.println("Добро пожаловать в приложение Дневник тренировок!");
            System.out.println("Введите цифру: ");
            System.out.println("1 - Авторизоваться");
            System.out.println("2 - Зарегистрироваться");
            System.out.println("0 - Выйти");

            int number = inputUser.inputNumber(MAX_NUMBER_MENU);

            switch (number) {
                case 1 -> {
                    authenticationMenu.login();
                    auditService.audit("Авторизовался");
                    userMenu();
                }
                case 2 -> {
                    authenticationMenu.registration();
                    authenticationMenu.login();
                    auditService.audit("Авторизовался");
                    userMenu();
                }
                case 0 -> {
                    isExit = false;
                    auditService.audit("Вышел");
                    principal = null;
                    System.out.println("До новых встреч...");
                }
            }
        }
    }

    public void userMenu() {
        AdminMenu adminMenu = new AdminMenu();
        TrainingMenu trainingMenu = new TrainingMenu();

        boolean isExit = true;

        while (isExit) {
            if (principal.getRoles().contains(new Role("ADMIN"))) {
                System.out.println("1 - Админ меню");
                System.out.println("2 - Пользовательское меню");
                System.out.println("0 - Выход");

                int number = inputUser.inputNumber(MAX_NUMBER_MENU);

                switch (number) {
                    case 1 -> adminMenu.menu();
                    case 2 -> trainingMenu.menu();
                    case 0 -> isExit = false;
                }
            } else {
                trainingMenu.menu();
                isExit = false;
            }
        }
    }
}
