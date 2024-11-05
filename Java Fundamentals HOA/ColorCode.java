import java.util.*;
import java.lang.*;

class ColorCode{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        char a=s.next().charAt(0);
        switch (a){
            case 'R':
                System.out.print("Red");
                break;
            case 'B':
                System.out.print("Blue");
                break;
            case 'G':
                System.out.print("Green");
                break;
            case 'O':
                System.out.print("Orange");
                break;
            case 'W':
                System.out.print("White");
                break;
            case 'Y':
                System.out.print("Yellow");
                break;
            default:
                System.out.print("Invalid Code");
        }
    }
}
