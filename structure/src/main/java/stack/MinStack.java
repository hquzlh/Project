package stack;

import java.util.Stack;

/**
 * @program: structure
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-29 10:19
 **/

public class MinStack {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.dataStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    public void push(int a){
        if(minStack.empty()){
            minStack.push(a);
        }else if(a<minStack.peek()){
            minStack.push(a);
        }
        dataStack.push(a);
    }
    public int pop(){
        if(minStack.empty()){
            throw new RuntimeException("当前栈为空");
        }
        int value=dataStack.pop();
        if(minStack.peek().equals(value)){
            minStack.pop();
        }
        return value;
    }
    public int getMin(){
        if(minStack.empty()){
            throw new RuntimeException("当前栈为空");
        }
        return minStack.peek();

    }
}
