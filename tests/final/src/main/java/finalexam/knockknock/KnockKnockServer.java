package finalexam.knockknock;

import java.io.*;
import java.net.*;

public class KnockKnockServer {
  private Socket socket;
  private String setup;
  private String punchline;

  public KnockKnockServer(Socket socket, String setup, String punchline) {
    this.socket = socket;
    this.setup = setup;
    this.punchline = punchline;
  }

  public void tellKnockKnock() throws IOException {
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    out.println("Knock, knock.");

    String who = in.readLine();
    out.println(setup + " who?");

    String whoName = in.readLine();
    out.println(punchline);

    System.out.println("Client: " + who);
    System.out.println("Client: " + whoName);
  }

  public void close() throws IOException {
    socket.close();
  }

  public static void main(String[] args) throws IOException {
    ServerSocket listener = new ServerSocket(54322);
    try {
      Socket socket = listener.accept();
      String setup = "Can";
      String punchline = " openers!";
      KnockKnockServer server = new KnockKnockServer(socket, setup, punchline);
      server.tellKnockKnock();
    } finally {
      listener.close();
    }
  }
}
