package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Training;
import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.TrainingIdNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.ylab.homework.timirov.traningdiary.Main.principal;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Реализация интерфейса TrainingRepository.
 */
public class TrainingRepositoryImpl implements TrainingRepository {
    public void save(Training training) {
        training.setId(trainingsUsers.size());
        List<Training> trainings = trainingsUsers.get(principal);
        if (trainings == null) {
            trainings = new ArrayList<>();
        }
        trainings.add(training);
        trainingsUsers.put(principal, trainings);
    }

    public void remove(int id) {
        List<Training> trg = trainingsUsers.get(principal);
        if (trg.size() <= id || id < 0) {
            throw new TrainingIdNotFoundException(id);
        }
        trainingsUsers.get(principal).remove(id);
    }

    public List<Training> findAll(User user) {
        List<Training> trainings = trainingsUsers.get(user);
        return trainings == null ? new ArrayList<>() : trainings;
    }

    public Optional<Training> findById(int id) {
        List<Training> trainings = findAll(principal);
        Training training;
        if (id > trainings.size()) {
            training = null;
        } else {
            training = trainingsUsers.get(principal).get(id);
        }
        return Optional.ofNullable(training);
    }

    public void update(Training training) {
        List<Training> trainings = trainingsUsers.get(principal);
        trainings.set(training.getId(), training);
        trainingsUsers.put(principal, trainings);
    }

    public boolean findByDateAndName(String name, LocalDate date) {
        List<Training> trainings = trainingsUsers.get(principal);
        if (trainings != null) {
            return !trainings.stream()
                    .filter(training -> training.getDate().equals(date))
                    .filter(training -> training.getName().equals(name))
                    .toList()
                    .isEmpty();
        }
        return false;
    }
}
