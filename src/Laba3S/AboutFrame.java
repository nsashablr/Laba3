package Laba3S;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AboutFrame extends JFrame {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 450;

    public AboutFrame() throws IOException {
        super("О программе");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width - WIDTH) / 2, (kit.getScreenSize().height - HEIGHT) / 2);
        Box vBoxText = Box.createVerticalBox();
        JLabel secondNameLabel = new JLabel();
        secondNameLabel.setText("Новоженина Саша");
        secondNameLabel.setFont (secondNameLabel.getFont ().deriveFont (35.0f));
        JLabel groupLabel = new JLabel();
        groupLabel.setText("Группа №6");
        groupLabel.setFont (groupLabel.getFont ().deriveFont (37.0f));
        vBoxText.add(Box.createVerticalGlue());
        vBoxText.add(secondNameLabel);
        vBoxText.add(Box.createVerticalStrut(15));
        vBoxText.add(groupLabel);
        vBoxText.add(Box.createVerticalGlue());
        Box contentBox = Box.createHorizontalBox();
        contentBox.add(Box.createHorizontalGlue());
        contentBox.add(Box.createVerticalStrut(30));
        contentBox.add(vBoxText);
        contentBox.add(Box.createHorizontalGlue());
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

    public static void main(String[] args) throws IOException {
        AboutFrame frame = new AboutFrame();
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}
