package academy.belhard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private Connection connection;

    private static final String ADD = "INSERT INTO persons (city, street, numberOfHouse,numberOfBuilding, numberOfFlat) VALUES(?, ?, ?, ?, ?)";
    private static final String REQUEST = "SELECT * FROM persons";
    private static final String DELETE = "DELETE FROM address WHERE id = ? ";
    private static final String UPDATE = "UPDATE addresses SET city = '?', street = '?', numberOfHouse = ?, numberOfBuilding = ?, numberOfFlat = ? WHERE id = ?";

    public AddressConnector(Connection connection) {
        this.connection = connection;
    }

    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String city = result.getString("город");
                String street = result.getString("улица");
                int numberOfHouse = result.getInt("номер_дома");
                int numberOfBuilding = result.getInt("корпус");
                int numberOfFlat = result.getInt("квартира");

                Address p = new Address(id, city, street, numberOfHouse, numberOfBuilding, numberOfFlat);

                res.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return res;
    }

    public void add(Address address) {
        try (PreparedStatement statement = connection.prepareStatement(ADD)) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getNumberOfHouse());
            statement.setInt(4, address.getNumberOfBuilding());
            statement.setInt(5, address.getNumberOfFlat());

            int res = statement.executeUpdate();

            System.out.println(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, id);


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    void update(Address address) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            statement.setInt(6, address.getId());
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getNumberOfHouse());
            statement.setInt(4, address.getNumberOfBuilding());
            statement.setInt(5, address.getNumberOfFlat());


        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
//    void add(Address address) - для записи объекта в БД
//        List<Address> readAll() - читает все содержимое таблицы и складывает это в результирующую коллекцию
//        void delete(int id) - удаляет адрес по его id
//        void update(Address address) - обновляет запись с указанным id