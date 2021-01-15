public class Test {


    public String changeXY(String str) {
        String front = "";
        front += str.charAt(0);
        if (str.length() > 1) {
            if (front.equals("x")) {
                return "y" + changeXY(str.substring(1));
            } else {
                return front + changeXY(str.substring(1));
            }
        }
        if (front.equals("x")) {
            return "y";
        } else {
            if(str.length() <= 0){
                return str;
            }
            else{
                return front;
            }
        }
    }

    public String stringClean(String str) {
        if (str.length() < 2) return str;
        if(str.charAt(0) == (str.charAt(1))){
            return stringClean(str.substring(1));
        }
        else{
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }
    

}