package decorator;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 09:29
 **/

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
    public void show(){
        System.out.println("人:"+name);
    }
}
