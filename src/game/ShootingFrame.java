package game;

import javax.swing.*;
import java.awt.*;

public class ShootingFrame extends JFrame { //swingを継承
    public panel panel;
    public ShootingFrame(){
        panel = new panel();
        this.add(panel);
        this.addKeyListener(new keyboard());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("シューティングゲーム");
        this.setSize(1000,1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

}
