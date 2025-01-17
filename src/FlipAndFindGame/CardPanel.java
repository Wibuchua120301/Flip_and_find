package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.Timer;

public class CardPanel extends JButton {
    private Image background;
    private ImageIcon iconBack;
    private JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
    private ImageIcon[] icons;
    private ImageIcon icon;
    private int count = 0;
    private JButton[] clickButtons = new JButton[3];

    public CardPanel() {
        buttons = new JButton[10];
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 50, 80, 50));
        background = new ImageIcon("src\\FlipAndFindGame\\img\\Pokemon.jpg").getImage();
        setVisible(true);
        addButtons();

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    // Phương thức thêm Buttons vào CardPanel
    public void addButtons() {
        buttons = new JButton[10];
        // Tạo mảng icons chứa các đối tượng ImageIcon để lưu trữ các biểu tượng (icon) cho các nút
        icons = new ImageIcon[10];
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15); // Khoảng cách giữa các nút
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Chiếm đều không gian ngang
        gbc.weighty = 1.0; // Chiếm đều không gian dọc

        int[] test = shuffleIcons();
        for (int i = 0, j = 0; i < test.length; i++) {
            buttons[i] = new JButton(String.valueOf(test[i]));
            buttons[i].setPreferredSize(new Dimension(100, 138));
            buttons[i].addActionListener(flip());

            // Set mặt trước cho các nút
            final int index = i;
            buttons[i].addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int width = buttons[index].getWidth();
                    int height = buttons[index].getHeight();
                    ImageIcon cardBack = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
                    Image scaledImage = cardBack.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    icons[index] = new ImageIcon(scaledImage);
                    buttons[index].setIcon(icons[index]);
                }
            });

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
        icon = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        iconBack = new ImageIcon(scaledImage);
        clickButtons[count] = button; // Lưu nút vừa nhấn vào mảng
        count++;
        if (count == 2) {
            if (clickButtons[0].getActionCommand().equals(clickButtons[1].getActionCommand()) && !(clickButtons[0].getLocation().equals(clickButtons[1].getLocation()))) {
                // Trường hợp 2 nút giống nhau
                clickButtons[0].setVisible(false);
                clickButtons[1].setVisible(false);
//            } else {
//                clickButtons[0].setIcon(iconBack);
//                clickButtons[1].setIcon(iconBack);
            } else if ((clickButtons[0].getActionCommand().equals(clickButtons[1].getActionCommand()) && !(clickButtons[0].getLocation().equals(clickButtons[1].getLocation()))) == false) {
                clickButtons[0].setIcon(iconBack);
                clickButtons[1].setIcon(iconBack);
            }
//            if (count == 3) {
//                // Trường hợp 2 nút khác nhau
//                // Tạo một Timer để trì hoãn việc đặt lại iconBack
//                if (clickButtons[2].getActionCommand().equals(clickButtons[2].getActionCommand())) {
//                    Timer timer = new Timer(0, e -> {
//                        clickButtons[0].setIcon(iconBack);
//                        clickButtons[1].setIcon(iconBack);
//                        count = 0; // Reset lại đếm sau khi hoàn thành
//                    });
//                    timer.setRepeats(false); // Chỉ chạy một lần
//                    timer.start();
//                    return; // Tránh reset clickButtons và count ngay lập tức
//                } else {
//                    Timer timer = new Timer(1000, e -> {
//                        clickButtons[0].setIcon(iconBack);
//                        clickButtons[1].setIcon(iconBack);
//                        count = 0; // Reset lại đếm sau khi hoàn thành
//                    });
//                    timer.setRepeats(false); // Chỉ chạy một lần
//                    timer.start();
//                    return;
//                }
//            } else if (!(clickButtons[0].getActionCommand().equals(clickButtons[1].getActionCommand()))) {
//                Timer timer = new Timer(1000, e -> {
//                    clickButtons[0].setIcon(iconBack);
//                    clickButtons[1].setIcon(iconBack);
//                    clickButtons[0] = null;
//                    clickButtons[1] = null;
//                    clickButtons[2] = null;
//                    count = 0; // Reset lại đếm sau khi hoàn thành
//                });
//                timer.setRepeats(false); // Chỉ chạy một lần
//                timer.start();
//                return;
//            }
        }
        clickButtons[0] = null;
        clickButtons[1] = null;
        clickButtons[2] = null;
        count = 0;
    }
}




