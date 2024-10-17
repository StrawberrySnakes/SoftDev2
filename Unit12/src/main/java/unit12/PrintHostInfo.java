package unit12;
import java.net.*;

public class PrintHostInfo {

    public static void main(String[] args) throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();
        String hostName = host.getHostName();
        System.out.println(hostName);
        String address = host.getHostAddress();
        System.out.println(address);
    }
    
}
