package org.ylab.homework.timirov.traningdiary.service;

import org.ylab.homework.timirov.traningdiary.entity.User;
import org.ylab.homework.timirov.traningdiary.exception.UserIdNotFoundException;
import org.ylab.homework.timirov.traningdiary.in.InputUser;
import org.ylab.homework.timirov.traningdiary.out.RenderTraining;
import org.ylab.homework.timirov.traningdiary.util.ExecuteUtil;

import java.util.List;

public class AdminActionMenuService {
    private final UserService userService;
    private final ExecuteUtil execute;
    private final InputUser inputUser;
    private final RenderTraining renderTraining;

    private final TrainingService trainingService;
    public AdminActionMenuService() {
        this.userService = new UserService();
        this.execute = new ExecuteUtil();
        this.inputUser = new InputUser();
        this.renderTraining = new RenderTraining();
        this.trainingService = new TrainingService();
    }

    public void showAuditUsers() {
        System.out.println("В разработке");
    }

    public void showTrainingsUser() {
        execute.executeWithCustomBack(back -> {
            renderUsers();

            System.out.print("Введите ид пользователя: ");

            int id = inputUser.inputId();

            try {
                User user = userService.getById(id);
                renderTraining.renderTraining(trainingService.findAll(user));
            } catch (UserIdNotFoundException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("0 - Вернуться назад");
            System.out.println("1 - Посмотреть других пользователей");

            return execute.inputBackOption();
        });
    }

    private void renderUsers() {
        List<User> users = userService.getAll();
        users.forEach(user -> System.out.println(user.getId()));
    }
}
