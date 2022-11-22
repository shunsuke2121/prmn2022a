package ex4;

public class Fighter {
    private int hitpoint;
    private int power;
    private String name;

    public Fighter(int hitpoint,int power,String name){
        this.hitpoint= hitpoint;
        this.power=power;
        this.name=name;
    }
    public void attack (Fighter enemy){
        enemy.setHitpoint(enemy.getHitpoint()-this.power);
        System.out.println(this.name+"は"+enemy.getName()+"に"+this.power+"ダメーじ");

    }
    public boolean isAlive(){
        if(this.hitpoint<=0){
            System.out.println(this.name+"死");
            return false;
        }
        return true;
    }

    public int getHitpoint() {
        return hitpoint;
    }

    public void setHitpoint(int hitpoint) {
        this.hitpoint = hitpoint;
    }

    public String getName(){
        return name;
    }
}
