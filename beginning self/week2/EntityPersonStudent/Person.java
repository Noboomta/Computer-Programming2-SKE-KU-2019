public class Person extends Entity{
    protected String name;
    public Person(String name){
        System.out.println("Creating a new Person");
        this.name = name; 
    }
}