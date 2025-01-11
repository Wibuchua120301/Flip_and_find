package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
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

    public CardPanel() {
        buttons = new JButton[20];
        setLayout(null);
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
        // Khởi tạo một vòng lặp for để lặp qua tất cả các phần tử trong mảng pics. Biến i sẽ được sử dụng để truy cập mảng pics, còn biến j sẽ dùng để truy cập mảng buttons và icons
        for (int i = 0, j = 0; i < pics.length; i++) {
            // Tạo nút thứ nhất
            icons[j] = new ImageIcon(this.getClass().getResource(pics[i]));
            Image scaledImage = icons[j].getImage().getScaledInstance(245, 140, Image.SCALE_SMOOTH);
            icons[j] = new ImageIcon(scaledImage);
            buttons[j] = new JButton();
            buttons[j].setBounds(50 + (245 + 50) * (j % columns), 50 + (140 + 50) * (j / columns), 245, 140);
            buttons[j].setIcon(cardBack);
            // Thêm nút j vào CardPanel. j++ sẽ tăng j sau khi nút được thêm vào, để tiếp tục xử lý nút tiếp theo trong mảng
            add(buttons[j++]);

            // Tạo nút thứ hai
            // Đặt biểu tượng cho nút thứ hai bằng với biểu tượng của nút trước đó (icons[j - 1]). Điều này đảm bảo rằng nút thứ hai có cùng hình ảnh với nút đầu tiên, vì chúng phải là cặp giống nhau trong trò chơi
            icons[j] = icons[j - 1];

            buttons[j] = new JButton();
            buttons[j].setBounds(50 + (245 + 50) * (j % columns), 50 + (140 + 50) * (j / columns), 245, 140);
            buttons[j].setIcon(cardBack);
            add(buttons[j++]);
        }
        // Tạo một đối tượng Random để tạo các số ngẫu nhiên. Điều này sẽ được sử dụng để xáo trộn các biểu tượng của các nút.
        Random rnd = new Random();
        // Khởi tạo một vòng lặp for để lặp qua tất cả các nút.
        for (int i = 0; i < numButtons; i++) {
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


