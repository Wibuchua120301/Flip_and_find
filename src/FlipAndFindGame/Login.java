package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public static void main(String[] args) {
        // Tạo JFrame
        JFrame frame= new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);

        // Thêm nền màu
        JPanel panel = new JPanel();
        panel.setBounds(0,0,400,400);
        panel.setBackground(new Color(173,216,200));
        panel.setLayout(null);
        frame.add(panel);

//Tạo JLabel và JTextField cho UserName
        JLabel lblUsername = new JLabel("UserName:");
        lblUsername.setBounds(50,40,100,30);
        lblUsername.setForeground(Color.BLACK);

        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(120,30,180,35);

        //Tạo JLabel và JPasswordField cho PassWord
        JLabel lblPassword = new JLabel("PassWord:");
        lblPassword.setBounds(50,100,100,30);
        lblPassword.setForeground(Color.BLACK);// Màu chữ

        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(120,90,180,35);

        //Tạo nút "Login"
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(70,150,100,30);
        // btnLogin.setFont(new Font("Tahoma",Font.BOLD,12));
        btnLogin.setBackground(new Color(0,128,0));
        btnLogin.setForeground(Color.WHITE);

        // tạo nút "Exit"
        JButton btnExit = new JButton("Exit"   );
        btnExit.setBounds(220,150,100,30);
        btnExit.setBackground(new Color(220,20,60));
        btnExit.setForeground(Color.white);

        //Thêm các JLabel và JTextField,JButton vào panel
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnExit);

        //Thêm chức năng cho nút "Login"
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if(username.equals("admin")&& password.equals("1234567")) {
                    JOptionPane.showMessageDialog(frame,"Đăng nhập thành công!");
                } else {
                    JOptionPane.showMessageDialog(frame,"Tên đăng nhập hoặc mật khẩu sai!");

                }

            }
        });
        // Thêm chức năng cho nút "Exit"
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
//        Hiện thị giao diện
        frame.setLocationRelativeTo(null);//Canh giữa màn hình
        frame.setVisible(true);
    }
}
