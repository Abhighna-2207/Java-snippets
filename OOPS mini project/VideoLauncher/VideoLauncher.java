import java.util.*;
import java.io.*;
import java.lang.*;

class Video{
    private String videoName;
    private boolean checkout;
    private int rating;
    public Video(String videoName){
        this.videoName=videoName;
        this.checkout=false;
        this.rating=0;
    }
    public String getName(){
        return videoName;
    }
    public void doCheckout(){
        this.checkout=true;
    }
    public void doReturn(){
        this.checkout=false;
    }
    public void ReceiveRating(int rating){
        this.rating=rating;
    }
    public int getRating(){
        return rating;
    }
    public boolean getCheckout(){
        return checkout;
    }
}

class VideoStore {
    private Video[] store;
    private int count;

    public VideoStore() {
        store = new Video[10]; // Initial capacity of 10
        count = 0;
    }
    public void addVideo(String name){
        store[count]=new Video(name);
        count++;
        System.out.println("Video " + name + " successfully added.");
    }
    public void doCheckout(String name){
        for (int i=0;i<count;i++){
            if ((store[i].getName()).equals(name)){
                store[i].doCheckout();
                System.out.println("Video " + store[i].getName() + " checked out successfully.");
                return;
            }
        }
        System.out.println("Video " + name + " not found.");


    }
    public void doReturn(String name){
        for (int i=0;i<count;i++){
            if (store[i].getName().equals(name)){
                store[i].doReturn();
                System.out.println("Video " + name + " Returned successfully.");
                return;
            }
        }
        System.out.println("Video " + name + " not found.");

    }
    public void ReceiveRating(String name,int rating ){
        for (int i=0;i<count;i++){
            if ((store[i].getName()).equals(name)){
                store[i].ReceiveRating(rating);
                System.out.println("Rating "+ rating+" has been mapped to the Video" +name);
                return;
            }
        }
        System.out.println("Video " + name + " not found.");

    }
    public void listInventory(){
            System.out.println("\n\n--------------------------------------------------------------");
            System.out.println("Video Name\t|\tCheckout Status\t|\tRating");
            System.out.println("--------------------------------------------------------------");
        for (int i=0 ; i<count;i++){
            System.out.println(store[i].getName()+"\t|\t"+store[i].getCheckout()+"       \t|\t"+store[i].getRating());
            System.out.println("--------------------------------------------------------------");
        }
        return;
    }
}

public class VideoLauncher{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        VideoStore vh1=new VideoStore();
        vh1.addVideo("Dynamite");
        vh1.doCheckout("Dynamite");
        vh1.listInventory();
        vh1.ReceiveRating("Dynamite",9);
        vh1.listInventory();
        int choice;

        while (true){
        System.out.println("\n\nMAIN MENU");
        System.out.println("=========");
        System.out.println("1.AddVideos : \n2.Check Out Video : \n3.Returen Video : \n4.Receive Rating : \n5.List Inventory : \n6.Exit : \nEnter your choice (1..6) : ");
        choice=sc.nextInt();
        sc.nextLine();
            if (choice==1){
                System.out.println("Enter the name of the Video You want to add : ");
                String name=sc.nextLine();
                vh1.addVideo(name);
            }
            else if (choice==2){
                System.out.println("Enter the name of the Video You want to Check Out : ");
                String name=sc.nextLine();
                vh1.doCheckout(name);
            }
            else if (choice==3){
                System.out.println("Enter the name of the Video You want to return : ");
                String name=sc.nextLine();
                vh1.doReturn(name);
            }
            else if (choice==4){
                System.out.println("Enter the name of the Video You want to Rate : ");
                String name=sc.nextLine();
                System.out.println("Enter the rating for this video : ");
                int rate=sc.nextInt();
                vh1.ReceiveRating(name,rate);
            }
            else if (choice==5){
                vh1.listInventory();
            }
            else if (choice==6){
                System.out.println("Exiting...!! Thank you for using this application. ");
                break;
            }
            else{
                System.out.print("Invalid Choice. ");
                break;
            }
        }
    }
}