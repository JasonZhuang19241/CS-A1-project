import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
public class EntranceSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
			File aFile = new File("D:\\nextcloud\\desktop\\CS group project\\aJavaFile.txt"); // file pathway sample
			Scanner aScanner;
			Scanner IDScanner = new Scanner(System.in);
			System.out.println("Enter your ID to get in.");
			String ID = IDScanner.nextLine();
			String flag = "true";
			try {

				aScanner = new Scanner(aFile);
				while(aScanner.hasNextLine()) {
					String content = aScanner.nextLine();
					System.out.println(content);
					if(ID.equals(content)) {
						System.out.println("ID already existed,you're not allowed to enter");
						flag = "false";
					}
				}
				if (flag.equals("true")) {
					FileWriter writer = new FileWriter(aFile,true);
					writer.write("\n"+ID);
					writer.close();
					System.out.println("Welcome, "+ID);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
	}

