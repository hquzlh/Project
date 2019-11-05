package stack;

/**
 * @program: structure
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-29 10:27
 **/

public class Test {
    public static void main(String[] args) {
        MinStack stack1 = new MinStack();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        stack1.push(6);
        stack1.push(2);
        stack1.push(8);
        int stack = stack1.pop();
        int min = stack1.getMin();
        System.out.println(stack + "  " + min + "  ");

    }

}
