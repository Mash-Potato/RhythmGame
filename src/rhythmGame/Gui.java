package rhythmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;

    private Image Background=new ImageIcon(getClass().getClassLoader().getResource("images/introBackground.jpg")).getImage();

    private ImageIcon startButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startButton.jpg"));
    private ImageIcon endButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endButton.jpg"));
    private ImageIcon startPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startPressButton.jpg"));
    private ImageIcon endPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endPressButton.jpg"));

    private JButton startButton=new JButton(startButtonImage);
    private JButton endButton=new JButton(endButtonImage);

    //생성자
    public Gui() {
        setUndecorated(true);
        setTitle("리듬 게임");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);

        startButton.setBounds(40,200,400,100);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startPressButtonImage);
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonImage);
                startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                startButton.setVisible(false);
                Background=new ImageIcon(getClass().getClassLoader().getResource("images/mainBackground.jpg")).getImage();
            }
        });
        add(startButton);

        endButton.setBounds(1225,0,50,50);
        endButton.setBorderPainted(false);
        endButton.setContentAreaFilled(false);
        endButton.setFocusPainted(false);
        endButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                endButton.setIcon(endPressButtonImage);
                endButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                endButton.setIcon(endButtonImage);
                endButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        add(endButton);

        Music introMusic=new Music("introMusic.mp3", true);
        introMusic.start();
    }

    public void paint(Graphics g) {
        screenImage=createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic=screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }
    public void screenDraw(Graphics g) {
        g.drawImage(Background,0,0,null);
        paintComponents(g);
        this.repaint();

    }
}
