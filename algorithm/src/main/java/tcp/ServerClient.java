package tcp;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:01
 **/

public class ServerClient {
    public static void main(String[] args) {
        int port=8989;
        try {
            ServerSocket serverSocket=new ServerSocket(port);
            Socket socket=serverSocket.accept();
            Reader reader=new InputStreamReader(socket.getInputStream());
            char []chars=new char[1024];
            int len;
            StringBuilder stringBuilder=new StringBuilder();
            while ((len=reader.read(chars))!=-1){
                stringBuilder.append(chars);
            }
            System.out.println("接收到的信息"+stringBuilder.toString());
            reader.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
