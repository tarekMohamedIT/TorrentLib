package communication.udp;

import java.io.IOException;
import java.net.*;

public class UdpClient {
    private DatagramSocket socket;
    private InetAddress address;

    public UdpClient(String ipAddress) throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        address = InetAddress.getByName(ipAddress);
    }

    public void send(String msg, int port) throws IOException {
        byte[] buf = msg.getBytes();
        System.out.println("sent : " + buf.length);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
        socket.send(packet);
    }

    public void close() {
        socket.close();
    }
}
