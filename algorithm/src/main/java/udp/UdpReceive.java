package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:12
 **/

public class UdpReceive {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket(8989);
            byte[] bytes=new byte[1024];
            DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
            datagramSocket.receive(datagramPacket);
            System.out.println("接收到的数据"+new String(bytes,0,datagramPacket.getLength()));

        } catch (java.io.IOException e) {
            e.printStackTrace();

        }
    }


}
