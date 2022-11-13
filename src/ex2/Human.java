package ex2;

public class Human {
    String name ;
    int age;
    void Human(String name,int age){
        this.name=name;
        this.age = age;
    }
    void print(){
        if(22<age){
            System.out.println("学生:"+name+age+"歳です");
        }
        else {
            System.out.println("生徒:"+name+age+"歳です");
        }
    }
}
