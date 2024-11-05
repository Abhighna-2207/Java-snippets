import java.lang.*;
class FloydFormat{
    public static void main(String args[]){
        if (args.length==0){
            System.out.print("Please enter integer code");
        }
        int n=Integer.parseInt(args[0]);
        for (int i=1; i<n+1;i++){
            for (int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}