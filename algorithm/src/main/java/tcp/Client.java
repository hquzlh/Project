package tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-15 10:04
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",88);
        Writer writer=new OutputStreamWriter(socket.getOutputStream());
        writer.write("你好");
        writer.flush();
        writer.close();
        socket.close();
    }
}
