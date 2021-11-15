package rhythmGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Gui extends JFrame {

    private Image screenImage;
    private Graphics screenGraphic;


    private Image background=new ImageIcon(getClass().getClassLoader().getResource("images/introBackground.jpg")).getImage();

    private ImageIcon startButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startButton.jpg"));
    private ImageIcon endButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endButton.jpg"));
    private ImageIcon startPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startPressButton.jpg"));
    private ImageIcon endPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endPressButton.jpg"));

    private ImageIcon leftButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftButton.jfif"));
    private ImageIcon rightButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/rightButton.jfif"));
    private ImageIcon leftPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftPressButton.jfif"));
    private ImageIcon rightPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/rightPressButton.jfif"));

    private JButton startButton=new JButton(startButtonImage);
    private JButton endButton=new JButton(endButtonImage);
    private JButton leftButton=new JButton(leftButtonImage);
    private JButton rightButton=new JButton(rightButtonImage);

    private boolean isMainScreen=false;

    ArrayList<Track> trackList = new ArrayList<>();

    private Music selectedMusic;
    private Image selectImage;
    private int nowSelected = 0;

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

        Music introMusic=new Music("introMusic.mp3", true);
        introMusic.start();

        trackList.add(new Track("tropiclove.jpg","tropiclove.jpg","tropicLove.mp3","tropicLove.mp3"));
        trackList.add(new Track("summersong.jpg","summersong.jpg","summersong.mp3","summersong.mp3"));
        trackList.add(new Track("forever.jpg","forever.jpg","forever.mp3","forever.mp3"));

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
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                introMusic.close();
                selectTrack(0);
                background=new ImageIcon(getClass().getClassLoader().getResource("images/mainBackground.jpg")).getImage();
                isMainScreen=true;
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

        leftButton.setVisible(false);
        leftButton.setBounds(140,310,60,60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftPressButtonImage);
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonImage);
                leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectLeft();
            }
        });
        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080,310,60,60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightPressButtonImage);
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonImage);
                rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                selectRight();
            }
        });
        add(rightButton);
    }

    public void paint(Graphics g) {
        screenImage=createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic=screenImage.getGraphics();
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }
    public void screenDraw(Graphics g) {
        //실시간 동적으로 이미지함수 사용.
        g.drawImage(background,0,0,null);
        if (isMainScreen) {
            g.drawImage(selectImage, 340, 100, null);
        }
        //버튼 등은 paintComponents사용.
        paintComponents(g);
        this.repaint();

    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic!=null) {
            selectedMusic.close();
        }
        selectImage = new ImageIcon(getClass().getClassLoader().getResource("images/"+trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if (nowSelected==0) {
            nowSelected=trackList.size()-1;
        }
        else nowSelected--;
        selectTrack(nowSelected);
    }

    public void selectRight() {
        if (nowSelected==trackList.size()-1) {
            nowSelected=0;
        }
        else nowSelected++;
        selectTrack(nowSelected);
    }
}
