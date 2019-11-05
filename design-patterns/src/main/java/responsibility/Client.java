package responsibility;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 09:47
 **/ //链上的具体处理者对象提交请求
class Client {
     public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        Handler handlerC = new ConcreteHandlerC();
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);
        int[] requests = { 2, 14, 5, 6, 8, 23, 12, 21 };
        for (int i : requests) {
         handlerA.handleRequest(i);
        }
}
}
