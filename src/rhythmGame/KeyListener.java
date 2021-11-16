package rhythmGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (Gui.game == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            Gui.game.pressS();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            Gui.game.pressD();
        }
        else if (e.getKeyCode() == KeyEvent.VK_F) {
            Gui.game.pressF();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Gui.game.pressSpace();
        }
        else if (e.getKeyCode() == KeyEvent.VK_J) {
            Gui.game.pressJ();
        }
        else if (e.getKeyCode() == KeyEvent.VK_K) {
            Gui.game.pressK();
        }
        else if (e.getKeyCode() == KeyEvent.VK_L) {
            Gui.game.pressL();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (Gui.game == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            Gui.game.releaseS();
        }
        else if (e.getKeyCode() == KeyEvent.VK_D) {
            Gui.game.releaseD();
        }
        else if (e.getKeyCode() == KeyEvent.VK_F) {
            Gui.game.releaseF();
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Gui.game.releaseSpace();
        }
        else if (e.getKeyCode() == KeyEvent.VK_J) {
            Gui.game.releaseJ();
        }
        else if (e.getKeyCode() == KeyEvent.VK_K) {
            Gui.game.releaseK();
        }
        else if (e.getKeyCode() == KeyEvent.VK_L) {
            Gui.game.releaseL();
        }
    }
}
