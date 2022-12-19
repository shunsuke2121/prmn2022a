package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class keyboard extends KeyAdapter {

    private static ArrayList<Integer> pressedButtons = new ArrayList<>();

    public static boolean isKeypressed(int keyCode) { //多く処理を行うためstaticメソッドにしている
        return pressedButtons.contains(keyCode);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if(!pressedButtons.contains(e.getKeyCode())) pressedButtons.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        pressedButtons.remove((Integer) e.getKeyCode());
    }
}
