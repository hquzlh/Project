package str;

import java.util.*;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 11:07
 **/

public class test1 {
    public static void main(String[] args) {

        System.out.println("----------------");

        test10();
        //treeSet();

    }

    public static  void test11(){
        String name="abajbjasd";
        String ab=new String("9asdjkasd");

    }
    public static void test10(){
        Hashtable hashtable=new Hashtable();
        for (int i = 0; i <10 ; i++) {
            hashtable.put(i,i*5);
        }
        System.out.println(hashtable);
        System.out.println(hashtable.contains(1));
    }

    public static void test9(){
        HashMap hashMap=new HashMap();
        for (int i = 0; i <10 ; i++) {
            hashMap.put(i,i*5);
        }


        Map map = Collections.synchronizedMap(hashMap);

        Set<Map.Entry<Integer,Integer>> set = hashMap.entrySet();

        Iterator<Map.Entry<Integer,Integer>> iterator=set.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();

            System.out.println(entry.getKey()+"value"+entry.getValue());

        }
    }
    public static void test8(){

        HashSet hashSet=new HashSet();
        hashSet.add(1);
        hashSet.add(4);
        hashSet.add(5);
        hashSet.add(18);
        hashSet.add(23);
        hashSet.add(22);
        hashSet.add(17);
        hashSet.add(24);
        hashSet.add(19);
        hashSet.add(1);
        for (Object o:hashSet
             ) {
            System.out.println(o);

        }
    }






    public static void test7(){
        TreeSet ts=new TreeSet();
        ts.add(new Student(1));
        ts.add(new Student(5));
        ts.add(new Student(3));
        ts.add(new Student(8));
        ts.add(new Student(11));

        for (Object i : ts) {
            System.out.println(i);
        }
    }
    public static void treeSet(){
        TreeSet<Integer> ts = new TreeSet<Integer>();

        // 创建元素并添加
        // 20,18,23,22,17,24,19,18,24
        ts.add(20);
        ts.add(18);
        ts.add(23);
        ts.add(22);
        ts.add(17);
        ts.add(24);
        ts.add(19);
        ts.add(18);
        ts.add(24);

        // 遍历
        for (Integer i : ts) {
            System.out.println(i);
        }

    }
    public static void test6(){
        HashSet hashSet = new HashSet<>();
        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        TreeSet treeSet = new TreeSet<>();

        for (Integer data : Arrays.asList(15, 20, 3, 1, 5)) {
            hashSet.add(data);
            linkedHashSet.add(data);
            treeSet.add(data);
        }
        System.out.println("Ordering in HashSet :" + hashSet);

        //FIFO保证安装插入顺序排序
        System.out.println("Order of element in LinkedHashSet :" + linkedHashSet);

        //内部实现排序
        System.out.println("Order of objects in TreeSet :" + treeSet);


    }
    public static void test5(){
        LinkedList list=new LinkedList();
        list.add("1");
        list.add("2");
        list.add("6");
        list.add("74");
        list.add("5");

        System.out.println(list.pop());
       /* Object [] str=  list.toArray(new Object[list.size()]);
        for (int i = 0; i <str.length ; i++) {
            System.out.println(str[i]);
        }*/
       List list1= (List) list.clone();
        for (Object o:list1
             ) {
            System.out.println(o);

        }

    }
    public static void test3(){
        List list2=new ArrayList();
        list2.add("1231");
        list2.add("123123123");
        List list=new ArrayList();
        list.add("123");
        list.add("7982");
        list.add("792");
        list.add("7923");
        list.add("79123");
        list.add(null);

        /*ListIterator listIterator = list.listIterator(1);
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }*/
        List list1= Collections.synchronizedList(list);

        System.out.println(list1.get(1));
        System.out.println(list1.contains(123));
        list1.addAll(list2);
        System.out.println(list1);


    }
    public static void test2(){
        Integer i1=new Integer(2);
        System.out.println(Integer.valueOf(127)==Integer.valueOf(127));
    }
    public static void test4(){
        String s0="helloworld";
        String s3=new String("helloworld");
        String s1=new String("helloworld");
        String s2="hello" + new String("world");
        System.out.println("===========test4============");
        System.out.println(s1==s3);
        System.out.println(s3);
        System.out.println( s0==s1 ); //false
        System.out.println( s0==s2 ); //false
        System.out.println( s1==s2 ); //false
        System.out.println(s1.equals(s2));
        System.out.println(s0.equals(s1));
    }
    public static void test1(){
        String str="abcbababa/n";
        char[] chars=str.toCharArray();
        for (char c:chars
        ) {
            System.out.println(c);
        }
    }

}
