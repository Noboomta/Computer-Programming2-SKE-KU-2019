package diet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Manage a collection of food items.
 */
public class FoodFactory {
	private static FoodFactory instance;
	private List<Food> items;
	private final Comparator<Food> compareByLength = 
			(a,b) -> Integer.compare(a.getName().length(),b.getName().length());
	
	private FoodFactory() {
		items = new ArrayList<Food>();
		readData("diet/foods.csv");
	}

	/** Get a singleton instance of the FoodFactory. */
	public static FoodFactory getInstance() {
		if (instance == null) instance = new FoodFactory();
		return instance;
	}
	
	
	/** Get one food by its position in the list of foods.*/
	public Food getFood(int index) {
		if (index>=0 && index<items.size()) return items.get(index);
		return null;
	}
	
	/** 
	 * Get a food that matches the requested name anywhere  in the food description.
	 */
	public Food find(String name) {
		List<Food> found = items.stream()
					.filter(f -> f.getName().contains(name))
					.collect(Collectors.toList());
		if (found.isEmpty()) return null;
		if (found.size()==1) return found.get(0);
		// best match
		Collections.sort(found, compareByLength);
		return found.get(0);
	}
	
	/** Make a list of foods whose names match parameters in the list.
	 *  The best matching food for each parameter is used, so "Apple" returns Food("Apple")
	 *  instead of Food("Apple Pie")
	 */
	public List<Food> makeMenu(String ... names) {
		List<Food> menu = new ArrayList<>();
		for(String name: names) {
			Food food = find(name);
			if (food != null) menu.add(food);
		}
		return menu;
	}
	
	/** Get all the foods in the list. */
	public List<Food> getFoods() {
		return items;
	}
	
	/** 
	 * Read food data from a file, as file on file system or classpath resource. 
	 * This method appends the foods read from filename to the existing list of foods,
	 * so you can add foods from another file.
	 * @param filename is the file to read food data from. Data is in CSV format
	 *    in the order:  description,calories,carb_grams,fat_grams,glycemic_index
	 */
	public void readData(String filename) {
		FoodParser parser = new FoodParser();
		try (InputStream in = new FileInputStream(filename))
		{
			readData(in, parser);
		}
		catch (IOException ioe) {
			// try again, as classpath resource
		}
		InputStream in = this.getClass().getClassLoader().getResourceAsStream(filename);
		if (in == null) {
			System.err.println("Could not find data file "+filename);
			return;
		}
		readData(in, parser);
	}
	
	/** Read food data from an InputStream. */
	public void readData(InputStream in, Function<String,Food> parser) {
		Scanner scanner = new Scanner(in);	
		while(scanner.hasNextLine()) {
			Food food = parser.apply(scanner.nextLine());
			if (food != null) items.add(food);
		}
		scanner.close();
	}
	
}

/** Parse one line of data in CSV format. */
class FoodParser implements java.util.function.Function<String,Food> {
	public Food apply(String data) {
		try (Scanner scanner = new Scanner(data)) 
		{
			scanner.useDelimiter("\\s*,\\s*");
			String description = scanner.next().trim();
			if (description.startsWith("#")) return null; // comment line
			int calories = scanner.nextInt();
			int carbs = scanner.nextInt();
			int fat = scanner.nextInt();
			double gi = scanner.nextDouble();
			return new Food(description,calories,carbs,fat,gi);
		} 
		catch(Exception ex) {
			System.out.println("invalid data: "+data);
			return null;
		}
	}
}
