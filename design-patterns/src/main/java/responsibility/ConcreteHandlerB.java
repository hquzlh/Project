package responsibility;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 09:47
 **/
class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(int request) {
       if (request > 10 && request <= 20) {
       System.out.println(this.getClass().getName() + "处理了请求" + request);
       } else if (successor != null) {
       successor.handleRequest(request);
       }
    }
}
