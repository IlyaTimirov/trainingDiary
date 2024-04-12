package org.ylab.homework.timirov.traningdiary.repository;

import org.ylab.homework.timirov.traningdiary.entity.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Timirov Ilya
 * @version 0.1
 *
 * Интерфейс RoleRepository представляет собой репозиторий для хранения ролей пользователей.
 * */
public interface RoleRepository {
    List<Role> roles = new ArrayList<>();

    List<Role> findBy(String role);
}
