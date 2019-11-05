package test1;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-27 14:20
 **/

public class Sort {
    public static void main(String[] args) {
        String[] str={"3-5","2-1","1-6","3-4","2-3","4-6","3-1","9-2"};

        str="1-10 5-37 1-25 1-26 2-37 3-17 5-20 5-45 1-37 1-34 4-29 3-28 3-19 1-44 2-38 1-31 5-35 4-27 5-36 1-19 1-45 1-13 5-30 2-9 2-10 3-26 2-13".split(" ");
        String[] str1=sort(str);
        for (int i = 0; i <str.length ; i++) {
            if(i!=str.length-1){
                System.out.print(str[i]+" ,");
            }else {
                System.out.print(str[i]);
            }

        }
    }

    public static String[] sort(String datas[]){

        for (int i = 0; i <datas.length ; i++) {
            boolean tag=true;

            for (int j = 0; j <datas.length-i-1 ; j++) {

                String temp=datas[j];
                int left=Integer.parseInt(datas[j].split("-")[0]);
                int right=Integer.parseInt(datas[j].split("-")[1]);
                int left1=Integer.parseInt(datas[j+1].split("-")[0]);
                int right1=Integer.parseInt(datas[j+1].split("-")[1]);
                if(left>left1){
                    datas[j]=datas[j+1];
                    datas[j+1]=temp;
                    tag=false;
                }else {
                    if(left==left1&&right>right1){

                        datas[j]=datas[j+1];
                        datas[j+1]=temp;
                        tag=false;
                    }
                }
            }
            if(tag=true){
                //return datas;
            }
        }
        return datas;
    }
}
