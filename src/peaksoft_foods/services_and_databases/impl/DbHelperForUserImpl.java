package peaksoft_foods.services_and_databases.impl;

import peaksoft_foods.models.User;
import peaksoft_foods.services_and_databases.DbHelperForUser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public class DbHelperForUserImpl implements DbHelperForUser {

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/peaksoft_food_service","postgres","010689");
        return connection;
    }

    @Override
    public void saveUser(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into users (name , login, password) values (?,?,?)");
            ps.setString(1,user.getName());
            ps.setString(2,user.getLogin());
            ps.setString(3,user.getPassword());
            ps.executeUpdate();
            connection.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("update users set name = ?, login = ?, password = ? where id = ?");
            ps.setString(1,user.getName());
            ps.setString(2,user.getLogin());
            ps.setString(3,user.getPassword());
            ps.setLong(4,user.getId());
            ps.executeUpdate();
            ps.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByLogin(String login) {
        User user = new User();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("select id, name, password from users where login = ?");
            ps.setString(1,login);

            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setLogin(login);
            }
            ps.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public boolean deleteUserByLogin(String login) {

        return false;
    }

    @Override
    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            ps = connection.prepareStatement("select id, name, login, password from users");
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLogin(resultSet.getString(3));
                user.setPassword(resultSet.getString(4));
                list.add(user);
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
