import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Producer extends Thread {

  Programa a;

  Integer contador;

  public Producer(Programa x) {

    a = x;
    contador = 0;
  }

  public void run(Socket client) {
      a.mutex.down();
      a.items.up();
      contador++;
      a.buffer.add(contador.toString());
      a.itemCount++;
      System.out.println("produtor: producing item " + contador);
      try {
        PrintStream out = new PrintStream(client.getOutputStream());
        out.println("Produced");
      } catch (Exception e) {
        System.out.println(e);
      }
      a.mutex.up();
  }
}
