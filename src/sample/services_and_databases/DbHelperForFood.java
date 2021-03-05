package sample.services_and_databases;

import sample.models.Food;

import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public interface DbHelperForFood {
    void saveFood(Food food);
    List<Food> getAllFoods();
}
