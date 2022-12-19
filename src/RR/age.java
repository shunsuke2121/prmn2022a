package RR;

public class age {
    private int value;

    public age(int value) {
        if (value >= 0 && value <= 120) {
            this.value = value;
            return;
        }
        throw new RuntimeException(value + "は不正な年齢");
    }

    public boolean isOber20() {
        return value >=20;
    }

}
