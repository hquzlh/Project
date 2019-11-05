package queue;

/**
 * @program: structure
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-29 09:47
 **/

public class Queue {
    private int[] que;
    private int size;//队列大小
    private int front;//头
    private int rear;//尾
    private int item;//队列中元素个数

    public Queue(int size) {
        this.que = new int[size];
        this.size = size;
        this.front = 0;
        this.rear = -1;
    }
    //添加元素
    public void insert(int a){
       if(isFull()){
           System.out.println("队列满");
           return;
       }
       rear=++rear%size;
       que[rear]=a;
       item++;
    }
    //弹出队列元素
    public int remove(){
        if(isEmpty()){
            System.out.println("队列空");
            return 0;
        }
        item--;
        front=front%size;
        return que[front++];
    }
    //返回首元素
    public int peek(){
        if(isEmpty()){
            System.out.println("队列空");
            return 0;
        }
        return que[front];
    }
    public Boolean isFull(){
        return item==size;
    }
    public Boolean isEmpty(){
        return item==0;
    }
}

