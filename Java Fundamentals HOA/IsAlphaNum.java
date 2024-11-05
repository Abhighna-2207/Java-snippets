import java.util.*;

class IsAlphaNum{
    public static void main (String args[]){
        Scanner s=new Scanner(System.in);
        char a=s.next().charAt(0);
        if ((a>='a' && a<='z') || (a>='A' && a<='Z')){
            System.out.println("Alphabet");
        }
        else if (a>='0' && a<='9') {
            System.out.println("Numeric");
        }
        else{
            System.out.println("Special Character");
        }
    }
}