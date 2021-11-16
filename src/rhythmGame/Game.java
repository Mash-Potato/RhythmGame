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

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

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
            note.screenDraw(g);
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
        g.setColor(Color.WHITE);
        g.setFont(new Font("Elephant",Font.BOLD, 30));
        g.drawString("000000",565,702);
    }

    public void pressS() {
        noteRouteSImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }

    public void releaseS() {
        noteRouteSImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressD() {
        noteRouteDImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumSmall3.mp3", false).start();
    }

    public void releaseD() {
        noteRouteDImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressF() {
        noteRouteFImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumBig1.mp3", false).start();
    }

    public void releaseF() {
        noteRouteFImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressSpace() {
        noteRouteSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        noteRouteSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumBig2.mp3", false).start();
    }

    public void releaseSpace() {
        noteRouteSpace1Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
        noteRouteSpace2Image=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressJ() {
        noteRouteJImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumBig3.mp3", false).start();
    }

    public void releaseJ() {
        noteRouteJImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressK() {
        noteRouteKImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();
    }

    public void releaseK() {
        noteRouteKImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
    }

    public void pressL() {
        noteRouteLImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteRoutePressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }

    public void releaseL() {
        noteRouteLImage=new ImageIcon(getClass().getClassLoader().getResource("images/noteroute.png")).getImage();
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
        if (titleName.equals("Tropic Love")) {
            int starTime = 4460 - Main.REACH_TIME * 1000;
            int gap = 125;
            beats = new Beat[] {
                    new Beat(starTime, "Space"),
                    new Beat(starTime + gap * 2, "D"),
                    new Beat(starTime + gap * 4, "S"),
                    new Beat(starTime + gap * 6, "D"),
                    new Beat(starTime + gap * 8, "S"),
                    new Beat(starTime + gap * 10, "D"),
                    new Beat(starTime + gap * 12, "S"),
                    new Beat(starTime + gap * 14, "D"),
            };
        }
        else if (titleName.equals("Summer Song")) {
            int starTime = 1000;
            beats = new Beat[] {
                    new Beat(starTime, "Space"),
            };
        }
        else if (titleName.equals("Forever")) {
            int starTime = 1000;
            beats = new Beat[] {
                    new Beat(starTime, "Space"),
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
}
