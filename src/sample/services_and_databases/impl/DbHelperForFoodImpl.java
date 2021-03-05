package sample.services_and_databases.impl;

import sample.models.Food;
import sample.services_and_databases.DbHelperForFood;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public class DbHelperForFoodImpl implements DbHelperForFood {

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","010689");
        return connection;
    }

    @Override
    public void saveFood(Food food) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into foods (name , price, amount) values (?,?,?)");
            ps.setString(1,food.getName());
            ps.setDouble(2,food.getPrice());
            ps.setInt(3,food.getAmount());
            ps.executeUpdate();
            connection.close();
            ps.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> getAllFoods() {

        return null;
    }
}
