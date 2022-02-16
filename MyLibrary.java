import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MyLibrary {
  public int countAvailiableBooks() {
    List<Record> records = readDataFromDatabase();
    int totalAvailiable = 0;
    for (Record r : records) {
      if (r.getAvailiable()) {
        totalAvailiable++;
      }
    }
    return totalAvailiable;
  }

  // Return the days
  public int queryBorrowTime(String bookNumber) {
    List<Record> records = readDataFromDatabase();
    Record bookRecord = queryBookByNumber(records, bookNumber);

    if (bookRecord == null) {
      System.out.println("The book(Number: " + bookNumber + ") is not found. ");
      return 0;
    }

    if (!bookRecord.getAvailiable()) {
      System.out.println("The book(Number: " + bookNumber + ") is not availiable. ");
      System.out.println("It borrowed by " + bookRecord.getBorrowedBy());
      return bookRecord.computeDaysToNow();
    } else {
      System.out.println("The book(Number: " + bookNumber + ") is availiable. ");
      return 0;
    }
  }

  public Record queryBookByNumber(List<Record> records, String bookNumber) {
    Record bookRecord = null;
    for (Record r : records) {
      if (r.getNumber().equals(bookNumber)) {
        bookRecord = r;
        break;
      }
    }
    return bookRecord;
  }

  public void borrowBook(String username, String bookNumber) {
    List<Record> records = readDataFromDatabase();
    Record bookRecord = queryBookByNumber(records, bookNumber);

    if (bookRecord == null) {
      System.out.println("The book(Number: " + bookNumber + ") is not found. ");
      return;
    }

    if (!bookRecord.getAvailiable()) {
      System.out.println("The book(Number: " + bookNumber + ") is not availiable. ");
      System.out.println("It borrowed by " + bookRecord.getBorrowedBy());
      return;
    }
    bookRecord.setBorrowedBy(username);
    saveDataToDatabase(records);
    System.out.println(username + " borrowed the book(Number: " + bookNumber + ") successfully.");
  }

  public List<Record> readDataFromDatabase() {
    List<Record> records = new ArrayList<Record>();
    try {
      File file = new File("D:\\nextcloud\\desktop\\CS group project\\book_database.txt");
      Scanner scanner = new Scanner(file);
      
      // the first line is header, just skip it.
      scanner.nextLine();
      while (scanner.hasNextLine()) {
        String recordString = scanner.nextLine();
        Record record = new Record(recordString);
        records.add(record);
      }
    } catch(FileNotFoundException fileNotFoundException) {
      System.out.println("The library database is not found. Please check whether the book_database.txt is exising or not.");
    }
    return records;
  }

  public void saveDataToDatabase(List<Record> records) {
    try {
      File file = new File("D:\\nextcloud\\desktop\\CS group project\\book_database.txt");
      if (!file.exists()) {
        file.createNewFile();
      }

      FileWriter fw = new FileWriter("D:\\nextcloud\\desktop\\CS group project\\book_database.txt", false);
      // Write header.
      fw.write("Book Number	Name	Avaliable	Borrowed By	Borrowed Time");
      fw.write(System.lineSeparator());
      for (Record r : records) {
        fw.write(r.toString());
        fw.write(System.lineSeparator());
      }
      fw.close();
    } catch (Exception e) {
      
    }
  }

  //Connect to GUI 
  public static void main(String[] args) {
    System.out.println("Availiable commands: countAvailiable, Bookavailiability, Borrow");
    MyLibrary myLibrary = new MyLibrary();
    List<Record> records = myLibrary.readDataFromDatabase();
    Boolean end=false;
    while(end==false){
      Scanner inp=new Scanner(System.in);
      String inquiry=inp.nextLine();
      if(inquiry.equals("countAvailiable")){
        
        int total = myLibrary.countAvailiableBooks();
        System.out.println("The total count of availiable books is " + total);
      }
      if(inquiry.equals("Bookavailiability")){
      
        int days = 0;
        System.out.println("Input the index of book interested:");
        String bookindex=inp.nextLine();
        System.out.println("Query the borrow time of the book(FNumber: 1).");
        days = myLibrary.queryBorrowTime(bookindex);
        System.out.println("The borrow time of the book(Number: 1) is " + days + " days");
      }
      if(inquiry.equals("Borrow")){
        System.out.println("input book number:");
        String number=inp.nextLine();
        System.out.println("input name:");
        String Name=inp.nextLine();
        System.out.println(Name+" try to borrow the book"+number);
        myLibrary.borrowBook(Name, number);
        int total = myLibrary.countAvailiableBooks();
        System.out.println("The total count of availiable books is " + total);
      }
      if(inquiry.equals("end")){
        end=true;
        System.out.println("ending the program");
      }
      myLibrary.saveDataToDatabase(records);
    }
    
  }
  

}

// Book inventory-Alice
// It will access the database and when a book is borrowed by user, 
// a sign will be made on the book and the total number of books left not borrowed will be calculated.

// 1. Book inventory. Function: count number of books availiable. 

// 3. borrowing system--how long a book has been borrwed and by whom

