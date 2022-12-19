package RR;

public class number {

    private String value;

    public number(String value) {
        //最初がBで始まる
        //その後7桁の数字で終わる
        this.value = value;
        System.out.println(value);
        String kasira = value.substring(0,1);
        String  sonoato = value.substring(1,8);
        System.out.println(kasira);
        System.out.println(sonoato.length());
        if (kasira.equals("b") && sonoato.length() == 7 ) {
            System.out.println(value);
            System.out.println(this.value);
            return;
        }
        throw new RuntimeException(value + "は学籍番号じゃない");
    }

    public String getValue() {
        return value;
    }
}
