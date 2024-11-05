import java.util.*;
import java.lang.*;

public class Duplicates {
    
    // Define a method to print the elements of an array
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Size of array: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements of array: ");
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int i, j, k;
        
        for (i = 0; i < n; i++) {
            for (j = i+1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    for (k = j; k < n - 1; k++) {
                        arr[k] = arr[k + 1];
                    }
                    n--;
                    j--;
                }
            }
        }
        System.out.print("\n");
        for (i = 0; i < n; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
}
