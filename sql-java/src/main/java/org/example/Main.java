package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    /*private Connection connection;*/
    public static void main(String[] args) throws SQLException {
        // Создаем соединение с базой в памяти
        // База создается прямо во время выполнения этой строчки
        // Здесь hexlet_test — это имя базы данных
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test")) {
            //var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test");

            var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            // Чтобы выполнить запрос, создадим объект statement
            var statement = conn.createStatement();
            statement.execute(sql);
            statement.close(); // В конце закрываем

            var dao = new UserDAO(conn);
            var user = new User("Maria", "888888888");

            dao.save(user);

            var user2 = dao.find(user.getId()).get();
            Long l1 = user2.getId();
            Long l2 = user.getId();
            dao.delete(user2);
            //user2.getId() == user.getId(); // true

        }
    }
}