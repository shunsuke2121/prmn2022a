package RR;

public class gakusei {
    private number number;
    private String name;
    private age age;

    public gakusei(number number, String name,age age) {
        this.number = number;
        this.name = name;
        this.age = age;
    }
    public number getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setNumber(number number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(age age) {
        this.age = age;
    }

    public RR.age getAge() {
        return age;
    }
    public void osake(){
        if (age.isOber20()){
            System.out.println("お酒ok yade");
        }
    }
}
