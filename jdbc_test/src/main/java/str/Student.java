package str;

/**
 * @program: jdbc_test
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-19 16:27
 **/

public class Student implements Comparable {
    int id;

    public Student(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Student student= (Student) o;
        if (student.id < this.id){
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
