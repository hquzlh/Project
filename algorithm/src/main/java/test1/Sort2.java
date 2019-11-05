package test1;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-06 14:57
 **/

public class Sort2 {
    public static void main(String[] args) {
        int[]a={1,4,5,2,3,8,6,211,145};
        //chooseSort(a);
        //bubbleSort(a);
        //insertSort(a);
        //quickSort(a,0,8);
        //mergeSort(a,0,8);
        //shellSort(a);
        //heapSort(a);
        radixSort(a,10);
        print(a);
    }
    public static void radixSort(int[]a,int radix){
        int d=getMax(a);
        int []temp=new int[a.length];
        int[]bucket=new int[radix];
        for (int i = 0,rate=1; i <d ; i++,rate*=10) {
            Arrays.fill(bucket,0);
            System.arraycopy(a,0,temp,0,a.length);
            for (int j = 0; j <a.length ; j++) {
                int key=(temp[j]/rate)%radix;
                bucket[key]++;
            }
            for (int j = 1; j <radix; j++) {
                bucket[j]+=bucket[j-1];
            }
            for (int j = a.length-1; j>=0 ; j--) {
                int key=(temp[j]/rate)%radix;
                a[--bucket[key]]=temp[j];
            }


        }
    }
    public static int getMax(int[]a){
        int max=0;
        for (int i = 0; i <a.length ; i++) {
            int length=String.valueOf(a[i]).length();
            if(length>max){
                max=length;
            }
        }
        return max;
    }
    //堆排序
    public static void heapSort(int[]a){
        int length=a.length;
        for (int i =length/2-1; i >=0 ; i--) {
            sink(a,i,length);
        }
        for (int i = length-1; i >0 ; i--) {
            int temp=a[i];
            a[i]=a[0];
            a[0]=temp;
            sink(a,0,i);
        }
    }
    public static void sink(int[]a,int i,int length){
        int temp=a[i];
        for (int j = i*2+1; j <length ; j=j*2+1) {
            if(j+1<length&&a[j]<a[j+1]){
                j++;
            }
            if(a[j]>temp){
                a[i]=a[j];
                i=j;
            }else {
                break;
            }
        }
        a[i]=temp;
    }
    //归并排序
    public static void mergeSort(int []a,int left,int right){
        if(left<right){
            int mid=left+(right-left)/2;
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
    public static void merge(int []a,int low,int mid,int high){
        int length=high-low+1;
        int []data=new int[length];
        int left=low,right=mid+1,index=0;
        while(left<=mid&&right<=high){
            data[index++]=(a[left]<=a[right])?a[left++]:a[right++];
        }
        while (left<=mid){
            data[index++]=a[left++];
        }
        while (right<=high){
            data[index++]=a[right++];
        }
        for (int i = 0; i <length ; i++) {
            a[low+i]=data[i];
        }
    }
    //快速排序
    public static void quickSort(int []a,int left,int right){
        if(left<right){
            int pivot=partition(a,left,right);
            quickSort(a,left,pivot-1);
            quickSort(a,pivot+1,right);
        }
    }
    public static int partition(int []a,int left,int right){
        int temp=a[left];
        while (left<right) {


            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right]=a[left];
        }
        a[left]=temp;
        return left;
    }
    //希尔排序
    public static void shellSort(int[]a){
        int length=a.length;
        for (int gap = length/2; gap>0 ; gap=gap/2) {
            for (int i = gap; i <length ; i++) {
                if(a[i]<a[i-gap]){
                    int k=i-gap;
                    int temp=a[i];
                    while (k>=0&&a[k]>temp){
                        a[k+gap]=a[k];
                        k-=gap;
                    }
                    a[k+gap]=temp;
                }
            }
        }
    }
    //插入排序
    public static void insertSort(int[]a){
        int length=a.length;
        for (int i = 1; i <length ; i++) {
            if(a[i]<a[i-1]){
                int k=i-1;
                int temp=a[i];
                while (k>=0&&a[k]>temp){
                    a[k+1]=a[k];
                    k--;
                }
                a[k+1]=temp;
            }

        }
    }
    //选择
    public static void chooseSort(int[]a){
        int length=a.length;
        for (int i = 0; i <a.length ; i++) {
            int maxIndex=i;
            for (int j = i; j <length ; j++) {
                if(a[j]<a[maxIndex]){
                    maxIndex=j;
                }
            }
            int temp=a[maxIndex];
            a[maxIndex]=a[i];
            a[i]=temp;
        }
    }
    //冒泡
    public static void bubbleSort(int[]a){
        int length=a.length;
        for (int i = 0; i <length ; i++) {
            for (int j = 0; j <length-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
    public static void print(int[]a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i]+"  ");
        }
    }

}
