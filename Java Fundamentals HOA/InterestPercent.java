import java.util.*;

class InterestPercent{
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter Gender Male or Female: ");
        String gen=s.nextLine();
        System.out.print("Enter Age: ");
        int a=s.nextInt();
        if (gen.equals("Female")){
            if (a>0 && a<59){
                System.out.print("the percentage of interest is 8.2%");
            }
            else if (a>58 && a<101){
                System.out.print("the percentage of interest is 9.2%");
            }
            else {
                System.out.print("enter the age value between 1 to 100");
            }
        }
        else if (gen.equals("Male")){
            if (a>0 && a<59){
                System.out.print("the percentage of interest is 8.4%");
            }
            else if (a>58 && a<101){
                System.out.print("the percentage of interest is 10.5%");
            }
            else {
                System.out.print("enter the age value between 1 to 100");
            }
        }
        else{
            System.out.println("Enter the values in proper format");
        }
    }
}