package responsibility;

/**
 * @program: design-patterns
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-12 09:47
 **/
class ConcreteHandlerC extends Handler {
@Override
 public void handleRequest(int request) {
if (request > 20 && request <= 30) {
System.out.println(this.getClass().getName() + "处理了请求" + request);
 } else if (successor != null) {
successor.handleRequest(request);
 }
 }
}
