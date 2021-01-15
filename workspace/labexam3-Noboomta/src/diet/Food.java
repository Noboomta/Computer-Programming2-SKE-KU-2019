package diet;

/**
 * A food item with nutritional info.
 */
public class Food {
	private String name;
	private int calories;
	private int carbs;
	private int fat;
	private double glycemicIndex;
	
	public Food(String name, int calories, int carbs, int fat, double gi) {
		this.name = name;
		this.calories = calories;
		this.carbs = carbs;
		this.fat = fat;
		this.glycemicIndex = gi;
	}
	
	/** For the exam. Only name and calories are needed. */
	public Food(String name, int calories) {
		this(name, calories, 0, 0, 0);
	}
	
	/** For subclasses that don't need the parameterized constructor. */
	protected Food() {
		this.name = "";
	}
	
	/** Get the name of this food */
	public String getName() { return name; }
	
	/** The caloric value of this food */
	public int getCalories() { return calories; }

	/** Grams of carbohydrate in this food */
	public int getCarbs() { return carbs; }

	/** Grams of fat in this food */
	public int getFat() { return fat; }
	
	/** Glycemic Index of this food */
	public double getGI() { return glycemicIndex; }
	
	/** String representation of this food */
	public String toString() { 
		return String.format("%s [%d cal]", name, calories); 
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof Food)) return false;
		Food other = (Food)obj;
		return this.getName().equals(other.getName()) 
			&& this.getCalories() == other.getCalories();
	}
}
