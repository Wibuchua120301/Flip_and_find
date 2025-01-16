package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardPanel extends JButton {
    private int numButtons;
    private JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
    private ImageIcon[] icons;
    private ImageIcon icon;
    private int count = 0;
    private JButton[] clickButtons = new JButton[2];

    public CardPanel() {
        buttons = new JButton[10];
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 50, 80, 50));
        setBackground(Color.white);
        setVisible(true);
        addButtons();

    }

    // Phương thức thêm Buttons vào CardPanel
    public void addButtons() {
        numButtons = 10;
        buttons = new JButton[numButtons];
        // Tạo mảng icons chứa các đối tượng ImageIcon để lưu trữ các biểu tượng (icon) cho các nút
        icons = new ImageIcon[numButtons];
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15); // Khoảng cách giữa các nút
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Chiếm đều không gian ngang
        gbc.weighty = 1.0; // Chiếm đều không gian dọc

        int[] test = shuffleIcons();
        for (int i = 0, j = 0; i < test.length; i++) {
            // Tạo biểu tượng
            buttons[i] = new JButton(String.valueOf(test[i]));
            buttons[i].setPreferredSize(new Dimension(100, 138));
            buttons[i].addActionListener(flip());

            // Set mặt lưng cho các nút
            icons[i] = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
            Image scaledImage = icons[j].getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(scaledImage);
            for (int k = 0; k < 20; k++) {
                buttons[j].setIcon(cardBack);
            }

            // Chỉnh vị trí cho các nút
            gbc.gridx = j % 5; // Cột
            gbc.gridy = j / 5; // Hàng
            add(buttons[j], gbc); // Thêm nút với GridBagConstraints
            j++;

        }
    }

    // Trộn các nút ngẫu nhiên
    public int[] shuffleIcons() {
        int[] numbers = new int[10];
        for (int i = 0; i < 5; i++) {
            numbers[i * 2] = i + 1;
            numbers[i * 2 + 1] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int j = rand.nextInt(numbers.length); // Chọn chỉ số ngẫu nhiên
            // Hoán đổi phần tử tại vị trí i và j
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    public ActionListener flip() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource(); // Lấy nút đã nhấn
                icon = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
                Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImage);
                String click = e.getActionCommand();
                switch (click) {
                    case "1" -> {
                        imgBehind("src\\FlipAndFindGame\\img\\darkness.jpg", button);
                        gamePlay(button);
                        break;
                    }
                    case "2" -> {
                        imgBehind("src\\FlipAndFindGame\\img\\dragon.jpg", button);
                        gamePlay(button);
                        break;
                    }
                    case "3" -> {
                        imgBehind("src\\FlipAndFindGame\\img\\metal.jpg", button);
                        gamePlay(button);
                        break;
                    }
                    case "4" -> {
                        imgBehind("src\\FlipAndFindGame\\img\\fairy.jpg", button);
                        gamePlay(button);
                        break;
                    }
                    case "5" -> {
                        imgBehind("src\\FlipAndFindGame\\img\\fighting.jpg", button);
                        gamePlay(button);
                        break;
                    }
                }
            }
        };
    }

    public void imgBehind(String s, JButton button) {
        icon = new ImageIcon(s);
        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        button.setIcon(icon);
    }
    public void gamePlay(JButton button) {
        if (count < 2) {
            clickButtons[count] = button; // Lưu nút vừa nhấn vào mảng
            count++;
        }

        if (count == 2) {
            if (clickButtons[0].getActionCommand().equals(clickButtons[1].getActionCommand())) {
                // Trường hợp 2 nút giống nhau
                clickButtons[0].setEnabled(false);
                clickButtons[1].setEnabled(false);
            } else {
                // Trường hợp 2 nút khác nhau
                clickButtons[0].setIcon(icon);
                clickButtons[1].setIcon(icon);
            }
            clickButtons[0] = null;
            clickButtons[1] = null;
            count = 0;
        }
    }
}




