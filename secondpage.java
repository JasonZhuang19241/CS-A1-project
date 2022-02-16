import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class secondpage extends JFrame implements ActionListener{
    Container container=getContentPane();
    JButton bookinventory=new JButton("bookinventory");
    JButton entry=new JButton("entry");
    JButton borrow=new JButton("borrow");
    JButton ranking=new JButton("ranking");

    secondpage()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();//calling addActionEvent() method
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   
    public void entry(){
        try
        { 
         // We are running "dir" and "ping" command on cmd
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\nextcloud\\desktop\\CS group project\\entrance.cmd\"");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
    public void bookinventory(){
        try
        { 
         // We are running "dir" and "ping" command on cmd
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\nextcloud\\desktop\\CS group project\\Mylib.cmd\"");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
    public void borrow(){
        try
        { 
         // We are running "dir" and "ping" command on cmd
         Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"D:\\nextcloud\\desktop\\CS group project\\Mylib.cmd\"");
        }
        catch (Exception e)
        {
            System.out.println("HEY Buddy ! U r Doing Something Wrong ");
            e.printStackTrace();
        }
    }
    public void ranking(){
        System.out.println("do function");
    }

   public void setLocationAndSize()
   {
       bookinventory.setBounds(80,160,180,50);
       entry.setBounds(80,210,180,50);
       borrow.setBounds(80,260,180,50);
       ranking.setBounds(80,310,180,50);
   }
   
   public void addComponentsToContainer()
   {
       container.add(bookinventory);
       container.add(entry);
       container.add(borrow);
       container.add(ranking);
   }

   public void addActionEvent()
   {
      //adding Action listener to components
       bookinventory.addActionListener(this);
       entry.addActionListener(this);
       borrow.addActionListener(this);
       ranking.addActionListener(this);
   }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bookinventory){
            bookinventory();
        }
        if(e.getSource() == entry){
            entry();
        }
        if(e.getSource() == borrow){
            borrow();
        }
        if(e.getSource() == ranking){
            ranking();
        }

       
    }
}
//GUI written by jason and adapted to fit everyone's modules