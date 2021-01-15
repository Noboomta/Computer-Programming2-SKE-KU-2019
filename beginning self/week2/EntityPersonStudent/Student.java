public class Student extends Person{
    private long id;
    protected String name;
    public Student(String name , long id){
        super(name);
        System.out.println("Creating a new Student");
        this.id = id;
    }
}