import java.util.*;
import java.io.*;
import java.lang.*;

class Project1{
    public static void main(String args[]){
        if (args.length == 0) {
            System.out.println("Please provide an employee number as an argument.");
            return;
        }
        //Employee table initialization
        String[][] emp={{"Emp No","Emp Name","Join Date","Designation Code","Department","Basic","HRA","IT"},
                        {"1001","Ashish  ","01/04/2009","e","R&D        ","2000","8000","3000"},
                        {"1002","Sushma  ","23/08/2012","c","PM         ","30000","12000","9000"},
                        {"1003","Rahul   ","12/11/2008","k","Acct       ","10000","8000","1000"},
                        {"1004","Chahat  ","29/01/2013","r","Front Desk ","12000","6000","2000"},
                        {"1005","Ranjan  ","16/07/2005","m","Engg       ","50000","20000","20000"},
                        {"1006","Suman   ","1/1/2000","e","Manufacturing","23000","9000","4400"},
                        {"1007","Tanmay  ","12/06/2006","c","PM         ","29000","12000","10000"}};
        //{"Emp No.","Emp Name","Department","Designation","Salary"};
        boolean IDFound=false;
        String num=args[0];
        int i,j;
        for (i=0;i<emp.length;i++){
            //Find the emploee id
            if (emp[i][0].equals(num)){
                IDFound=true;
                int basic = Integer.parseInt(emp[i][5]);
                int hra = Integer.parseInt(emp[i][6]);
                int it = Integer.parseInt(emp[i][7]);
                int Salary=basic+hra-it;
                System.out.printf("%s %s %s %s %s\n","Emp No.","Emp Name","Department ","Designation ","Salary");
                int da;
                String designation;
                // Find the designation and DA amount using switch
                switch (emp[i][3]) {
                    case "e":
                        designation = "Engineering  ";
                        da= 20000;
                        break;
                    case "c":
                        designation = "Consultant  ";
                        da= 32000;
                        break;
                    case "k":
                        designation = "Clerk       ";
                        da= 12000;
                        break;
                    case "r":
                        designation = "Receptionist";
                        da= 15000;
                        break;
                    case "m":
                        designation = "Manager     ";
                        da= 40000;
                        break;
                    default:
                        designation = "Unknown     ";
                        da= 0;
                        break;
                }
                Salary+=da;
                System.out.printf("%s    %s %s %s %s ",emp[i][0],emp[i][1],emp[i][4],designation,Salary);

            }
        }
        if (IDFound==false){
            System.out.printf("There is no employee with empid: %s",num);
        }
    }
}





