package prototype;

import java.io.IOException;

/**
 * @program: design-patterns
 * @description: 客户测试端
 * @author: Mr.Zhu
 * @create: 2019-09-10 11:17
 **/

public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        shallowCopy();
        System.out.println("----------------------");
        deepCopy();
    }
    public static void shallowCopy() throws CloneNotSupportedException {
        Resume1 aresume=new Resume1();
        aresume.setName("大鸟").setAge(25).setGender("男");
        aresume.setWorkExperience(new WorkExperience("1999-2000","aaaaa"));
        Resume1 bresume= (Resume1) aresume.clone();

        bresume.setWorkExperience(new WorkExperience("1999-2000","bbbbb"));
        Resume1 cresume=(Resume1) aresume.clone();

        cresume.setWorkExperience(new WorkExperience("1999-2000","ccccc"));
        System.out.println("浅度拷贝----------");
        aresume.display();
        bresume.display();
        cresume.display();
    }
    public static void shallowCopy1() throws CloneNotSupportedException {
        Resume1 aresume=new Resume1();
        aresume.setName("大鸟").setAge(25).setGender("男");
        aresume.setWorkExperience(new WorkExperience("1999-2000","aaaaa"));
        Resume1 bresume= (Resume1) aresume.clone();

        bresume.setWorkExperience(new WorkExperience("1999-2000","bbbbb"));
        Resume1 cresume=(Resume1) aresume.clone();

        cresume.setWorkExperience(new WorkExperience("1999-2000","ccccc"));
        System.out.println("浅度拷贝----------");
        aresume.display();
        bresume.display();
        cresume.display();
    }

    public static void deepCopy() throws IOException, ClassNotFoundException {
        Resume aresume=new Resume();
        aresume.setName("大鸟").setAge(25).setGender("男");
        aresume.setWorkExperience("1999-2000","aaaaa");
        Resume bresume= (Resume) aresume.deepClone();

        bresume.setWorkExperience("1999-2000","bbbbbb");
        Resume cresume=(Resume) aresume.deepClone();

        cresume.setWorkExperience("1999-2000","cccccc");
        System.out.println("深度拷贝----------");
        aresume.display();
        bresume.display();
        cresume.display();
    }
}
