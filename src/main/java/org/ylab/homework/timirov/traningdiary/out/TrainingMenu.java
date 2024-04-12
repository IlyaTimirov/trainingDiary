package org.ylab.homework.timirov.traningdiary.out;

import org.ylab.homework.timirov.traningdiary.service.TrainingActionMenuService;
import org.ylab.homework.timirov.traningdiary.in.InputUser;

import static org.ylab.homework.timirov.traningdiary.Main.principal;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Класс представляет собой меню для отображения и управления тренировками.
 */
public class TrainingMenu {
    private final TrainingActionMenuService trainingActionMenuService;
    private final InputUser inputUser;
    private final static int MAX_NUMBER_MENU = 5;

    public TrainingMenu() {
        this.trainingActionMenuService = new TrainingActionMenuService();
        this.inputUser = new InputUser();
    }

    public void menu() {
        boolean isExit = true;
        while (isExit) {
            System.out.println("1 - Добавить тренировку");
            System.out.println("2 - Удалить тренировку");
            System.out.println("3 - Редактировать тренировку");
            System.out.println("4 - Список прошедших тренировок");
            System.out.println("5 - Статистика по тренировкам");
            System.out.println("0 - Выход");

            int number = inputUser.inputNumber(MAX_NUMBER_MENU);

            switch (number) {
                case 1 -> trainingActionMenuService.addTraining();
                case 2 -> trainingActionMenuService.removeTraining();
                case 3 -> trainingActionMenuService.updateTraining();
                case 4 -> trainingActionMenuService.getAllTrainings(principal);
                case 5 -> trainingActionMenuService.showStatisticsTraining();
                case 0 -> isExit = false;
            }
        }
    }
}
