package peaksoft_foods.services_and_databases.impl;

import peaksoft_foods.models.User;
import peaksoft_foods.services_and_databases.DbHelperForUser;
import peaksoft_foods.services_and_databases.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean login(String login, String password) {

        DbHelperForUser dbHelperForUser = new DbHelperForUserImpl();
        User user = dbHelperForUser.getUserByLogin(login);
        if (user.getId() != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}
