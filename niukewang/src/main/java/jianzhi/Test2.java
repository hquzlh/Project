package jianzhi;

/**
 * @program: niukewang
 * @description:两个栈模拟队列
 * @author: Mr.Zhu
 * @create: 2019-10-14 09:03
 **/

import java.util.Stack;

public class Test2 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack2.empty()){
            stack2.push(node);
        }else{
            while(!stack2.empty()){
                stack1.push(stack2.pop());
            }
            stack1.push(node);
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() {
        if(stack2.empty()){
            throw new RuntimeException("queue is empty");
        }
        return stack2.pop();
    }
}