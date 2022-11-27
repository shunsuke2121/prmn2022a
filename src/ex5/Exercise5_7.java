package ex5;

import java.util.ArrayList;
import java.util.List;

public class Exercise5_7 {
    public static void main(String[] args) {
        var insect = new Insect();
        var locust = new Locust();
        Butterfly butterfly = new Butterfly();
        var sbut = new SwallowtailButterfly();
        List<Insect> insects = new ArrayList<>();
        insects.add(insect);
        insects.add(butterfly);
        insects.add(locust);
        insects.add(sbut);
        for(Insect insect1 :insects){
            insect1.move();
        }
    }
}
