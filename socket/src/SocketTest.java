import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("time-a.nist.gov", 13);
            s.setSoTimeout(10000);
            Scanner in = new Scanner(s.getInputStream(), "UTF-8");
            InetAddress[] address = InetAddress.getAllByName("www.google.com");
            Arrays.stream(address).forEach(System.out::println);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
