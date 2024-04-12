package org.ylab.homework.timirov.traningdiary.exception;

public class TrainingIdNotFoundException extends RuntimeException{
    public TrainingIdNotFoundException(int id) {
        super("Тренировка с ид " + id + " не найдена");
    }
}
