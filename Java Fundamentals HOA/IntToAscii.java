import java.util.*;


class IntToAscii{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter size of Array: ");
        int n=sc.nextInt();
        int[] arr = new int[n];
        System.out.print("\nEnter Array Elements: ");
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++){
            System.out.print(" ");
            System.out.print((char)arr[i]);
        }
    }
}