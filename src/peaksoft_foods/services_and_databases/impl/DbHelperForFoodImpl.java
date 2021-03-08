package peaksoft_foods.services_and_databases.impl;

import peaksoft_foods.models.Food;
import peaksoft_foods.services_and_databases.DbHelperForFood;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public class DbHelperForFoodImpl implements DbHelperForFood {

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/peaksoft_food_service","postgres","010689");
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
    public void updateFood(Food food) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("update foods set name = ? , price = ?, amount = ? where id = ?");
            ps.setString(1,food.getName());
            ps.setDouble(2,food.getPrice());
            ps.setInt(3,food.getAmount());
            ps.setLong(4,food.getId());
            ps.executeUpdate();
            connection.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> getAllFoods() {
        List<Food> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            ps = connection.prepareStatement("select id, name , price, amount from foods");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Food food = new Food();
                food.setId(resultSet.getLong(1));
                food.setName(resultSet.getString(2));
                food.setPrice(resultSet.getDouble(3));
                food.setAmount(resultSet.getInt(4));
                list.add(food);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (connection == null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (ps == null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (resultSet == null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
