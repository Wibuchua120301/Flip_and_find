package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardPanel extends JButton {
    private int numButtons;
    private String[] pics = {"./img/darkness.jpg", "./img/double.jpg", "./img/fairy.jpg", "./img/fighting.jpg", "./img/fire.jpg", "./img/grass.jpg", "./img/lightning.jpg", "./img/metal.jpg", "./img/psychic.jpg", "./img/water.jpg"};
    //    private String[] cardList = {"darkness", "double", "fairy", "fighting", "fire", "grass", "lightning", "metal", "psychic", "water"};
    private JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon(this.getClass().getResource("./img/back.jpg"));
    private ImageIcon[] icons;
    private ImageIcon temp;
    int columns = 5;
    int rows = 4;
    private static int score = 0;
    private boolean gameOver;
    Timer myTimer;
    int openImages;
    public int currentIndex;
    public int oddClickIndex;
    public int numClicks;

    public CardPanel() {
        buttons = new JButton[20];
//        setLayout(null);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 50, 80, 50));
        setBackground(Color.white);
        setVisible(true);
        addButtons();
    }

    // Phương thức thêm Buttons vào CardPanel
    public void addButtons() {
        numButtons = pics.length * 2;
        buttons = new JButton[numButtons];
        // Tạo mảng icons chứa các đối tượng ImageIcon để lưu trữ các biểu tượng (icon) cho các nút
        icons = new ImageIcon[numButtons];
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15); // Khoảng cách giữa các nút
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Chiếm đều không gian ngang
        gbc.weighty = 1.0; // Chiếm đều không gian dọc

        for (int i = 0, j = 0; i < pics.length; i++) {
            // Tạo biểu tượng
            icons[j] = new ImageIcon(this.getClass().getResource(pics[i]));
            Image scaledImage = icons[j].getImage().getScaledInstance(90, 128, Image.SCALE_SMOOTH);
            icons[j] = new ImageIcon(scaledImage);

            for (int k = 0; k < 2; k++) {
                buttons[j] = new JButton();
                buttons[j].setIcon(cardBack);

                gbc.gridx = j % 5; // Cột
                gbc.gridy = j / 5; // Hàng
                add(buttons[j], gbc); // Thêm nút với GridBagConstraints
                j++;


            }
        }


        // Tạo một đối tượng Random để tạo các số ngẫu nhiên. Điều này sẽ được sử dụng để xáo trộn các biểu tượng của các nút.
        Random rnd = new Random();
        // Khởi tạo một vòng lặp for để lặp qua tất cả các nút.
        for (int i = 0;
             i < numButtons; i++) {
            // Tạo một số ngẫu nhiên j từ 0 đến numButtons - 1. j sẽ được dùng để hoán đổi các biểu tượng giữa các nút
            int j = rnd.nextInt(numButtons);
            // Tạo một biến tạm temp để lưu trữ biểu tượng của nút tại vị trí i
            temp = icons[i];
            // Gán biểu tượng của nút j cho nút i
            icons[i] = icons[j];
            // Gán biểu tượng tạm temp (biểu tượng ban đầu của nút i) cho nút j
            icons[j] = temp;

        }
    }
}




