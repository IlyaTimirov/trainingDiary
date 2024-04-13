package org.ylab.homework.timirov.traningdiary.exception;

public class UsernameAlreadyExistsException extends RuntimeException{
    public UsernameAlreadyExistsException(String username) {
        super("Пользователь с логином " + username + " уже существует!");
    }
}
