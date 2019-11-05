/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-25 13:26
 **/

public class Test {
    public static void main(String[] args) {
        int[]a={1,3,5,2,11,8,9,4,6};
        //bubbleSort(a);
        //chooseSort(a);
        //insertSort(a);
        //shellSort(a);
        //quickSort(a,0,8);
        //mergeSort(a,0,8);
        heapSort(a);
        print(a);

    }
    //堆排序
    public static void heapSort(int []a){
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
    public static void sink(int[]a,int i,int length){
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
    public static void mergeSort(int []a,int low,int high){
        if (low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void merge(int []a,int low,int mid,int high){
        int n=high-low+1;
        int[]b=new int[n];
        int left=low,right=mid+1,bIdx=0;
        while(left<=mid&&right<=high){
            b[bIdx++]=(a[left]<=a[right])?a[left++]:a[right++];
        }
        while (left<=mid){
            b[bIdx++]=a[left++];
        }
        while (right<=high){
            b[bIdx++]=a[right++];
        }
        for (int i = 1; i <n ; i++) {
            a[low+i]=b[i];
        }
    }

    //快速排序
    public static void quickSort(int[]a,int low,int high){
        if(low<high){
            int pivot=partition(a,low,high);
            quickSort(a,low,pivot-1);
            quickSort(a,pivot+1,high);
        }
    }
    public static int partition(int[]a,int low,int high){
        int temp=a[low];
        while (low<high){
            while (low<high&&a[high]>=temp){
                high--;
            }
            a[low]=a[high];
            while (low<high&&a[low]<=temp){
                low++;
            }
            a[high]=a[low];
        }
        a[low]=temp;
        return low;
    }
    //希尔排序
    public static void shellSort(int[]a){
        int n=a.length;
        for (int gap = n/2; gap>0 ; gap=gap/2) {
            for (int i = 0; i <gap ; i++) {
                for (int j=i+gap;j<n;j+=gap){
                    if(a[j]<a[j-gap]){
                        int temp=a[j];
                        int k=j-gap;
                        while (k>0&&a[k]>temp){
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
            if(a[i]<a[i-1]){
                int j=i-1;
                int temp=a[i];
                while (j>0&&a[j]>temp){
                    a[j+1]=a[j];
                    j--;
                }
                a[j+1]=temp;
            }

        }
    }
    //选择排序
    public static void chooseSort(int[]a){
        int n=a.length;
        for (int i = 0; i <n-1 ; i++) {
            int minIndex=i;
            for (int j = i+1; j <n ; j++) {
                if(a[j]<a[minIndex]){
                    minIndex=j;
                }
            }
            int temp=a[minIndex];
            a[minIndex]=a[i];
            a[i]=temp;
        }
    }
    //冒泡算法
    public static void bubbleSort(int[]a){
        int n=a.length;
        for (int i = 0; i <n ; i++) {
            boolean tag=true;
            for(int j=0;j<n-1-i;j++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    tag=false;
                }
            }
            if(tag=true){
                return;
            }
        }
    }
    public static void print(int []a){
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
