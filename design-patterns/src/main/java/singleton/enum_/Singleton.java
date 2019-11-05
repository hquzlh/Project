package singleton.enum_;

/**
 * @program: design-patterns
 * @description:枚举类
 * @author: Mr.Zhu
 * @create: 2019-09-11 16:19
 **/

enum Singleton {
    instance;
    private String attribute;
    void setAttribute(String attribute){
        this.attribute=attribute;
    }
    String getAttribute(){
        return this.attribute;
    }
}
