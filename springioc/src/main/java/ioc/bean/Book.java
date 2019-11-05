package ioc.bean;



/**
 * @program: springioc
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-22 15:00
 **/

public class Book {
    private String bookName;
    private double price;

    public Book() {
        super();
    }
    public Book(String bookName, double price) {
        super();
        this.bookName = bookName;
        this.price = price;
    }
    public String getBookName() {
        return bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Book [bookName=" + bookName + ", price=" + price + "]";
    }
}

