public class Execise2_2 {
    public static void main(String[] args) {

        var car = new Car();
        car.run();
        GasStation.refuel(car);
        car.run();
    }
}
