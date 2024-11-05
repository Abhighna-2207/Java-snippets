
import java.lang.*;

class CommandLine{
    public static void main(String args[]){
        int i;
        if (args.length>0){
            for (i=0;i<args.length-1;i++){
                System.out.printf(args[i]+", ");
            }
            System.out.printf(args[i]);
        }
        else{
            System.out.printf("No command line values");
        }
    }
}