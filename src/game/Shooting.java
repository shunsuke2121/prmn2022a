package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class Shooting {
    public static void main(String[] args) {
        ShootingFrame shootingFrame = new ShootingFrame();
        Boolean loop = true;
            Graphics graphics = shootingFrame.panel.graphics.getGraphics();
            //FPS
            long starttime;
            long fpstime=0;
            int fps =60;
            int FPS = 0;
            int fpsCount =0;
            int score=0;
            int HP=1000;
            int level=0;
            int fontInterval=100;
            long level_timer = 0;
            long Arufa=0;
            int Arufa_number = 0;
            ArrayList<Integer>Bariax = new ArrayList<>();
            ArrayList<Integer>Bariay = new ArrayList<>();
            ShootingScreenEnum screen = ShootingScreenEnum.START;

            //GAME
            int playerX=0,playerY=0;
            int bulletInterval = 0;
            int bulletInterval_bomm = 0;
            int bulletInterval_baria = 0;
        ArrayList<Bullet> bullets_player= new ArrayList<>();
        ArrayList<Bullet> bullets_players_Bomm= new ArrayList<>();
        ArrayList<Bullet> bullets_players_Barria= new ArrayList<>();
        ArrayList<Bullet> bullets_players_Repair= new ArrayList<>();
        ArrayList<Bullet> bullets_enemy= new ArrayList<>();
        ArrayList<Enemy1> enemies= new ArrayList<>();
        Random random = new Random();
        panel.readImage();
        while (loop) {
                if ((System.currentTimeMillis()-fpstime)>=1000){
                        fpstime = System.currentTimeMillis();
                        FPS = fpsCount;
                        fpsCount =0;
                }
                fpsCount++;
                starttime= System.currentTimeMillis();

                graphics.setColor(Color.black);
                graphics.fillRect(0,0,1000,1000);

                switch (screen){
                        case START:

                                graphics.setColor(Color.green);
                                Font font = new Font("SansSerif",Font.PLAIN,60);
                                graphics.setFont(font);
                                FontMetrics metrics = graphics.getFontMetrics(font);
//                                graphics.drawString("shooting",(1000-metrics.stringWidth("shooting"))/2,250);
//                                font = new Font("BIZ UDP明朝 Medium",Font.PLAIN,60);
//                                graphics.setFont(font);
//                                metrics = graphics.getFontMetrics(font);
//                                graphics.drawString("SPASEを押してスタート",(1000-metrics.stringWidth("SPASEを押してスタート"))/2,500);
                            panel.image(graphics);
                            if(keyboard.isKeypressed(KeyEvent.VK_SPACE)){
                                    screen = ShootingScreenEnum.GAME;
                                bullets_player= new ArrayList<>();
                                enemies= new ArrayList<>();//一応ゲーム開始時に初期化
                                bullets_enemy = new ArrayList<>();//一応ゲーム開始時に初期化
                                bullets_player= new ArrayList<>();
                                bullets_players_Bomm= new ArrayList<>();
                                bullets_players_Barria= new ArrayList<>();
                                playerX = 480;
                                playerY = 500;
                                HP = 1000;
                                score = 000;
                                level = 1;
                                Arufa_number=0;
                                Arufa=0;
                                }
                                break;
                        case GAME:
                            if (System.currentTimeMillis() - level_timer > 10*1000){//x秒でレベルが１上がる
                                level_timer = System.currentTimeMillis();
                                level++;
                            }
                            //System.out.println("start"+starttime);
                            graphics.setColor(Color.blue);
                            graphics.fillRect(playerX+10,playerY,10,10);
                            graphics.fillRect(playerX,playerY+10,30,10);


                            graphics.setColor(Color.blue);
                            for (int i = 0; i < bullets_player.size(); i++) {//弾がなくなった際にリストの中身を消すため拡張for文を使えない
                                Bullet bullet = bullets_player.get(i);
                                graphics.fillRect(bullet.x, bullet.y, 5, 5);
                                bullet.y -= 10;
                                if (bullet.y < 0) {//画面外に言ったら弾をリストから消去する。
                                    bullets_player.remove(i);
                                    i--;
                                }
                                for (int l = 0; l < enemies.size(); l++) {
                                    Enemy1 enemy = enemies.get(l);
                                    if(bullet.x>=enemy.x && bullet.x<=enemy.x+30 &&
                                            bullet.y>=enemy.y&&bullet.y<=enemy.y+20){
                                            enemies.remove(l);
                                            score +=10;
                                        bullets_player.remove(i);
                                    }
                            }
                            }


                            for (int i = 0; i < bullets_players_Bomm.size(); i++) {//弾がなくなった際にリストの中身を消すため拡張for文を使えない
                                Bullet bullet = bullets_players_Bomm.get(i);
                                graphics.setColor(Color.yellow);
                                graphics.fillRect(bullet.x, bullet.y, 50, 50);
                                bullet.y -= 10;
                                if (bullet.y < 0) {//画面外に言ったら弾をリストから消去する。
                                    bullets_players_Bomm.remove(i);
                                    i--;
                                }
                                for (int l = 0; l < enemies.size(); l++) {
                                    Enemy1 enemy = enemies.get(l);
                                    if((bullet.x>=enemy.x-40 && bullet.x<=enemy.x+70 &&
                                            bullet.y>=enemy.y&&bullet.y<=enemy.y+30) ||
                                            (bullet.x+30>=enemy.x && bullet.x+30<=enemy.x+30 &&
                                                    bullet.y+20>=enemy.y&&bullet.y+20<=enemy.y+20)){
                                        enemies.remove(l);
                                        score +=10;
                                    }
                                }
                            }
                            for (int i = 0; i < bullets_players_Barria.size(); i++) {//弾がなくなった際にリストの中身を消すため拡張for文を使えない
                                Bullet bullets = bullets_players_Barria.get(i);
                                graphics.setColor(Color.yellow);
                                graphics.fillRect(bullets.x, bullets.y, 200, 20);
                                if (System.currentTimeMillis() - level_timer > 8*1000){//x秒でバリアが消える
                                    //画面外に言ったら弾をリストから消去する。
                                        bullets_players_Barria.remove(i);
                                        i--;

                                }
                                for (int l = 0; l < enemies.size(); l++) {
                                    Enemy1 enemy = enemies.get(l);
                                    if((bullets.x>=enemy.x && bullets.x<=enemy.x+200 &&
                                            bullets.y>=enemy.y&&bullets.y<=enemy.y+20) ||
                                            (bullets.x+200>=enemy.x && bullets.x+200<=enemy.x+200 &&
                                                    bullets.y+20>=enemy.y&&bullets.y+20<=enemy.y+20)){
                                        enemies.remove(l);
                                        score +=10;
                                        //bullets_players_Barria.remove(i);
                                    }
                                }
                            }
                            graphics.setColor(Color.red);

                            for (int i = 0; i < enemies.size(); i++) {
                                Enemy1 enemy = enemies.get(i);
                                graphics.fillRect(enemy.x+10, enemy.y,10,10);
                                graphics.fillRect(enemy.x, enemy.y-10,30,10);
                                enemy.y+=3;
                                if(enemy.y>1000){
                                    enemies.remove(i);
                                    i--;
                                }
                                if (random.nextInt(level<1?1000 - level:100)==1){
                                    bullets_enemy.add(new Bullet(enemy.x,enemy.y));
                                }

                                if (random.nextInt(level<1?1000 - level:100)==1){
                                    bullets_enemy.add(new Bullet(enemy.x,enemy.y));
                                }
                                if(enemy.x>=playerX && enemy.x<=playerX+30 &&
                                        enemy.y>=playerY&&enemy.y<=playerY+20){
                                    score-=10;
                                    HP -= 100;
                                    enemies.remove(i);
                                }
                            }
                            for (int i = 0; i < enemies.size(); i++) {
                                Enemy1 enemy = enemies.get(i);
                                graphics.fillRect(enemy.x+10, enemy.y,10,10);
                                graphics.fillRect(enemy.x, enemy.y-10,30,10);
                                enemy.y+=3;
                                if(random.nextInt(11)>4){
                                    enemy.x+=2;
                                }else {
                                    enemy.x-=2;
                                }
                                if(enemy.y>1000){
                                    enemies.remove(i);
                                    i--;
                                }
                                if (random.nextInt(level<1?1000 - level:100)==1){
                                    bullets_enemy.add(new Bullet(enemy.x,enemy.y));
                                }

                                if (random.nextInt(level<1?1000 - level:100)==1){
                                    bullets_enemy.add(new Bullet(enemy.x,enemy.y));
                                }
                                if(enemy.x>=playerX && enemy.x<=playerX+30 &&
                                        enemy.y>=playerY&&enemy.y<=playerY+20){
                                    score-=10;
                                    HP -= 100;
                                }
                            }
                            if (random.nextInt(level<1?15 - level:15)==1){//三項演算子を用いたif文
                                    enemies.add(new Enemy1(random.nextInt(970), 0));
                                }


                            for (int i = 0; i < bullets_enemy.size(); i++) {//弾がなくなった際にリストの中身を消すため拡張for文を使えない
                                Bullet bullet = bullets_enemy.get(i);
                                graphics.fillRect(bullet.x, bullet.y, 5, 5);
                                bullet.y += 8;
                                if (bullet.y > 1000) {//画面外に言ったら弾をリストから消去する。
                                    bullets_enemy.remove(i);
                                    i--;}
                                    if((bullet.x>=playerX && bullet.x<=playerX+30 &&
                                            bullet.y>=playerY&&bullet.y<=playerY+20) ||
                                            (bullet.x+30>=playerX && bullet.x+30<=playerX+30 &&
                                            bullet.y+20>=playerY&&bullet.y+20<=playerY+20)){
                                        score-=10;
                                        HP -= 100;
                                        bullets_enemy.remove(i);

                                    }
                                    for (int j = 0; j < bullets_players_Barria.size();j++){
                                        //System.out.println(Bariax.get(j));
                                        Bullet bullets = bullets_players_Barria.get(j); //playerx-90、playery-30が格納されている
                                        if((bullets.x+200>=bullet.x && bullets.x+200<=bullet.x+200 &&
                                                        bullets.y+20>=bullet.y&&bullets.y+20<=bullet.y+20)){
                                            bullets_enemy.remove(i);
                                        }
                                    }
                            }
                            for (int i = 0; i < bullets_players_Repair.size(); i++) {//弾がなくなった際にリストの中身を消すため拡張for文を使えない
                                Bullet bullet = bullets_players_Repair.get(i);
                                graphics.setColor(Color.cyan);
                                graphics.fillRect(bullet.x, bullet.y, 15, 20);
                                graphics.fillRect(bullet.x+5, bullet.y-5,5,5);
                                bullet.y += 4;
                                if (bullet.y > 1000) {//画面外に言ったら弾をリストから消去する。
                                    bullets_enemy.remove(i);
                                    i--;}
                                    if((bullet.x>=playerX && bullet.x<=playerX+30 &&
                                            bullet.y>=playerY&&bullet.y<=playerY+20) ||
                                            (bullet.x+30>=playerX && bullet.x+30<=playerX+30 &&
                                            bullet.y+20>=playerY&&bullet.y+20<=playerY+20)){
                                        score+=10;
                                        HP += 100;
                                        bullets_enemy.remove(i);

                                    }
                                    for (int j = 0; j < bullets_players_Barria.size();j++){
                                        //System.out.println(Bariax.get(j));
                                        Bullet bullets = bullets_players_Barria.get(j); //playerx-90、playery-30が格納されている
                                        if((bullets.x+200>=bullet.x && bullets.x+200<=bullet.x+200 &&
                                                        bullets.y+20>=bullet.y&&bullets.y+20<=bullet.y+20)){
                                            bullets_enemy.remove(i);
                                        }
                                    }
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_A) && playerX>0){
                                playerX-=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_D) && playerX<942){
                                playerX+=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_W) && playerY >0){
                                playerY-=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_S) && playerY <940){
                                playerY+=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_LEFT) && playerX>0){
                                playerX-=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_RIGHT) && playerX<942){
                                playerX+=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_UP) && playerY >0){
                                playerY-=10;
                            }
                            if (keyboard.isKeypressed(KeyEvent.VK_DOWN) && playerY <940){
                                playerY+=10;
                            }
                            if(keyboard.isKeypressed(KeyEvent.VK_SPACE)&&bulletInterval ==0){
                                bullets_player.add(new Bullet(playerX+12,playerY));
                                bulletInterval = 10;
                            }
                            if(keyboard.isKeypressed(KeyEvent.VK_CONTROL)&&bulletInterval_bomm ==0){
                                bullets_players_Bomm.add(new Bullet(playerX-10,playerY));
                                bulletInterval_bomm = 100;
                            }
                            if(keyboard.isKeypressed(KeyEvent.VK_C)&&bulletInterval_baria ==0){
                                bullets_players_Barria.add(new Bullet(playerX-90,playerY-30));
                                Bariax.add(playerX+12);//バリアの位置格納
                                Bariay.add(playerY);
                                bulletInterval_baria = 1000;
                            }
                            System.out.println(bulletInterval_baria);
                            if (bulletInterval > 0)bulletInterval--;
                            if (bulletInterval_bomm > 0)bulletInterval_bomm--;
                            if (bulletInterval_baria > 0)bulletInterval_baria--;
                            graphics.setColor(Color.green);
                            font = new Font("SansSerif",Font.PLAIN,10);
                            graphics.setFont(font);
                            metrics = graphics.getFontMetrics(font);
                            graphics.drawString("SCORE"+score,980-metrics.stringWidth("SCORE"+score),950);
                            graphics.drawString("LEVEL"+level,980-metrics.stringWidth("LEVEL"+level),920);
                            graphics.setColor(Color.yellow);
                            graphics.fillRect(910,890,1000,10);
                            graphics.setColor(Color.black);
                            graphics.fillRect(1010-(bulletInterval_baria/10),890,1000,10);
                            graphics.setColor(Color.green);
                            graphics.fillRect(910,860,1000,10);
                            graphics.setColor(Color.black);
                            graphics.fillRect(1000-bulletInterval_bomm*5,860,1000,10);
                            graphics.setColor(Color.blue);
                            graphics.fillRect(0,0,HP,10);
                            if (HP<=0){
                                screen = ShootingScreenEnum.GAME_OVER;
                                score += (level-1) * 100;
                            }
                            break;

                        case GAME_OVER:
                            if (System.currentTimeMillis() - Arufa > 8 && Arufa_number<255){//0.01秒でアルファが1上がる
                                Arufa = System.currentTimeMillis();
                                Arufa_number+=1;
                                System.out.println(Arufa_number);
                            }
                            graphics.setColor(Color.white);
                            graphics.fillRect(0,0,1000,1000);

                            if(score>=1000) {
                                graphics.setColor(Color.black);
                                if (fontInterval%51<25){
                                    graphics.setColor(Color.yellow);
                                    font = new Font("BIZ UDP明朝 Medium", Font.PLAIN, 175);
                                    graphics.setFont(font);
                                    metrics = graphics.getFontMetrics(font);
                                    graphics.drawString("よくぞ見事!!", (1000 - metrics.stringWidth("よくぞ見事!!")) / 2, 500);

                                }
                                else {
                                    graphics.setColor(Color.red);
                                    font = new Font("BIZ UDP明朝 Medium", Font.PLAIN, 175);
                                    graphics.setFont(font);
                                    metrics = graphics.getFontMetrics(font);
                                    graphics.drawString("よくぞ見事!!", (1000 - metrics.stringWidth("よくぞ見事!!")) / 2, 500);
                                }
                                font = new Font("SansSerif", Font.PLAIN, 50);
                                graphics.setFont(font);
                                metrics = graphics.getFontMetrics(font);
                                graphics.drawString("SCORE" + score, (1000 - metrics.stringWidth("SCORE" + score)) / 2, 700);
                                font = new Font("BIZ UDP明朝 Medium", Font.PLAIN, 50);
                                graphics.setFont(font);
                                metrics = graphics.getFontMetrics(font);
                                graphics.drawString("ESCを押してトップ画面に戻る", (1000 - metrics.stringWidth("ESCを押してトップ画面に戻る")) / 2, 200);
                                graphics.setColor(new Color(0, 0, 0, 255 - Arufa_number));
                                graphics.fillRect(0, 0, 1000, 1000);
                                if (keyboard.isKeypressed(KeyEvent.VK_ESCAPE)) screen = ShootingScreenEnum.START;
                                fontInterval++;
                            }
                            else{
                                graphics.setColor(Color.red);
                                font = new Font("BIZ UDP明朝 Medium", Font.PLAIN, 200);
                                graphics.setFont(font);
                                metrics = graphics.getFontMetrics(font);
                                graphics.drawString("死", (1000 - metrics.stringWidth("死")) / 2, 500);
                                font = new Font("SansSerif", Font.PLAIN, 50);
                                graphics.setFont(font);
                                metrics = graphics.getFontMetrics(font);
                                graphics.drawString("SCORE" + score, (1000 - metrics.stringWidth("SCORE" + score)) / 2, 700);
                                font = new Font("BIZ UDP明朝 Medium", Font.PLAIN, 50);
                                graphics.setFont(font);
                                metrics = graphics.getFontMetrics(font);
                                graphics.drawString("ESCを押してトップ画面に戻る", (1000 - metrics.stringWidth("ESCを押してトップ画面に戻る")) / 2, 200);
                                graphics.setColor(new Color(0, 0, 0, 255 - Arufa_number));
                                graphics.fillRect(0, 0, 1000, 1000);
                                if (keyboard.isKeypressed(KeyEvent.VK_ESCAPE)) screen = ShootingScreenEnum.START;
                            }

                                break;
                }

//                graphics.setColor(Color.white);
//                graphics.fillRect(100,100,100,100);
                graphics.setColor(Color.green);
                graphics.setFont(new Font("SansSerif",Font.PLAIN,20));
                graphics.drawString("FPS"+FPS,0,30);
                shootingFrame.panel.draw();
                try {
                        long runTime = System.currentTimeMillis() - starttime;
                        if (runTime<(1000/fps)){
                                Thread.sleep((1000/fps) - (runTime)); //処理時間が(1000/fps)msより小さければ待機、出なければ次へ
                        }
                }catch (InterruptedException e){
                        e.printStackTrace();
                }

        }
    }
}
