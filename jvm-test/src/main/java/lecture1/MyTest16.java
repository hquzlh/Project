package lecture1;

import java.io.*;
import java.security.PublicKey;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-25 09:13
 **/

public class MyTest16 extends ClassLoader {
    private String classLoaderName;
    private final String fileExtension=".class";
    private String path;
    public MyTest16(String classLoaderName){
        //将系统类加载器当作该类的父类加载器systemClassLoader
        super();
        this.classLoaderName=classLoaderName;
    }
    public MyTest16(ClassLoader parent,String classLoaderName){
        //显示指定父类加载器
        super(parent);
        this.classLoaderName=classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyTest16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }
    @Override
    protected Class<?> findClass(String className){
        System.out.println("findClass运作"+className);
        System.out.println("classLoad "+this.classLoaderName);
        byte[] data=this.loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        InputStream is=null;
        byte[] data=null;
        ByteArrayOutputStream bos=null;
        className=className.replace(".","\\");
        try {

            is=new FileInputStream(new File(this.path+className+this.fileExtension));
            bos=new ByteArrayOutputStream();
            int ch=0 ;
            while (-1!=(ch=is.read())){
                bos.write(ch);
            }
            data=bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                bos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return data;
    }



    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        MyTest16 loader1=new MyTest16("loader1");
        //loader1.setPath("D:\\IdeaWorkSpace\\jvm-test\\target\\classes\\lecture1");
        loader1.setPath("D:\\te\\");
        Class<?> clazz=loader1.loadClass("lecture1.MyTest1");
        System.out.println(clazz.hashCode());
        Object object=clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

        System.out.println();
        loader1=null;
        clazz=null;
        object=null;
        System.gc();
        Thread.sleep(200000);
        loader1=new MyTest16("loader1");
        loader1.setPath("D:\\te\\");
        clazz=loader1.loadClass("lecture1.MyTest1");
        System.out.println(clazz.hashCode());
        object=clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

       /* MyTest16 loader2=new MyTest16(loader1,"loader2");
        loader2.setPath("D:\\te\\");
        Class<?> clazz2=loader2.loadClass("lecture1.MyTest1");
        System.out.println(clazz2.hashCode());
        Object object2=clazz2.newInstance();
        System.out.println(object2);
        System.out.println(object2.getClass().getClassLoader());*/

    }
}
