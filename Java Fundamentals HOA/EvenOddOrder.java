import java.util.*;
import java.lang.*;

public class EvenOddOrder {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of array: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements of array: ");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i=0, j=0,tens=0;
        int[] narr=new int[n];
        for (i=0;i<n;i++){
            if (arr[i]%2==0){
                narr[j]=arr[i];
                j++;
            }
        }
        for (i=0;i<n;i++){
            if (arr[i]%2!=0){
                narr[j]=arr[i];
                j++;
            }
        }
        System.out.print("\n");
        for (i = 0; i < n; i++) {
            System.out.printf("%d ", narr[i]);
        }
    }
}
