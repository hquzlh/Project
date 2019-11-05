package reverse;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-30 15:56
 **/

public class Test {
    public static void main(String[] args) {
        String str="老母猪戴胸罩一套又一套";
        //reverse1(str);
        System.out.println(reverse2(str));
    }
    public static void reverse(String str){
        StringBuilder stringBuilder=new StringBuilder(str);
        System.out.println(stringBuilder.reverse().toString());
    }
    public static void reverse1(String str){
        char[] c=new char[str.length()];
        int n=str.length();
        for (int i = 0; i<str.length() ; i++) {
            c[i]=str.charAt(--n);
        }
        System.out.println(new String(c));
    }
    public static String reverse2(String str){
        int length=str.length();
        if(length<=1){
            return str;
        }
        String left=str.substring(0,length/2);
        String right=str.substring(length/2,length);
        String after=reverse2(right)+reverse2(left);
        return after;
    }
}
