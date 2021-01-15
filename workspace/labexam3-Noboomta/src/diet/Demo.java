package diet;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstrate how to create a list of foods,
 * as convenience for creating test data for your Diet class.
 */
public class Demo {

	public static void printFoodList(String name, List<Food> foods) {
		System.out.printf("%s = %s\n", name, Arrays.toString(foods.toArray()));
	}
	
	/** Demonstrate how to use the Food factory. */
	public static void demo() {
		FoodFactory factory = FoodFactory.getInstance();
		System.out.println("Get All Foods");
		factory.getFoods().forEach(System.out::println);
		
		System.out.println("\nFind Apple: " + factory.find("Apple"));
		System.out.println("\nFind Pizza: " + factory.find("Pizza"));
		System.out.println("\nMake a menu of foods:");
		List<Food> menu = factory.makeMenu("Pizza", "Apple Pie", "Apple", "Pizza", "Banana");
		printFoodList("menu", menu);
		
		// You can add more foods to the factory
		// Create a CSV file where each line contains:
		// food description,calories,0,0,0
		// the three zeros (0,0,0) are carbs, fat, and glycemic index, not needed in this problem
		//
		// Then call: factory.readData("filename")
	}
	
	public static void main(String[] args) {
		demo();
	}
}
