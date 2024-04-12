package org.ylab.homework.timirov.traningdiary.out;

import org.ylab.homework.timirov.traningdiary.entity.Training;

import java.util.List;
import java.util.Map;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Класс, предоставляет методы для отрисовки информации о тренировках.
 */

public class RenderTraining {

    public void renderTraining(List<Training> trainings) {
        System.out.println("Ид");
        System.out.println("-".repeat(30));
        trainings.forEach(System.out::println);
        System.out.println("-".repeat(30));

    }

    public void renderStatistics(List<Training> trainings, Map<String, List<Integer>> types) {
        if (!trainings.isEmpty()) {
            final int indexDuration = 0;
            final int indexCalories = 1;
            for (String name : types.keySet()) {
                int duration = types.get(name).get(indexDuration);
                int calories = types.get(name).get(indexCalories);
                System.out.println("-".repeat(30));
                System.out.println("Тип: " + name);
                System.out.println("Время: " + duration);
                System.out.println("Калории: " + calories);
                System.out.println("-".repeat(30));
                System.out.println();
            }
        }
    }
}
