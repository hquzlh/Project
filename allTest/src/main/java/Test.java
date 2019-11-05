/**
 * @program: allTest
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-10 11:08
 **/

public class Test {
    public static void main(String[] args) {
        Color[] colors=Color.values();

        for (int i = 0; i <colors.length ; i++) {
            System.out.println(colors[i].getName());
        }
    }


}
enum Color{
    Red("红色",1),Green("绿色",2),Blue("蓝色",3);
    private String name;
    private int i;

    Color(String name, int i) {
        this.name = name;
        this.i = i;
    }
    public static String getName(int index){
        for(Color c:Color.values()){
            if(c.getI()==index){
                return c.getName();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", i=" + i +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
