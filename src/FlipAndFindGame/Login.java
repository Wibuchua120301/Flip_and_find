package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel {
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton exit;
    private JButton login;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private FlipAndFindGame mainFrame;
    public Login() {
        this.mainFrame= mainFrame;
        lblPassword = new JLabel();
        txtPassword = new JPasswordField();
        lblUsername = new JLabel();
        txtUsername = new JTextField();
        login = new JButton("Login");
        exit = new JButton("Exit");
        setBackground(new Color(173,216,200));
        setLayout(null);
        setBounds(0,0,400,400);
        lblUsername.setBounds(50,40,100,30);
        lblUsername.setForeground(Color.BLACK);

        txtUsername.setBounds(120,30,180,35);

        login.setBounds(70,150,100,30);

        exit.setBounds(220,150,100,30);
        exit.setBackground(new Color(220,20,60));
        exit.setForeground(Color.white);

        txtPassword.setBounds(120,90,180,35);

        lblPassword.setBounds(50,100,100,30);
        lblPassword.setForeground(Color.BLACK);

        login.addActionListener(loginButton());

        exit.addActionListener(exitButton());
        add(lblPassword);
        add(lblUsername);
        add(login);
        add(exit);
        add(txtUsername);
        add(txtPassword);
    }

    public ActionListener loginButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if(username.equals("admin")&& password.equals("1234567")) {
                    JOptionPane.showMessageDialog(null,"Đăng nhập thành công!");
                    JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(Login.this);
                    if (topFrame instanceof FlipAndFindGame){
                        ((FlipAndFindGame) topFrame).showPanel("GamePanel");
                    }
                } else {
                    JOptionPane.showMessageDialog(null,"Tên đăng nhập hoặc mật khẩu sai!");

                }

            }
        };
    }
    public ActionListener exitButton() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }

}
