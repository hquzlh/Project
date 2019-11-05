package tcp;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 08:58
 **/

public class ClientSocket {
    public static void main(String[] args) {
        String host="127.0.0.1";
        int port=8989;
        try {
            Socket socket=new Socket(host,port);
            Writer writer=new OutputStreamWriter(socket.getOutputStream());
            writer.write("hello");
            writer.flush();
            writer.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
