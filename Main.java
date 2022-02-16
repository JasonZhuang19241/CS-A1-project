import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main{
    static void bookinventory(){
        System.out.println("do function");
    }
    static void entry(){
        System.out.println("do function");
    }
    static void borrow(){
        System.out.println("do function");
    }
    static void ranking(){
        System.out.println("do function");
    }
    
    public static void main(String[] args){
        Scanner userinput=new Scanner(System.in);
        System.out.println("##Welcome to the Library System##");
        Boolean flag=false;
        String username, password;
        username="abc";
        password="abc";
        try{
            File adminsys= new File("D:\\nextcloud\\desktop\\CS group project\\studentID.txt");
            Scanner scanning= new Scanner(adminsys);
            username= scanning.nextLine();
            password= scanning.nextLine();
            System.out.println("Userallowed: "+username);
            
        }catch (FileNotFoundException e) {
            System.out.println("file not found: admin.txt");
        }
  
        while(flag==false){
            System.out.println("Please input username: ");
            String name = userinput.nextLine();
            System.out.println("Please input password: ");
            String pass = userinput.nextLine();
           
            if(name.equals(username) & pass.equals(password)){
                flag=true;
                System.out.println("Welcome, SCIE!");
            }
        }
        Boolean end=false;
        while(end==false){
            Scanner inp=new Scanner(System.in);
            String inquiry=inp.nextLine();
            if(inquiry=="inventory"){
                bookinventory();
            }
            else if(inquiry=="entry"){
                entry();
            }
            else if(inquiry=="borrow" || inquiry=="return"){
                borrow();
            }
            else if(inquiry=="rank"){
                ranking();
            }
                

        }
        
    }
}
