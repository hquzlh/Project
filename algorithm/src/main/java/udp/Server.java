package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-15 10:08
 **/

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(8080);
        byte[]bytes=new byte[1024];
        DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length);
        datagramSocket.receive(datagramPacket);
        System.out.println("接收到信息"+new String(bytes,0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
