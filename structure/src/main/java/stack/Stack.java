package stack;

/**
 * @program: structure
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-29 09:32
 **/
//数组实现栈，后进先出
public class Stack {
    private int[]stk; //数组
    private int size;//栈的容量
    private int top;//栈顶

    public Stack( int size) {
        this.stk = new int[size];
        this.size = size;
        this.top=-1;
    }

    //入栈
    public void push(int a){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        stk[++top]=a;
    }

    //返回栈顶，但不删除
    public int peek(){
        if(isEmpty()){
            System.out.println("栈空");
            return 0;
        }
        return stk[top];
    }
    //弹出栈顶
    public int pop(){
        if(isEmpty()){
            System.out.println("栈空");
            return 0;
        }
        return stk[top--];
    }
    //返回栈中元素个数
    public int getSize(){
        return top+1;
    }
    //输出栈中内容
    public void display(){
        for (int i = top; i >=0 ; i--) {
            System.out.println(stk[top]);
        }
    }
    //判断栈满
    public Boolean isFull(){

        return top==size-1;

    }
    //判断栈空
    public Boolean isEmpty(){
        return top==-1;

    }
}
