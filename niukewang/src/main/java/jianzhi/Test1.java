package jianzhi;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @program: niukewang
 * @description:根据前中序创建二叉树返回后序
 * @author: Mr.Zhu
 * @create: 2019-10-12 16:46
 **/

public class Test1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[]str=br.readLine().split(" ");
        String[]pre=str[0].split("");
        print(pre);
        System.out.println();
        String[]in=str[1].split("");
        print(in);

        System.out.println();
        Test1 test1=new Test1();
        TreeNode treeNode=test1.binaryTree(pre,in);
        test1.postOrder(treeNode);
    }

    public TreeNode binaryTree(String[]pre,String[]in){
        TreeNode treeNode=binaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return treeNode;
    }
    public TreeNode binaryTree(String[]pre,int startPre,int endPre,String[]in,int startIn,int endIn ){
        if(startPre>endPre||startIn>endIn){
            return null;
        }
        TreeNode treeNode=new TreeNode(pre[startPre]);
        for (int i = startIn; i <=endIn ; i++) {
            if(in[i].equals(pre[startPre])){
                treeNode.left=binaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                treeNode.right=binaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
            }
        }
        return treeNode;
    }
    public void preOrder(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value+"   ");
        preOrder(node.left);
        preOrder(node.right);
    }
    public void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+"   ");
        inOrder(node.right);
    }
    public void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"   ");
    }
    public static void print(String []strings){
        for (int i = 0; i <strings.length ; i++) {
            System.out.print(strings[i]+"  ");
        }
    }

}
class TreeNode{
    String value;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }

    public TreeNode(String value, TreeNode parent, TreeNode left, TreeNode right) {
        this.value = value;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }
}
