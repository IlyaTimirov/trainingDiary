package org.ylab.homework.timirov.traningdiary;

import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.out.Menu;

import static org.ylab.homework.timirov.traningdiary.repository.RoleRepositoryImpl.initRole;
import static org.ylab.homework.timirov.traningdiary.repository.UserRepositoryImpl.initAdmin;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Класс отвечающи за запуск приложения.
 * */
public class Main {
    public static User principal;

    public static void main(String[] args) {
        context();
        new Menu().menu();
    }

    public static void context() {
        initRole();
        initAdmin();
    }
}
