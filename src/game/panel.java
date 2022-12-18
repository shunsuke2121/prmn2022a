package game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class panel extends JPanel {
    public BufferedImage graphics;

    public panel(){
        super();
        this.graphics = new BufferedImage(1000,1000,BufferedImage.TYPE_INT_ARGB);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(graphics,0,0,this);
    }

    public void draw(){
        repaint();
    }
}
