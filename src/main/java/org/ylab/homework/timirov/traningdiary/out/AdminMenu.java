package org.ylab.homework.timirov.traningdiary.out;

import org.ylab.homework.timirov.traningdiary.in.InputUser;
import org.ylab.homework.timirov.traningdiary.service.AdminActionMenuService;

public class AdminMenu {
    private final AdminActionMenuService adminActionMenuService = new AdminActionMenuService();
    private final InputUser inputUser = new InputUser();

    public void menu() {
        System.out.println("1 - Посмотреть действия пользователя");
        System.out.println("2 - Посмотреть тренировки пользователей");
        System.out.println("0 - Назад");

        int number = inputUser.inputNumber(2);

        switch (number) {
            case 1 -> adminActionMenuService.showAuditUsers();
            case 2 -> adminActionMenuService.showTrainingsUser();
        }
    }
}
