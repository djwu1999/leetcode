import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        try (ServerSocket s = new ServerSocket(8080)) {
            try (Socket incoming = s.accept()) {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();
                try (Scanner in = new Scanner(inStream, "UTF-8")) {
                    PrintWriter out = new PrintWriter(new OutputStreamWriter(outStream, "UTF-8"), true);
                    out.print("Hello! enter bye to exit");
                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.print("Echo : " + line);
                        if(line.trim().equals("BYE"))
                            done = true;
                    }
                }
            }
        }
    }
}
