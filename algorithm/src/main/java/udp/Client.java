package udp;

import java.io.IOException;
import java.net.*;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-10-15 10:12
 **/

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        String str="你好1" ;
        DatagramPacket datagramPacket=new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getLocalHost(),8080);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }
}
