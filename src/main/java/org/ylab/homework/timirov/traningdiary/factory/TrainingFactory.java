package org.ylab.homework.timirov.traningdiary.factory;

import org.ylab.homework.timirov.traningdiary.entity.Cardio;
import org.ylab.homework.timirov.traningdiary.entity.Training;
import org.ylab.homework.timirov.traningdiary.entity.Yoga;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Фабрика тренировок.
 */
public class TrainingFactory {

    public static Training createTraining(String name) {
        Training training = null;
        switch (name.toUpperCase()) {
            case "КАРДИО" -> training = new Cardio();
            case "ЙОГА" -> training = new Yoga();
        }
        return training;
    }
}
