package org.ylab.homework.timirov.traningdiary.entity;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Training {
    private int id;
    private String name;
    private LocalDate date;
    private int durationTraining;
    private int caloriesBurned;

    public Training() {
    }

    public Training(String name, LocalDate date, int durationTraining, int caloriesBurned) {
        this.name = name;
        this.date = date;
        this.durationTraining = durationTraining;
        this.caloriesBurned = caloriesBurned;
    }

    public Training(int id, String name, LocalDate date, int durationTraining, int caloriesBurned) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.durationTraining = durationTraining;
        this.caloriesBurned = caloriesBurned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getDurationTraining() {
        return durationTraining;
    }

    public void setDurationTraining(int durationTraining) {
        this.durationTraining = durationTraining;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return id == training.id && durationTraining == training.durationTraining && caloriesBurned == training.caloriesBurned && name.equals(training.name) && date.equals(training.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, durationTraining, caloriesBurned);
    }

    @Override
    public String toString() {
        return id + "| " + name + " | " + date + " | " + durationTraining + " | " + caloriesBurned;
    }
}
