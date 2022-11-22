package ex4;

public class Exercise4_2 {
    public static void main(String[] args) {
    ATM atm = new ATM();
        atm.existAccount("大友一樹", "12345");
        atm.resisterAccount("大友一樹", "12345");
        if(atm.existAccount("大友一樹", "12345")) {
            atm.deposit("12345", 1000);
            atm.withdraw("12345", 2000);
            atm.withdraw("12345", 500);
        }
    }
}
