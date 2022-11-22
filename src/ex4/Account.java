package ex4;

public class Account {
    private String number;
    private  String name;
    private  long balance;
    public Account(String name,String number){
        this.name = name;
        this.number = number;
        this.balance = 0;
    }

    public String getNumber() {
        return number;
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}
