package org.ylab.homework.timirov.traningdiary.in;

import org.ylab.homework.timirov.traningdiary.service.TrainingService;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.ylab.homework.timirov.traningdiary.factory.TrainingFactory.createTraining;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Класс для ввода данных от пользователя.
 */

public class InputUser {
    private final Scanner scanner;

    private final TrainingService trainingService;

    public InputUser() {
        this.scanner = new Scanner(System.in);
        this.trainingService = new TrainingService();
    }

    public String inputName(LocalDate date) {
        String name = "";
        boolean isValidName = true;

        while (isValidName) {
            name = scanner.nextLine();
            if (!isValidName(name)) {
                System.out.println("Такого типа тренировки в нашей базе нету, повторите ввод:");
            } else if (trainingService.findByDateAndType(name, date)) {
                System.out.println("Тренировку одного типа можно заносить раз в день.");
            } else {
                isValidName = false;
            }
        }
        return name;
    }

    public LocalDate inputDate() {
        while (true) {
            try {
                return LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeException e) {
                System.out.println("Введите корректную дату! (2023-03-03)");
            }
        }
    }

    public int inputNumbers() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Вводить можно только цифры!");
                scanner.nextLine();
            }
        }
    }

    public int inputNumber(int maxNumber) {
        System.out.print("Введите цифру: ");
        while (true) {
            try {
                int number = scanner.nextInt();
                if (number > maxNumber || number < 0) {
                    System.out.println("Введите цифру от 0 до " + maxNumber);
                } else {
                    return number;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вводить можно только цифры!");
                scanner.nextLine();
            }
        }
    }

    public int inputId() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Вводить можно только цифры!");
                scanner.nextLine();
            }
        }
    }

    private boolean isValidName(String name) {
        return createTraining(name) != null;
    }
}
