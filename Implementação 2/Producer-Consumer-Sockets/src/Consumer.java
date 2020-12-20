import java.io.*;
import java.net.*;

public class Consumer {
  public static void main(String args[]) throws IOException, InterruptedException {
    while (true) {
      Socket s = new Socket("localhost", 3000);
      PrintStream out = new PrintStream(s.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      out.println("CONSUME");
      System.out.println("\nConsumidor-Socket pronto para consumir");
      String item = in.readLine();
      System.out.println("Consumidor-Socket consumiu - " + item);
      s.close();
      Thread.sleep(20);
    }
  }
}