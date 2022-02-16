import java.time.Duration;
import java.time.LocalDateTime;

public class Record {
  private String name;
  private String number;
  private boolean availiable;
  private String borrowedBy;
  private LocalDateTime borrowedTime;

  public Record(String record) {
    String[] datas = record.split("\t");
    number = datas[0];
    name = datas[1];
    if (datas[2].equals("1")) {
      availiable = true;
    } else {
      availiable = false;
    }
    borrowedBy = datas[3];
    borrowedTime = LocalDateTime.parse(datas[4]);
  }
  
  public String getName() {
    return name;
  }

  public String getNumber() {
    return number;
  }

  public boolean getAvailiable() {
    return availiable;
  }

  public String getBorrowedBy() {
    return borrowedBy;
  }

  public void setBorrowedBy(String user) {
    borrowedBy = user;
    borrowedTime = LocalDateTime.now();
    availiable = false;
  }

  public LocalDateTime getBorrowedTime() {
    return borrowedTime;
  }

  public int computeDaysToNow() {
    return (int)Duration.between(borrowedTime, LocalDateTime.now()).toDays();
  }

  public String toString() {
    int a = 0;
    if (availiable) {
      a = 1;
    }
    return number + "\t" + name + "\t" + a + "\t" + borrowedBy + "\t" + borrowedTime.toString();
  }
  
}
