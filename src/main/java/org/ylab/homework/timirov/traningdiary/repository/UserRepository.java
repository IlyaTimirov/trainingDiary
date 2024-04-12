package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Интерфейс UserRepository представляет собой репозиторий для хранения пользователей.
 * */
public interface UserRepository {
    List<User> users = new ArrayList<>();

    Optional<User> findByUsername(String username);

    void save(User user);

    List<User> findAll();

    Optional<User> findById(int id);
}
