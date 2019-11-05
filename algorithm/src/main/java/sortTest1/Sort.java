package sortTest1;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-30 16:09
 **/

public class Sort {
    public static void main(String[] args) {
        int[]a ={1,3,5,2,8,7,0};
        //bubbleSort(a);
        //chooseSort(a);
        //insertSort(a);
        //shellSort(a);
        //quickSort(a,0,6);
        //mergeSort(a,0,6);
        heapSort(a);
        print(a);
    }
    //堆排序
    public static void heapSort(int[]a){
        int temp=0;
        int length=a.length;
        for(int i=length/2-1;i>=0;i--){
            sink(a,i,length);
        }
        for (int j = length-1; j >0 ; j--) {
            temp=a[j];
            a[j]=a[0];
            a[0]=temp;
            sink(a,0,j);
        }
    }
    public static void sink(int[]a,int i,int length){
        int temp=a[i];
        for (int j =i*2+1 ; j <length ; j=j*2+1) {
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
    public static void mergeSort(int []a,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void merge(int []a,int low,int mid,int high){
        int n=high-low+1;
        int[]c=new int[n];
        int left=low,right=mid+1,index=0;
        while (left<=mid&&right<=high){
            c[index++]=(a[left]<=a[right])?a[left++]:a[right++];
        }
        while (left<=mid){
            c[index++]=a[left++];
        }
        while (right<=high){
            c[index++]=a[right++];
        }
        for (int i = 0; i <n ; i++) {
            a[low+i]=c[i];
        }
    }
    //快速排序
    public static void quickSort(int[]a,int left,int right){
        if(left<right){
            int pivot=partition(a,left,right);
            quickSort(a,left,pivot-1);
            quickSort(a,pivot+1,right);
        }
    }
    public static int partition(int[] a,int left,int right){
        int temp=a[left];
        while (left<right){
            while (left<right&&a[right]>temp){
                right--;
            }
            a[left]=a[right];
            while (left<right&&a[left]<temp){
                left++;
            }
            a[right]=a[left];
        }
        a[left]=temp;
        return left;

    }
    //希尔排序
    public static void shellSort(int[]a){
        int n=a.length;
        for (int gap = n/2; gap >0 ; gap=gap/2) {
            for (int i = 0; i <n ; i++) {
                for (int j = gap; j <n ; j+=gap) {
                    if(a[j]<a[j-gap]){
                        int k=j-gap;
                        int temp=a[j];
                        while (k>=0&&a[k]>temp){
                            a[k+gap]=a[k];
                            k-=gap;
                        }
                        a[k+gap]=temp;
                    }
                }

            }
        }
    }
    //插入排序
    public static void insertSort(int []a){
        int n=a.length;
        for (int i = 1; i <n ; i++) {
            if(a[i]<a[i-1]) {
                int j = i - 1;
                int date = a[i];
                while (j >= 0 && a[j] > date) {
                    a[j+1]=a[j];
                    j--;
                }
                a[j + 1] = date;
            }
        }
    }
    //选择排序
    public static void chooseSort(int []a){
        int n=a.length;
        for (int i = 0; i <n ; i++) {
            int midIndex=i;
            for (int j = i+1; j <n ; j++) {
                if(a[j]<a[midIndex]){
                    midIndex=j;
                }
            }
            int temp=a[midIndex];
            a[midIndex]=a[i];
            a[i]=temp;

        }
    }
    //冒泡排序
    public static void bubbleSort(int []a){
        int n=a.length;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n-i-1 ; j++) {
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
            System.out.println(a[i]);

        }
    }
}
