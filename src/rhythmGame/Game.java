package rhythmGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread {

    private Image noteRouteLineImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRouteLine.png")).getImage();
    private Image judgementLineImage=new ImageIcon(getClass().getClassLoader().getResource("images/judgementline.png")).getImage();
    private Image gameInfoImage=new ImageIcon(getClass().getClassLoader().getResource("images/gameinfo.png")).getImage();
    private Image noteRouteSImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteDImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteFImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteJImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteKImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image noteRouteLImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    private Image flareImage;
    private Image judgeImage;
    private Image keypadSImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadDImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadFImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadJImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadKImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    private Image keypadLImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    private int combo=0;

    ArrayList<Note> noteList = new ArrayList<>();

    public Game(String titleName, String difficulty, String musicTitle) {
        this.titleName=titleName;
        this.difficulty=difficulty;
        this.musicTitle=musicTitle;
        gameMusic = new Music(this.musicTitle,false);
    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(noteRouteSImage, 228, 30, null);
        g.drawImage(noteRouteDImage, 332, 30, null);
        g.drawImage(noteRouteFImage, 436, 30, null);
        g.drawImage(noteRouteSpace1Image, 540, 30, null);
        g.drawImage(noteRouteSpace2Image, 640, 30, null);
        g.drawImage(noteRouteJImage, 744, 30, null);
        g.drawImage(noteRouteKImage, 848, 30, null);
        g.drawImage(noteRouteLImage, 952, 30, null);
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
        for (int i=0; i<noteList.size(); i++) {
            Note note = noteList.get(i);
            if (note.getY()>620) {
                judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/miss.png")).getImage();
                combo=0;
            }
            if (!note.isProceeded()) {
                noteList.remove(i);
                i--;
            }
            else {
                note.screenDraw(g);
            }
        }
        g.setColor(Color.WHITE);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial",Font.BOLD, 30));
        g.drawString(titleName, 20, 702);
        g.drawString(difficulty,1190,702);
        g.setFont(new Font("Arial",Font.BOLD, 26));
        g.setColor(Color.DARK_GRAY);
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space bar",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Elephant",Font.BOLD, 50));
        g.drawString(String.valueOf(combo),630,370);
        g.drawImage(flareImage, 300, 380, null);
        g.drawImage(judgeImage, 460, 420, null);
        g.drawImage(keypadSImage,228,580,null);
        g.drawImage(keypadDImage,332,580,null);
        g.drawImage(keypadFImage,436,580,null);
        g.drawImage(keypadSpace1Image,540,580,null);
        g.drawImage(keypadSpace2Image,640,580,null);
        g.drawImage(keypadJImage,744,580,null);
        g.drawImage(keypadKImage,848,580,null);
        g.drawImage(keypadLImage,952,580,null);
    }

    public void pressS() {
        judge("S");
        noteRouteSImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadSImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadSImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressD() {
        judge("D");
        noteRouteDImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadDImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumSmall3.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadDImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressF() {
        judge("F");
        noteRouteFImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadFImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadFImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressSpace() {
        judge("Space");
        noteRouteSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        keypadSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        noteRouteSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
        keypadSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressJ() {
        judge("J");
        noteRouteJImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadJImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadJImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressK() {
        judge("K");
        noteRouteKImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadKImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadKImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    public void pressL() {
        judge("L");
        noteRouteLImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        keypadLImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        keypadLImage=new ImageIcon(getClass().getClassLoader().getResource("images/keypad.png")).getImage();
    }

    @Override
    public void run() {
        dropNotes(this.titleName);
    }

    public void close() {
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName) {
        Beat[] beats = null;
        if (titleName.equals("Tropic Love") && difficulty.equals("Easy")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 114;
            beats = new Beat[] {
                    new Beat(starTime, "Space"),
                    new Beat(starTime + gap * 5, "Space"),
                    new Beat(starTime + gap * 10, "Space"),
                    new Beat(starTime + gap * 15, "Space"),
                    new Beat(starTime + gap * 20, "Space"),
                    new Beat(starTime + gap * 25, "S"),
                    new Beat(starTime + gap * 30, "D"),
                    new Beat(starTime + gap * 35, "F"),
                    new Beat(starTime + gap * 40, "Space"),
                    new Beat(starTime + gap * 45, "J"),
                    new Beat(starTime + gap * 50, "K"),
                    new Beat(starTime + gap * 55, "L"),
                    new Beat(starTime + gap * 60, "Space"),
                    new Beat(starTime + gap * 65, "L"),
                    new Beat(starTime + gap * 70, "K"),
                    new Beat(starTime + gap * 75, "J"),
                    new Beat(starTime + gap * 80, "Space"),
                    new Beat(starTime + gap * 85, "F"),
                    new Beat(starTime + gap * 90, "D"),
                    new Beat(starTime + gap * 95, "S"),
                    new Beat(starTime + gap * 100, "Space"),
                    new Beat(starTime + gap * 105, "S"),
                    new Beat(starTime + gap * 110, "D"),
                    new Beat(starTime + gap * 115, "F"),
                    new Beat(starTime + gap * 120, "Space"),
                    new Beat(starTime + gap * 125, "J"),
                    new Beat(starTime + gap * 130, "K"),
                    new Beat(starTime + gap * 135, "L"),
            };
        }
        else if (titleName.equals("Tropic Love") && difficulty.equals("Hard")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 105;
            beats = new Beat[] {
                    new Beat(starTime, "S"),
                    new Beat(starTime + gap * 2, "K"),
                    new Beat(starTime + gap * 4, "D"),
                    new Beat(starTime + gap * 6, "L"),
                    new Beat(starTime + gap * 8, "F"),
                    new Beat(starTime + gap * 10, "J"),
                    new Beat(starTime + gap * 12, "Space"),
            };
        }
        else if (titleName.equals("Summer Song") && difficulty.equals("Easy")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 105;
            beats = new Beat[] {
                    new Beat(starTime, "S"),
                    new Beat(starTime + gap * 2, "K"),
                    new Beat(starTime + gap * 4, "D"),
                    new Beat(starTime + gap * 6, "L"),
                    new Beat(starTime + gap * 8, "F"),
                    new Beat(starTime + gap * 10, "J"),
                    new Beat(starTime + gap * 12, "Space"),
            };
        }
        else if (titleName.equals("Summer Song") && difficulty.equals("Hard")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 105;
            beats = new Beat[] {
                    new Beat(starTime, "S"),
                    new Beat(starTime + gap * 2, "K"),
                    new Beat(starTime + gap * 4, "D"),
                    new Beat(starTime + gap * 6, "L"),
                    new Beat(starTime + gap * 8, "F"),
                    new Beat(starTime + gap * 10, "J"),
                    new Beat(starTime + gap * 12, "Space"),
            };
        }
        else if (titleName.equals("Forever") && difficulty.equals("Easy")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 105;
            beats = new Beat[] {
                    new Beat(starTime, "S"),
                    new Beat(starTime + gap * 2, "K"),
                    new Beat(starTime + gap * 4, "D"),
                    new Beat(starTime + gap * 6, "L"),
                    new Beat(starTime + gap * 8, "F"),
                    new Beat(starTime + gap * 10, "J"),
                    new Beat(starTime + gap * 12, "Space"),
            };
        }
        else if (titleName.equals("Forever") && difficulty.equals("Hard")) {
            int starTime = 2000 - Main.REACH_TIME * 1000;
            int gap = 105;
            beats = new Beat[] {
                    new Beat(starTime, "S"),
                    new Beat(starTime + gap * 2, "K"),
                    new Beat(starTime + gap * 4, "D"),
                    new Beat(starTime + gap * 6, "L"),
                    new Beat(starTime + gap * 8, "F"),
                    new Beat(starTime + gap * 10, "J"),
                    new Beat(starTime + gap * 12, "Space"),
            };
        }
        int i=0;
        gameMusic.start();
        while (i< beats.length && !isInterrupted()) {
            boolean dropped =false;
            if (beats[i].getTime() <= gameMusic.getTime()) {
                Note note = new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped=true;
            }
            if (!dropped) {
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void judge(String input) {
        for (int i=0; i< noteList.size(); i++) {
            Note note = noteList.get(i);
            if (input.equals(note.getNoteType())) {
                judgeEvent(note.judge());
                break;
            }
        }
    }

    public void judgeEvent(String judge) {
        if (!judge.equals("None")) {
            flareImage = new ImageIcon(getClass().getClassLoader().getResource("images/flare.png")).getImage();
        }
        if (judge.equals("Late")) {
            judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/late.png")).getImage();
            combo++;
        }
        else if (judge.equals("Good")) {
            judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/good.png")).getImage();
            combo++;
        }
        else if (judge.equals("Great")) {
            judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/great.png")).getImage();
            combo++;
        }
        else if (judge.equals("Perfect")) {
            judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/perfect.png")).getImage();
            combo++;
        }
        else if (judge.equals("Early")) {
            judgeImage = new ImageIcon(getClass().getClassLoader().getResource("images/early.png")).getImage();
            combo++;
        }
    }
}
