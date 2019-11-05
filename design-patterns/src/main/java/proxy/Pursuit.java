package proxy;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 10:02
 **/

public class Pursuit implements GiveGift {
    private  String name;
    private SchoolGirl schoolGirl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolGirl getSchoolGirl() {
        return schoolGirl;
    }

    public void setSchoolGirl(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }

    public Pursuit(SchoolGirl schoolGirl) {
        this.schoolGirl = schoolGirl;
    }
    public void giveDolls() {
        System.out.println(name+"---"+schoolGirl.getName()+"收到doll");
    }

    public void giveFlowers() {
        System.out.println(name+"---"+schoolGirl.getName()+"收到flower");
    }

    public void giveChocolate() {
        System.out.println(name+"---"+schoolGirl.getName()+"收到chocolate");
    }
}
