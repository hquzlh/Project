package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-15 09:59
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(88);
        Socket socket=serverSocket.accept();
        Reader reader=new InputStreamReader(socket.getInputStream());
        char[] chars=new char[1024];
        int len=0;
        StringBuilder sb=new StringBuilder();
        if((len=reader.read(chars))!=-1){
            sb.append(chars);
        }
        System.out.println("接收到信息"+sb.toString());
        reader.close();
        socket.close();
        serverSocket.close();
    }
}
