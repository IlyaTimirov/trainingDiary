package org.ylab.homework.timirov.traningdiary.exception;

public class UsernameNotFoundException extends RuntimeException{
    public UsernameNotFoundException() {
        super("Пользователь с таким логином не найден!");
    }
}
