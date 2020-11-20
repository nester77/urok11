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


        Address address1 = new Address(1, "Minsk", "Nemiga", 5, 2, 35);
        connector.add(address1);

        Address address2 = new Address(2, "Kiev", "Bankovaya", 10, 0, 0);
        connector.add(address2);

        Address address3 = new Address(3, "Minsk", "Krasnaya", 98, 0, 17);
        connector.add(address3);

        Address address4 = new Address(4, "Warsaw", "Górczewska", 49, 1, 12);
        connector.add(address4);

        Address address5 = new Address(5, "Riga", "Brivibas", 38, 0, 24);
        connector.add(address5);

        for (Address a : connector.readAll()) {
            System.out.println(a);
        }
        System.out.println();

        connector.update(address3.setStreet("Krasnozvezdnaya"));
        connector.update(address4.setNumberOfHouse(149));

        for (Address a : connector.readAll()) {
            System.out.println(a);
        }
        System.out.println();

        connector.delete(5);
        connector.delete(3);

        for (Address a : connector.readAll()) {
            System.out.println(a);
        }

    }
}