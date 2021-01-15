package diet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class Diet.
 */
public class Diet {
    List<Food> foodMenu;

    /**
     * Method ChooseFood.
     * @param calorieLimit int
     * @param menu List Food
     * @return ans
     */
    public List<Food> chooseFoods(int calorieLimit, List<Food> menu){

        if(calorieLimit == 0){
            return new ArrayList<>();
        }
        if(menu.size() == 0){
            return new ArrayList<>();
        }
        Food firstFood = menu.get(0);
        if (calorieLimit >= firstFood.getCalories()){
            List<Food> ans = chooseFoods(calorieLimit-firstFood.getCalories(), menu.subList(1,menu.size()));
            if(ans==null){
                chooseFoods(calorieLimit, menu.subList(1, menu.size()));
            }
            ans.add(firstFood);
            return ans;
        }
        return chooseFoods(calorieLimit, menu.subList(1, menu.size()));

    }

    /**
     * Method to add new Food.
     * @param menu
     */
    public void addFoods(List<Food> menu){
        foodMenu.addAll(menu);
    }

    /**
     * Main method.
     * @param args
     */
    public void main(String[] args) {
//        Food pizza = new Food("Pizza", 380);
//        Food hamburger = new Food("Mac Hamburger", 640);
//        Food apple_pie = new Food("Apple pie", 320);
//        Food banana = new Food("Banana", 80);
//        Food tangerine = new Food("Tangerine", 40);
//        Food apple = new Food("Apple", 60);
////        Arrays.asList(pizza, hamburger, apple_pie, banana, tangerine, apple);
//        List<Food> menu =  Arrays.asList(pizza,apple, banana);
//        List<Food> ans = this.chooseFoods(370, menu);
//        Collections.reverse(ans);
//        for(Food a: ans){
//            System.out.printf(a.getName()+ " ");
//        }
        Food pizza = new Food("67", 67);
        Food hamburger = new Food("75", 75);
        Food apple_pie = new Food("135", 135);
        Food banana = new Food("150", 150);
        Food tangerine = new Food("225", 225);

        List<Food> menu =  Arrays.asList(pizza,pizza,pizza,hamburger,hamburger,hamburger, hamburger, apple_pie, banana,banana, tangerine);
        List<Food> ans = this.chooseFoods(370, menu);
        Collections.reverse(ans);
        for(Food a: ans){
            System.out.printf(a.getName()+ " ");
        }
    }
}
