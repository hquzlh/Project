/**
 * @program: allTest
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-10 11:01
 **/

 enum WeekDayEnum {
    Monday(1,"星期一"),
    Tuesday(2,"星期二"),
    Wednesday(3,"星期三"),
    Thursday(4,"星期四"),
    Friday(5,"星期五"),
    Saturday(6,"星期六"),
    Sunday(7,"星期天");

    private int i;
    private String description;
    //定义WeekDayEnum构造方法
    private WeekDayEnum(int i, String description){
        this.i = i;
        this.description =description;
    }
    //定义外部访问方法
    public int Getnum(){
        return i;
    }
    public String getDescroption(){
        return description;
    }
}

public class Main {
    public static void main(String[] args) {
        //静态方法需要用 类名.方法 调用，静态方法属于类
        //循环输出星期枚举描述
        for(int i = 0; i < WeekDayEnum.values().length; i++){
            System.out.println(WeekDayEnum.values()[i]+" 代表"+WeekDayEnum.values()[i].getDescroption());
        }
    }

}