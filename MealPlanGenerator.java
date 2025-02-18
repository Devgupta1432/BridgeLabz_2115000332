interface MealPlan {
    void mealDetails();
}

class VegetarianMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Vegetarian Meal");
    }
}

class VeganMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Vegan Meal");
    }
}

class KetoMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("Keto Meal");
    }
}

class HighProteinMeal implements MealPlan {
    public void mealDetails() {
        System.out.println("High-Protein Meal");
    }
}

class Meal<T extends MealPlan> {
    T mealType;
    
    Meal(T mealType) {
        this.mealType = mealType;
    }

    void generateMeal() {
        mealType.mealDetails();
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        new Meal<>(new VegetarianMeal()).generateMeal();
        new Meal<>(new VeganMeal()).generateMeal();
        new Meal<>(new KetoMeal()).generateMeal();
        new Meal<>(new HighProteinMeal()).generateMeal();
    }
}

