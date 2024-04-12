package org.ylab.homework.timirov.traningdiary.exception;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(int id) {
        super("Пользователь с ид " + id + " не найден");
    }
}
