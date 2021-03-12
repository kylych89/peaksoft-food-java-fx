package peaksoft_foods.services_and_databases;

import peaksoft_foods.models.Food;

import java.util.List;

/**
 * Created by Sayfullah on 05.03.2021.
 */
public interface DbHelperForFood {
    void saveFood(Food food);
    void updateFood(Food food);
    Food findFoodById(Long id);
    int deleteFoodById(Long id);
    List<Food> getAllFoods();
}
