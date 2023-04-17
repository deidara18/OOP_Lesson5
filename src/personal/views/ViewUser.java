package personal.views;

import personal.controllers.UserController;
import personal.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        CREATE();
                        break;
                    case READ:
                        READ();
                        break;
                    case LIST:
                        LIST();
                        break;
                    case UPDATE:
                        UPDATE();
                        break;
                    case DELETE:
                        DELETE();

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void UPDATE() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        User user = userController.readUser(id);
        System.out.println(user);
        System.out.println();
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.updateUser(new User(id, firstName, lastName, phone));
    }

    private void CREATE() {
        String firstName = prompt("Имя: ");
        String lastName = prompt("Фамилия: ");
        String phone = prompt("Номер телефона: ");
        userController.saveUser(new User(firstName, lastName, phone));
    }

    private void READ() throws Exception {
        String id = prompt("Идентификатор пользователя: ");

        User user = userController.readUser(id);
        System.out.println(user);
    }

    private void LIST() {
        List<User> allUsers = userController.allUsers();
        for (User user : allUsers) {
            System.out.println(user);
        }
    }

    private void DELETE() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        userController.deleteUser(id);
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
