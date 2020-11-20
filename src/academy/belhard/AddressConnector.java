package academy.belhard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private Connection connection;

    private static final String ADD = "INSERT INTO address (id, city, street, house, building, flat) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String REQUEST = "SELECT * FROM address";
    private static final String DELETE = "DELETE FROM address WHERE id = ";
    private static final String UPDATE = "UPDATE address SET ";


    public AddressConnector(Connection connection) {
        this.connection = connection;
    }

    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(REQUEST)) {

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String city = result.getString("city");
                String street = result.getString("street");
                int numberOfHouse = result.getInt("house");
                int numberOfBuilding = result.getInt("building");
                int numberOfFlat = result.getInt("flat");

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
            statement.setInt(1, address.getId());
            statement.setString(2, address.getCity());
            statement.setString(3, address.getStreet());
            statement.setInt(4, address.getNumberOfHouse());
            statement.setInt(5, address.getNumberOfBuilding());
            statement.setInt(6, address.getNumberOfFlat());
            int res = statement.executeUpdate();

        //    System.out.println(res);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(int id) {
        try (PreparedStatement statement = connection.prepareStatement(DELETE+id)) {

          int res = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    void update(Address address) {
        try (PreparedStatement statement = connection.prepareStatement
                (UPDATE+
                        "city = '"+address.getCity()+
                        "', street = '"+ address.getStreet()+
                        "', house =" +address.getNumberOfHouse()+
                        ", building ="+ address.getNumberOfBuilding()+
                        ", flat =" + address.getNumberOfFlat()+
                        " WHERE id ="+address.getId()))
        {

            int res = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
