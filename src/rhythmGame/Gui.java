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
    private Image gameInfoImage=new ImageIcon(getClass().getClassLoader().getResource("images/gameinfo.png")).getImage();
    private Image judgementLineImage=new ImageIcon(getClass().getClassLoader().getResource("images/judgementline.png")).getImage();
    private Image noteRouteImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteLineImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRouteLine.png")).getImage();
    private Image noteImage=new ImageIcon(getClass().getClassLoader().getResource("images/note.png")).getImage();

    private ImageIcon startButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startButton.jpg"));
    private ImageIcon endButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endButton.jpg"));
    private ImageIcon startPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/startPressButton.jpg"));
    private ImageIcon endPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/endPressButton.jpg"));
    private ImageIcon leftButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftButton.jfif"));
    private ImageIcon rightButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/rightButton.jfif"));
    private ImageIcon leftPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftPressButton.jfif"));
    private ImageIcon rightPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/rightPressButton.jfif"));
    private ImageIcon easyButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/easyButton.png"));
    private ImageIcon hardButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/hardButton.png"));
    private ImageIcon easyPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/easyPressButton.png"));
    private ImageIcon hardPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/hardPressButton.png"));
    private ImageIcon backButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftButton.jfif"));
    private ImageIcon backPressButtonImage=new ImageIcon(getClass().getClassLoader().getResource("images/leftPressButton.jfif"));

    private JButton startButton=new JButton(startButtonImage);
    private JButton endButton=new JButton(endButtonImage);
    private JButton leftButton=new JButton(leftButtonImage);
    private JButton rightButton=new JButton(rightButtonImage);
    private JButton easyButton=new JButton(easyButtonImage);
    private JButton hardButton=new JButton(hardButtonImage);
    private JButton backButton=new JButton(backButtonImage);

    private boolean isMainScreen=false;
    private boolean isGameScreen=false;

    ArrayList<Track> trackList = new ArrayList<>();

    private Music selectedMusic;
    private Music introMusic=new Music("introMusic.mp3", true);
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

        introMusic.start();

        trackList.add(new Track("tropiclove.jpg","tropicloveGame.jpg","tropicLove.mp3","tropicLove.mp3"));
        trackList.add(new Track("summersong.jpg","summersongGame.jpg","summersong.mp3","summersong.mp3"));
        trackList.add(new Track("forever.jpg","foreverGame.jpg","forever.mp3","forever.mp3"));

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
                enterMain();
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

        easyButton.setVisible(false);
        easyButton.setBounds(375,580,250,67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.setFocusPainted(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyButton.setIcon(easyPressButtonImage);
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonImage);
                easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(nowSelected,"easy");
            }
        });
        add(easyButton);

        hardButton.setVisible(false);
        hardButton.setBounds(655,580,250,67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.setFocusPainted(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardButton.setIcon(hardPressButtonImage);
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonImage);
                hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                gameStart(nowSelected,"hard");
            }
        });
        add(hardButton);

        backButton.setVisible(false);
        backButton.setBounds(20,50,60,60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backPressButtonImage);
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonImage);
                backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
            @Override
            public void mousePressed(MouseEvent e) {
                backMain();
            }
        });
        add(backButton);
    }

    public void paint(Graphics g) {
        screenImage=createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        screenGraphic=screenImage.getGraphics();
        screenDraw((Graphics2D)screenGraphic);
        g.drawImage(screenImage,0,0,null);
    }

    public void screenDraw(Graphics2D g) {
        //실시간 동적으로 이미지함수 사용.
        g.drawImage(background,0,0,null);
        if (isMainScreen) {
            g.drawImage(selectImage, 340, 100, null);
        }
        if (isGameScreen) {
            g.drawImage(noteRouteImage, 228, 30, null);
            g.drawImage(noteRouteImage, 332, 30, null);
            g.drawImage(noteRouteImage, 436, 30, null);
            g.drawImage(noteRouteImage, 540, 30, null);
            g.drawImage(noteRouteImage, 640, 30, null);
            g.drawImage(noteRouteImage, 744, 30, null);
            g.drawImage(noteRouteImage, 848, 30, null);
            g.drawImage(noteRouteImage, 952, 30, null);
            g.drawImage(noteRouteLineImage, 224, 30, null);
            g.drawImage(noteRouteLineImage, 328, 30, null);
            g.drawImage(noteRouteLineImage, 432, 30, null);
            g.drawImage(noteRouteLineImage, 536, 30, null);
            g.drawImage(noteRouteLineImage, 740, 30, null);
            g.drawImage(noteRouteLineImage, 844, 30, null);
            g.drawImage(noteRouteLineImage, 948, 30, null);
            g.drawImage(noteRouteLineImage, 1052, 30, null);
            g.drawImage(gameInfoImage, 0, 660, null);
            g.drawImage(judgementLineImage, 0, 580, null);
            g.drawImage(noteImage, 228, 120, null);
            g.drawImage(noteImage, 332, 580, null);
            g.drawImage(noteImage, 436, 500, null);
            g.drawImage(noteImage, 540, 340, null);
            g.drawImage(noteImage, 640, 340, null);
            g.drawImage(noteImage, 744, 325, null);
            g.drawImage(noteImage, 848, 305, null);
            g.drawImage(noteImage, 952, 305, null);
            g.setColor(Color.WHITE);
            g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial",Font.BOLD, 30));
            g.drawString("Tropic Love",20,702);
            g.drawString("Easy",1190,702);
            g.setFont(new Font("Arial",Font.BOLD, 26));
            g.setColor(Color.DARK_GRAY);
            g.drawString("S",270,609);
            g.drawString("D",374,609);
            g.drawString("F",478,609);
            g.drawString("Space bar",580,609);
            g.drawString("J",784,609);
            g.drawString("K",889,609);
            g.drawString("L",993,609);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Elephant",Font.BOLD, 30));
            g.drawString("000000",565,702);
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

    public void gameStart(int nowSelected,String difficulty) {
        if (selectedMusic!=null) {
            selectedMusic.close();
        }
        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        background=new ImageIcon(getClass().getClassLoader().getResource("images/"+trackList.get(nowSelected).getGameImage())).getImage();
        backButton.setVisible(true);
        isGameScreen=true;
    }

    public void backMain() {
        isMainScreen=true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        background=new ImageIcon(getClass().getClassLoader().getResource("images/mainBackground.jpg")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen=false;
    }

    public void enterMain() {
        startButton.setVisible(false);
        background=new ImageIcon(getClass().getClassLoader().getResource("images/mainBackground.jpg")).getImage();
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        selectTrack(0);
        isMainScreen=true;
        introMusic.close();
    }
}
