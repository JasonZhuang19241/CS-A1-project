import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class firstpage extends JFrame implements ActionListener {
    Container container=getContentPane();
    JLabel titlename=new JLabel("SCIE Library System");
    JLabel userLabel=new JLabel("USERNAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JTextField userTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JButton loginButton=new JButton("LOGIN");
    JButton resetButton=new JButton("RESET");
   
    JCheckBox showPassword=new JCheckBox("Show Password");
 
 
    firstpage()
    {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
 
    }
   public void setLayoutManager()
   {
       container.setLayout(null);
   }
   public void setLocationAndSize()
   {
       titlename.setBounds(120,80,190,30);
       userLabel.setBounds(50,150,100,30);
       passwordLabel.setBounds(50,220,100,30);
       userTextField.setBounds(150,150,150,30);
       passwordField.setBounds(150,220,150,30);
       showPassword.setBounds(150,250,150,30);
       loginButton.setBounds(50,300,100,30);
       resetButton.setBounds(200,300,100,30);
 
 
   }
   public void addComponentsToContainer()
   {
       container.add(titlename);
       container.add(userLabel);
       container.add(passwordLabel);
       container.add(userTextField);
       container.add(passwordField);
       container.add(showPassword);
       container.add(loginButton);
       container.add(resetButton);
   }
   public void addActionEvent()
   {
       loginButton.addActionListener(this);
   }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        String Username = userTextField.getText();
        String Password1 = passwordField.getText();

        if (Username.equals("scie.com") && Password1.equals("admin")){
            JOptionPane.showMessageDialog(null, "Login Successful");
            loginButton.setVisible(false);
            userLabel.setVisible(false);
            passwordLabel.setVisible(false);
            userTextField.setVisible(false);
            passwordField.setVisible(false);
            loginButton.setVisible(false);
            resetButton.setVisible(false);
            showPassword.setVisible(false);
            secondpage frame2 = new secondpage();
            frame2.setTitle("Choice page");
            frame2.setVisible(true);
            frame2.setBounds(10, 10, 370, 600);
            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame2.setResizable(false);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
        }
    }
}
//GUI covered by Jason
 
