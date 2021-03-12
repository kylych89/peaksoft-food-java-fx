package peaksoft_foods.exceptions;

public class FoodNotFound extends RuntimeException{
    public FoodNotFound(String message) {
        super(message);
    }
}
