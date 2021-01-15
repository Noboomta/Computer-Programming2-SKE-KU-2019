
public class Polygon extends Shape{
    public Point[] args; 

    public Polygon(Point... points){
        this.args = points;
    }

    @Override
    public double getPerimeter(){
        double sum=0;
        for(int i=0; i<args.length-1;i++){
            sum+= args[i].distanceTo(args[i+1]);
        }
        return sum+ args[args.length-1].distanceTo(args[0]);
    }

    public String toString(){
        return String.format("an %d-sided polygon",args.length);
    }

}