package virtuall_classroom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Login_t extends JFrame implements ActionListener {

    JLabel l1, l2, l3;  

    JTextField tf1;

    JButton btn1; 

    JPasswordField p1; 

    File f = new File("C:\\Files");   
    int ln;
   
    void createFolder() {
        if (!f.exists()) {
            f.mkdirs();
        }
    }
    void readFile() {
        try {
            FileReader fr = new FileReader(f + "\\login.txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f + "\\login.txt");
                System.out.println("File created");
            } catch (IOException ex1) {
            }
        }

    }

    void logic(String usr, String pswd) {
        try {
            RandomAccessFile raf = new RandomAccessFile(f + "\\login.txt", "rw");
            for (int i = 0; i < ln; i += 7) {
                System.out.println("count " + i);

                String forUser = raf.readLine().substring(6);
                String forPswd = raf.readLine().substring(9);
                System.out.println(forUser + forPswd);
                if (usr.equals(forUser) & pswd.equals(forPswd)) {
                    JOptionPane.showMessageDialog(null, "Login Successfully!!");
                    dispose();
                    study_mat.main(null);
                    break;
                } else if (i == (ln - 6)) {
                    JOptionPane.showMessageDialog(null, "incorrect username/password");
                    break;
                }
                for (int k = 1; k <= 5; k++) {
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    void countLines() {
        try {
            ln = 0;
            RandomAccessFile raf = new RandomAccessFile(f + "\\login.txt", "rw");
            for (int i = 0; raf.readLine() != null; i++) {
                ln++;
            }
            System.out.println("number of lines:" + ln);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    Login_t() {
    	getContentPane().setBackground(new Color(102, 205, 170));

        setTitle("VIRTUAL CLASSROOM BY HARSHAVARDHAN GN");

        setVisible(true);

        setSize(690, 351);

        getContentPane().setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        l1 = new JLabel("Sign_In");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

        l2 = new JLabel("Enter Email:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 10));

        l3 = new JLabel("Enter Password:");
        l3.setFont(new Font("Tahoma", Font.BOLD, 10));

        tf1 = new JTextField();

        p1 = new JPasswordField();

        btn1 = new JButton("Submit");
        btn1.setBackground(new Color(107, 142, 35));
        btn1.setForeground(new Color(255, 255, 255));

        l1.setBounds(20, 10, 400, 30);

        l2.setBounds(80, 70, 200, 30);

        l3.setBounds(80, 110, 200, 30);

        tf1.setBounds(300, 70, 200, 30);

        p1.setBounds(300, 110, 200, 30);

        btn1.setBounds(400, 195, 100, 30);

        getContentPane().add(l1);

        getContentPane().add(l2);

        getContentPane().add(tf1);

        getContentPane().add(l3);

        getContentPane().add(p1);

        getContentPane().add(btn1);

        btn1.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {

        showData();

    }

    public void showData() {

        JFrame f1 = new JFrame();

        JLabel l, l0;

        String str1 = tf1.getText();

        char[] p = p1.getPassword();

        String str2 = new String(p);

        try {

            createFolder();
            readFile();
            countLines();
            logic(str1, str2);

        } catch (Exception ex) {

            System.out.println(ex);

        }
    }
    public static void main(String arr[]) {

        new Login_t();

    }

}


