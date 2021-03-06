package peaksoft_foods.services_and_databases;

import peaksoft_foods.models.User;

import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public interface DbHelperForUser {
    void saveUser(User user);



    List<User> getAllUser();
}
