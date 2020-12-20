import java.io.*;
import java.net.*;

public class Producer {
  public static void main(String args[]) throws IOException, InterruptedException {
    Integer contador = 0;
    while (true) {
      Socket s = new Socket("localhost", 3000);
      PrintStream out = new PrintStream(s.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
      contador++;
      String item = contador.toString();
      out.println("PRODUCE");
      out.println(item);
      System.out.println("Produtor-Socket produziu - " + item);
      s.close();
      Thread.sleep(100);
    }
  }
}