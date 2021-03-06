import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: jvm-test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-27 14:20
 **/

public class Sort {
    public static void main(String[] args) {
        String s= "57-45 54-43 58-45 54-39 58-39 58-38 58-43 59-43 67-39 68-45 " +
                "68-43 70-45 69-54 71-42 66-37 59-78 57-79 57-49 54-50 55-47 54-47" +
                " 49-33 51-33 66-46 66-45 69-48 69-47 68-49 70-47 71-47 67-46 70-46" +
                " 67-45 71-46 69-46 68-47 66-35 70-52 71-52 67-36 68-51 67-47 67-48" +
                " 67-49 66-49 66-50 66-52 69-53 67-50 58-44 55-49 54-49 58-50 59-49" +
                " 92-79 97-83 100-80 100-82 97-82 92-77 90-79 90-83 101-80 101-84 101-81 " +
                "101-82 100-70 99-83 101-83 91-78 99-81 100-81 98-74 99-82 99-79 99-78 98-89" +
                " 90-86 90-87 90-78 91-76 56-48 59-47 57-46 58-47 56-46 58-46 56-44 55-44 55-43" +
                " 59-45 58-44 55-39 56-40 57-39 56-39 59-44 56-43 70-44 68-44 71-44 69-37 70-51 " +
                "66-53 71-41 66-38 58-78 56-80 56-78 55-82 55-81 55-46 57-48 54-46 54-48 70-56 64-75" +
                " 68-57 70-59 69-57 69-80 63-77 60-81 62-80 60-83 62-77 61-78 62-79 97-66 98-65" +
                " 96-65 96-66 100-65 97-67 96-86 96-84 98-94 97-86 96-85 96-72 97-69 74-66 73-65 80-68 " +
                "77-64 75-63 76-63 75-64 75-65 81-66 82-66 67-54 79-68 73-73 63-76 61-77 60-80 96-70 " +
                "101-66 96-73 101-65 69-39 71-54 67-51 71-53 68-53 66-51 66-39 98-67 96-68 99-68 99-69 97-74 " +
                "97-72 101-67 101-68 96-69 56-76 54-78 54-77 54-80 55-83 51-31 51-32 74-67 74-68" +
                " 73-68 83-66 82-67 81-65 80-66 28-65 28-67 66-55 71-57 71-56 70-55 70-57 69-56 61-80" +
                "73-72 73-70 74-69 73-74 76-64 60-82 71-59 70-58 70-60 71-58 62-76 62-75 65-73 "
                + "98-72 98-73 97-76 101-69 98-69 98-68 100-75 96-78 96-75 101-73 96-76 100-74" +
                " 101-74 96-74 101-75 96-73 97-80 97-81 96-71 97-79 97-78 99-74 99-75 98-77 98-76 "
                + "100-76 100-91 96-88 99-87 96-89 100-88 100-90 100-87 99-87 100-90 99-86 98-89 96-90" +
                " 96-82 101-87 13-74 110-73 110-72 109-76 113-77 110-75 112-76 108-76 108-77 118-81" +
                " 113-81 112-80 124-98 122-94 112-97 120-94 123-96 123-97 123-95 122-98 123-99 117-66 119-67" +
                " 117-67 105-86 104-92 103-91 103-90 104-93 103-89 105-89 105-88 106-84 105-87 106-87" +
                " 106-86 106-85 107-86 104-89 103-86 103-87 104-87 107-84 57-83 58-81 55-85 54-81 50-62" +
                " 59-82 58-80 56-81 55-86 57-81 57-84 57-84 58-83 59-83 57-82 55-64 118-80 98-56 116-86 " +
                "119-84 115-86 115-85 114-86 118-86 100-93 97-93 98-92 99-95 100-95 99-94 97-92" +
                " 100-97 100-96 97-94 96-93 95-88 92-89 92-88 94-85 94-87 94-88 92-87 95-85 95-80 94-84 " +
                "95-81 95-78 95-82 94-83 80-42 78-44 80-44 78-55 81-46 81-43 81-44 81-45 80-43 78-48" +
                " 79-45 80-47 79-46 83-48 79-44 79-50 80-50 78-46 79-40 79-48 78-49 80-46 78-40 79-42" +
                " 78-42 78-41 79-38 79-41 79-38 79-39 81-48 80-44 85-68 88-71 89-70 88-72 84-68 89-74" +
                " 89-72 87-75 86-73 86-74 88-73 89-71 84-70 97-87 98-78 98-80 96-79 96-80 96-81 98-79 99-80 "
                + "100-61 98-61 97-61 80-41 80-67 78-62 79-64 83-64 78-63 81-62 83-60 82-60 82-57 83-59 " +
                "83-58 81-50 81-51 82-62 81-63 81-64 80-64 79-69 79-65 83-65 78-64 79-66 82-63 81-65" +
                " 78-52 82-50 92-78 91-78 93-76 94-75 95-77 93-77 96-92 100-92 95-60 95-61 92-66 92-65 " +
                "93-60 95-59 98-86 108-88 111-89 109-88 108-91 110-92 113-97 113-98 95-64 94-65 92-64 " +
                "93-63 93-62 93-65 92-49 92-50 92-47 95-75 94-74 95-74 90-85 90-84 90-82 93-74 90-73 92-75" +
                " 91-75 73-63 76-60 74-61 74-62 75-62 75-61 77-62 76-61 77-56 76-56 76-55 77-55 75-55" +
                " 74-57 73-58 73-57 72-57 72-58 72-59 74-58 73-55 72-56 74-56 77-54 76-54 77-50 76-49 74-55" +
                " 76-48 77-48 77-49 77-47 74-54 74-53 73-54 75-49 75-47 75-48 76-46 75-46 77-46 72-51" +
                " 74-51 74-50 72-49 72-50 74-47 77-78 77-77 75-74 77-76 75-75 76-80 76-79 76-74 77-80 75-79" +
                " 75-77 75-80 75-53 88-42 88-41 88-40 87-42 89-41 86-41 89-42 87-41 87-40 87-46 88-45 " +
                "89-43 87-44 87-43 89-87 89-83 89-86 88-88 86-78 86-80 88-87 88-58 87-59 84-54 84-53 85-54 " +
                "89-57 89-58 85-56 86-59 87-62 87-63 87-64 88-62 86-61 85-58 86-62 89-61 88-63 88-60" +
                " 89-64 88-59 84-55 87-48 84-48 87-51 88-51 85-45 86-47 86-48 84-45 89-49 89-50 87-49" +
                " 88-46 87-50 99-90 96-88 98-88 97-71 97-90 96-83 101-89 101-92 101-90 95-62 94-62" +
                " 94-61 91-62 92-62 92-63 91-61 92-61 94-63 95-65 89-46 84-44 85-57 77-53 73-53 73-52 " +
                "72-55 75-54 72-60 73-60 74-59 73-59 74-60 75-57 74-40 77-37 74-37 84-46 85-44 85-43" +
                " 88-47 85-40 85-42 89-48 84-47 86-65 84-65 84-61 75-66 76-67 76-68 77-65 76-65 76-66" +
                " 90-67 90-64 90-63 91-56 74-74 75-67 77-67 92-48 92-51 92-58 93-57 93-58 90-66 90-68 122-91" +
                " 122-92 125-88 121-96 123-90 124-88 122-90 123-88 120-85 120-86 120-91 70-37 71-37 66-36" +
                " 67-37 70-38 71-38 63-80 62-81 63-79 63-78 61-84 60-84 61-82 61-81 62-84 63-82 64-79 65-79 " +
                "62-82 63-83 66-79 66-77 54-69 54-68 58-57 59-56 56-55 57-57 56-56 59-57 52-44 51-45 55-62 " +
                "56-63 56-64 54-62 58-63 59-63 58-62 57-63 59-62 43-75 44-71 43-85 43-76 44-73 44-69 43-80" +
                " 47-64 46-64 122-72 122-71 121-69 120-70 120-69 120-68 121-73 121-72 122-73 124-75 120-80 " +
                "121-83 121-84 122-82 123-82 121-86 122-83 122-86 123-83 121-87 123-84 120-84 121-88 120-83 " +
                "121-89 125-87 123-86 122-87 122-89 122-88 121-90";
        String[] str2=sort1(s.split(" "));
        String tag="";
        for (int i = 0; i <str2.length ; i++) {
            System.out.print(str2[i]+",");
            if(str2[i].length()>6){
                tag="有错误";
            }
        }
        System.out.println(tag);
    }
    public static String[] sort(String []datas){

        for (int i = 0; i <datas.length ; i++) {
            boolean tag=true;
            int left=Integer.parseInt(datas[i].split("-")[0]);
            int right=Integer.parseInt(datas[i].split("-")[1]);
            for (int j = 0; j <datas.length ; j++) {
                int left1=Integer.parseInt(datas[j].split("-")[0]);
                int right1=Integer.parseInt(datas[j].split("-")[1]);
                if(left>left1){
                    String temp=datas[i];
                    datas[i]=datas[j];
                    datas[j]=temp;

                }else {
                    if(left==left1&&right>right1){
                        String temp=datas[i];
                        datas[i]=datas[j];
                        datas[j]=temp;
                    }
                }
            }

        }
        return datas;
    }
    public static String[] sort1(String[]datas){
        int length=datas.length;

        for (int i = 0; i <length ; i++) {
            int minIndex=i;
            for (int j = i; j <length ; j++) {
                int left=Integer.parseInt(datas[minIndex].split("-")[0]);
                int right=Integer.parseInt(datas[minIndex].split("-")[1]);
                int left1=Integer.parseInt(datas[j].split("-")[0]);
                int right1=Integer.parseInt(datas[j].split("-")[1]);
                if(left1<left){
                    minIndex=j;
                }else if(left==left1&&right1<right){
                    minIndex=j;
                }
            }
            String temp=datas[minIndex];
            datas[minIndex]=datas[i];
            datas[i]=temp;
        }
        return datas;
    }
}
