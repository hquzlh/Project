package udp;

import java.net.*;

/**
 * @program: algorithm
 * @description:
 * @author: Mr.Zhu
 * @create: 2019-09-26 09:08
 **/

public class UdpSender {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket=new DatagramSocket();
            String str="你好啊";
            DatagramPacket packet=new DatagramPacket(str.getBytes(),str.getBytes().length, InetAddress.getLocalHost(),8989);
            datagramSocket.send(packet);
            datagramSocket.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
