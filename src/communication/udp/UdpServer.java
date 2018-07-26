package communication.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServer extends Thread {

    private DatagramSocket socket;
    private volatile boolean running;
    private byte[] buf = new byte[1024];

    public UdpServer() throws SocketException {
        socket = new DatagramSocket(4445);
    }

    public void stopServer(){
        this.running = false;
    }

    public void run() {
        running = true;

        while (running) {
            DatagramPacket packet
                    = new DatagramPacket(buf, buf.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);
            String received = new String(packet.getData(), 0, packet.getLength()).replaceAll("\0", "");

            System.out.println("Received : " + received);
            if (received.equals("end")) {
                running = false;
                System.out.println("System closed connection");
            }
        }
        socket.close();
    }

}