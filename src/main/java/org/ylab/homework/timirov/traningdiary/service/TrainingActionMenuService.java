package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.Training;
import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.TrainingIdNotFoundException;
import org.ylab.homework.timirov.traningdiary.out.RenderTraining;
import org.ylab.homework.timirov.traningdiary.in.InputUser;
import org.ylab.homework.timirov.traningdiary.util.ExecuteUtil;

import java.time.LocalDate;

import static org.ylab.homework.timirov.traningdiary.Main.principal;
import static org.ylab.homework.timirov.traningdiary.factory.TrainingFactory.createTraining;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Сервис для работы с меню действий тренировок.
 */

public class TrainingActionMenuService {
    private final TrainingService trainingService;

    private final RenderTraining renderTraining;

    private final InputUser inputUser;

    private final AuditService auditService;

    private final ExecuteUtil execute;

    public TrainingActionMenuService() {
        this.trainingService = new TrainingService();
        this.renderTraining = new RenderTraining();
        this.inputUser = new InputUser();
        this.auditService = new AuditService();
        this.execute = new ExecuteUtil();
    }

    public void addTraining() {
        System.out.println("Пример ввода тренировки!");
        System.out.println("-".repeat(30));
        System.out.println("Дата: 2023-01-28");
        System.out.println("Тип: Йога");
        System.out.println("Длительность: 60 (записывается в минутах)");
        System.out.println("Потраченные калории: 130");
        System.out.println("-".repeat(30));

        execute.executeWithCustomBack(back -> {
            System.out.print("Дата: ");
            LocalDate date = inputUser.inputDate();

            System.out.print("Тип: ");
            String name = inputUser.inputName(date);

            System.out.print("Длительность: ");
            int duration = inputUser.inputNumbers();

            System.out.print("Потраченные калории: ");
            int calories = inputUser.inputNumbers();

            Training training = createTraining(name);
            training.setDate(date);
            training.setName(name);
            training.setDurationTraining(duration);
            training.setCaloriesBurned(calories);
            trainingService.save(training);
            System.out.println("Тренировка записана");
            System.out.println("0 - назад");
            System.out.println("1 - добавить тренировку");

            auditService.audit("Добавил тренировку");
            return execute.inputBackOption();
        });
    }

    public void removeTraining() {
        execute.executeWithCustomBack(back -> {
            getAllTrainings(principal);
            System.out.print("Введите ид тренировки: ");

            int id = inputUser.inputId();

            try {
                trainingService.remove(id);

                System.out.println("Тренировка удалена");
                auditService.audit("Удалил тренировку");

            } catch (TrainingIdNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("0 - назад");
            System.out.println("1 - удалить тренировку");

            return execute.inputBackOption();
        });
    }

    public void showStatisticsTraining() {
        renderTraining.renderStatistics(trainingService.findAll(principal), trainingService.getStatistics());
        auditService.audit("Посмотрел статистику тренировок");

    }

    public void getAllTrainings(User user) {
        renderTraining.renderTraining(trainingService.findAll(user));
        auditService.audit("Посмотрел предыдущие тренировки");


    }

    public void updateTraining() {
        execute.executeWithCustomBack(back -> {
            getAllTrainings(principal);

            System.out.println("Выберите ид тренировки для изменении");

            try {
                int id = inputUser.inputId();

                Training training = trainingService.getById(id);

                System.out.println("Выберите что хотите обновить!");
                System.out.println("1 - Длительность");
                System.out.println("2 - Потраченые калории");

                int number = inputUser.inputNumber(2);

                System.out.println("Введите обновление: ");

                switch (number) {
                    case 1 -> training.setDurationTraining(inputUser.inputNumbers());
                    case 2 -> training.setCaloriesBurned(inputUser.inputNumbers());
                }

                trainingService.update(training);

                System.out.println("Изменения внесены");

                auditService.audit("Обновил тренировку");
            } catch (TrainingIdNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("0 - назад");
            System.out.println("1 - внести изменения");

            return execute.inputBackOption();
        });
    }
}
