package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // тут уже добавила работу с бд и таблицей напрямую через консоль
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Создать таблицу пользователей");
            System.out.println("2. Удалить таблицу пользователей");
            System.out.println("3. Очистить таблицу пользователей");
            System.out.println("4. Добавить пользователя");
            System.out.println("5. Удалить пользователя по id");
            System.out.println("6. Показать всех пользователей");
            System.out.println("7. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    userService.createUsersTable();
                    System.out.println("Таблица пользователей создана!");
                    break;
                case 2:
                    userService.dropUsersTable();
                    System.out.println("Таблица пользователей удалена!");
                    break;
                case 3:
                    userService.cleanUsersTable();
                    System.out.println("Таблица пользователей очищена!");
                    break;
                case 4:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите фамилию: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Введите возраст: ");
                    byte age = scanner.nextByte();
                    userService.saveUser(name, lastName, age);
                    System.out.println("Пользователь " + name + " добавлен в базу данных!");
                    break;
                case 5:
                    System.out.print("Введите id пользователя для удаления: ");
                    long id = scanner.nextLong();
                    userService.removeUserById(id);
                    System.out.println("Пользователь с id " + id + " удален из базы данных!");
                    break;
                case 6:
                    userService.getAllUsers().forEach(System.out::println);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }

        scanner.close();
    }
}
