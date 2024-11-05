import java.util.*;
import java.lang.*;

class CharSort{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        char a=s.next().charAt(0);
        char b=s.next().charAt(0);
        if (a>b){
            System.out.printf(b+","+a);
        }
        else{
            System.out.printf(a+","+b);
        }
    }
}