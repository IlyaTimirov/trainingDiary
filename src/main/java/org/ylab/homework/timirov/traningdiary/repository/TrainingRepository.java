package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Training;
import org.ylab.homework.timirov.traningdiary.entity.User;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Интерфейс TrainingRepository представляет собой репозиторий для хранения тренировок.
 * */

public interface TrainingRepository {
    Map<User, List<Training>> trainingsUsers = new HashMap<>();

    void save(Training training);
    void remove(int id);

    List<Training> findAll(User user);

    Optional<Training> findById(int id);

    void update(Training training);

    boolean findByDateAndName(String name, LocalDate date);
}
