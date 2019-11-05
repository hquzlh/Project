import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-20 17:24
 **/

public class Sort {
    public static void main(String[] args) {
       int []a={111,6,8,3,5,2,1,23,9};
        //int []a={4,6,8,5,9};
        //selectionSort(a);
        //bubbleSort(a);
        //insertionSort(a);
        //shellSort(a);
        //quickSort(a,0,7);
        //mergeSort(a,0,7);
        //heapSort(a);
        int max=getMax(a);
        radixSort(a,10,max);
        print(a);

    }
    public static void radixSort(int[]a,int radix,int d){
        int[] tmp=new int[a.length];
        int[] buckets=new int[radix];
        for (int i = 0,rate=1; i <d ; i++) {
            Arrays.fill(buckets,0);
            System.arraycopy(a,0,tmp,0,a.length);
            for (int j = 0; j <a.length ; j++) {
                int subKey=(tmp[j]/rate)%radix;
                buckets[subKey]++;
            }
            for (int j = 1; j <radix; j++) {
                buckets[j]+=buckets[j-1];
            }
            for (int j = a.length-1; j >=0 ; j--) {
                int subKey=(tmp[j]/rate)%radix;
                a[--buckets[subKey]]=tmp[j];
            }
            rate*=10;
        }


    }
    //获取最大位数
    public static int getMax(int[]a){
        int maxvalue=0;
        for (int i = 0; i <a.length ; i++) {
            if(a[i]>maxvalue){
                maxvalue=a[i];
            }
        }
        return String.valueOf(maxvalue).length();
    }

    //堆排序
    public static void heapSort(int a[]){
        int temp=0;
        for (int i = a.length/2-1; i >=0 ; i--) {
            sink(a,i,a.length);
        }
        for (int j = a.length-1; j >0 ; j--) {
            temp=a[j];
            a[j]=a[0];
            a[0]=temp;
            sink(a,0,j);
            
        }
    }
    public static void sink(int a[],int i,int length){
        int temp=a[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&a[k]<a[k+1]){
                k++;
            }
            if(a[k]>temp){
                a[i]=a[k];
                i=k;
            }else {
                break;
            }
        }
        a[i]=temp;
    }
    //归并排序
    public static void mergeSort(int [] a,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void merge(int a[],int low,int mid,int high){
        int n=high-low+1;
        int [] b=new int[n];
        int left=low,right=mid+1,bIdx=0;
        while (left<=mid&&right<=high){
            b[bIdx++]=(a[left]<=a[right])?a[left++]:a[right++];
        }
        while (left<=mid){
            b[bIdx++]=a[left++];
        }
        while (right<=high){
            b[bIdx++]=a[right++];
        }
        for (int i = 0; i <n ; i++) {
            a[low+i]=b[i];
        }
    }
    //快速排序
    public static void quickSort( int []a,int l,int r){
        if(l<r){
            int pivot=partition(a,l,r);
            quickSort(a,l,pivot-1);
            quickSort(a,pivot+1,r);
        }
    }
    public static int partition(int []a,int l,int r){
        int tmp=a[l];
        while (l<r){
            while (l<r&&a[r]>=tmp){
                r--;
            }
            a[l]=a[r];
            while (l<r&&a[l]<=tmp){
                l++;
            }
            a[r]=a[l];
        }
        a[l]=tmp;
        return l;
    }


    //希尔排序
    public static void shellSort(int []a){
        int n=a.length;
        for(int gap=n/2;gap>0;gap=gap/2){
            for(int i=0;i<gap;i++){
                for(int j=i+gap;j<n;j+=gap){
                    if(a[j]<a[j-gap]){
                        int tmp=a[j];
                        int k=j-gap;
                        while(k>=0&&a[k]>tmp){
                            a[k+gap]=a[k];
                            k-=gap;
                        }
                        a[k+gap]=tmp;
                    }
                }
            }
        }
    }
    //插入排序
    public static void insertionSort(int [] a){
        int n=a.length;
        int j,tmp;
        for (int i = 1; i <n ; i++) {
            if(a[i]<a[i-1]){
                tmp=a[i];
                j=i-1;
                while (j>=0&&a[j]>tmp){
                    a[j+1]=a[j];
                    j--;
                }
                a[j+1]=tmp;
            }
        }
    }
    //选择排序
    public static void selectionSort(int []a){
        int n=a.length;
        for (int i = 0; i <n ; i++) {
            int minIndex=i;
            for (int j = i+1; j <n ; j++) {
                if(a[j]<a[minIndex]){
                    minIndex=j;
                }
            }
            int tmp=a[minIndex];
            a[minIndex]=a[i];
            a[i]=tmp;

        }
    }


    //冒泡排序
    public static void bubbleSort(int [] a){
        int n=a.length;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
                if(a[j]>a[j+1]){
                    int tmp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }
    }
    public static void print(int [] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
