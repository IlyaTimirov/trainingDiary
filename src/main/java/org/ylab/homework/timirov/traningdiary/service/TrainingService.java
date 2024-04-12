package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.Training;
import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.TrainingIdNotFoundException;
import org.ylab.homework.timirov.traningdiary.repository.TrainingRepository;
import org.ylab.homework.timirov.traningdiary.repository.TrainingRepositoryImpl;

import java.time.LocalDate;
import java.util.*;

import static org.ylab.homework.timirov.traningdiary.Main.principal;

/**
 * @author Timirov Ilya
 * @version 0.1
 * <p>
 * Класс предназначен для работы с тренировками.
 */

public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService() {
        this.trainingRepository = new TrainingRepositoryImpl();
    }

    public void save(Training training) {
        trainingRepository.save(training);
    }

    public void remove(int id) throws TrainingIdNotFoundException {
        trainingRepository.remove(id);
    }

    public List<Training> findAll(User user) {
        return trainingRepository.findAll(user).stream().sorted(Comparator.comparing(Training::getDate)).toList();
    }

    public boolean findByDateAndType(String name, LocalDate date) {
        return trainingRepository.findByDateAndName(name, date);
    }

    public Training getById(int id) throws TrainingIdNotFoundException {
        return trainingRepository.findById(id).orElseThrow(() -> new TrainingIdNotFoundException(id));
    }

    public Map<String, List<Integer>> getStatistics() {
        List<Training> trainings = this.findAll(principal);
        Map<String, List<Integer>> types = new HashMap<>();

        if (!trainings.isEmpty()) {
            for (Training training : trainings) {
                List<Integer> data;
                if (types.containsKey(training.getName())) {
                    data = types.get(training.getName());
                    data.set(0, data.get(0) + training.getDurationTraining());
                    data.set(1, data.get(1) + training.getCaloriesBurned());
                } else {
                    data = new ArrayList<>();
                    data.add(training.getDurationTraining());
                    data.add(training.getCaloriesBurned());
                }
                types.put(training.getName(), data);
            }
        }
        return types;
    }

    public void update(Training training) {
        trainingRepository.update(training);
    }

}
