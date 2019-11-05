package prototype;

import java.io.*;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-10 11:06
 **/

public class Resume1 implements Cloneable, Serializable {
    public static final long serialVersionUID=-4410449301166191440L;
    private String name;
    private String gender;
    private int age;
    private WorkExperience workExperience;

    public Resume1() {

    }
    public void display(){
        System.out.println(this.name+"  "+this.gender+" "+this.age+" "
                +this.workExperience.getWorkCompany()+"  "+this.workExperience.getWorkDate());
    }
    //深度拷贝
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return ois.readObject();
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Resume1 resume= (Resume1) super.clone();

        resume.setWorkExperience((WorkExperience) this.workExperience.clone());
        return resume;
    }

    public Resume1 setName(String name) {
        this.name = name;
        return this;
    }

    public void setWorkExperience(WorkExperience workExperience) {
        this.workExperience=workExperience;
    }

    public Resume1 setAge(int age) {
        this.age = age;
        return this;
    }

    public Resume1 setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }
}
