import communication.udp.UdpClient;
import communication.udp.UdpServer;
import utils.DataFormatter;

import java.util.Arrays;

public class Testing {
    static UdpServer server;
    static UdpClient client;


    public static void main(String[] args) {
        try {
            server = new UdpServer();
            server.start();

            client = new UdpClient("localhost");
            client.send("end", 4445);
            //client.close();

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        int[] bytes = DataFormatter.hexStringToByteArray("0x41727101980", 8);
        System.out.println(Arrays.toString(bytes));

        for (int b : bytes){
            System.out.print((char)b);
        }

        System.out.println();


        System.out.println("" + (byte)0xff);
    }
}
