package unit13;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class HTTPGet {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("www.google.com", 80);
            String request = "GET / HTTP/1.1\r\n" +
                "Host: www.google.com\r\n" +
                "Connection: close\r\n\r\n";
            OutputStream out = sock.getOutputStream();
            out.write(request.getBytes());
            out.flush();
            InputStream in = sock.getInputStream();
            byte[] buffer = new byte[10240];
            int n;
            while ((n = in.read(buffer)) > 0) {
                String response = new String(buffer, 0, n);
                System.out.println(response);
            }
            sock.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
