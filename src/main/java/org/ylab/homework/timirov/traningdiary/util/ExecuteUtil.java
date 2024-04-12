package org.ylab.homework.timirov.traningdiary.util;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Function;

public class ExecuteUtil {
    private final Scanner scanner = new Scanner(System.in);

    public boolean inputBackOption() {
        while (true) {
            try {
                int back = scanner.nextInt();
                if (back > 1 || back < 0) {
                    System.out.println("Введите цифру 0 или 1");
                } else {
                    return back != 0;
                }
            } catch (InputMismatchException e) {
                System.out.println("Вводить можно только цифры!");
                scanner.nextLine();
            }
        }
    }

    public void executeWithCustomBack(Function<Boolean, Boolean> back) {
        boolean isBack = true;
        while (isBack) {
            isBack = back.apply(true);
        }
    }
}
