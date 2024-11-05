import java.util.*;

class FindElement{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter target value: ");
        int target=sc.nextInt();
        System.out.print("Enter Size of array: ");
        int n=sc.nextInt();
        System.out.print("Enter Elements of array: ");
        int[] arr=new int[n];
        int index=-1;
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
            if (target==arr[i]){
                index=i;
            }
        }
        System.out.print(index);


    }
}