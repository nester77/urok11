package academy.belhard;

import java.sql.*;

public class Main {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/addresses_db?useUnicode=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "5427762";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AddressConnector connector = new AddressConnector(connection);

        for (Address a : connector.readAll()) {
            System.out.println(a);
        }

//        Address address = new Address(-1, "Минск", "Строителей", 5, 2, 35);
//        connector.add(address);

//        System.out.println();
//
//        for (Address a : connector.readAll()) {
//            System.out.println(a);
//        }

    }
}

//    Создайте класс Address в соответствии со структурой таблицы, необходимые конструкторы, геттеры и сеттеры
//        Создайте класс AddressConnector, в котором определите 4 метода:
//        void add(Address address) - для записи объекта в БД
//        List<Address> readAll() - читает все содержимое таблицы и складывает это в результирующую коллекцию
//        void delete(int id) - удаляет адрес по его id
//        void update(Address address) - обновляет запись с указанным id
//        Создайте 5 объектов типа Address и сохраните их в базу (метод add класса AddressConnector)
//        Выведите содержимое на экран (метод readAll класса AddressConnector)
//        Измените 2 адреса (метод update класса AddressConnector)
//        Выведите содержимое на экран (метод readAll класса AddressConnector)
//        Удалите 2 адреса из БД (метод delete класса AddressConnector)
//        Выведите содержимое на экран (метод readAll класса AddressConnector)
//        Залить код в репозиторий и отправить ссылку на репозиторий преподавателю





