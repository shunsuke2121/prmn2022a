package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
    static public void image(Graphics g){
        try{String imageFilename ="src/game/img/インベーダー.png";
        BufferedImage bufferedImage = ImageIO.read(new File(imageFilename));
        g.drawImage(bufferedImage, 0, 0, null);
    }catch (IOException e){

        }
    }
}
