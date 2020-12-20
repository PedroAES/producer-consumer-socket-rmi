import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProgramaServidor {
  public static void main(String[] args) throws UnknownHostException, IOException {
    ServerSocket s = new ServerSocket(3000);
    Programa programa = new Programa();
    System.out.println("\nServidor Socket em execução");
    while (true) {
      Socket client = s.accept();
      Thread ct = new ClientHandlerThread(client, programa);
      ct.start();
    }
  }
}

class ClientHandlerThread extends Thread {
  Socket client;
  Programa programa;

  ClientHandlerThread(Socket client, Programa programa) {
    this.client = client;
    this.programa = programa;
  }

  @Override
  public void run() {
    try {
      PrintStream out = new PrintStream(client.getOutputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
      String req = in.readLine();
      if (req.equals("PRODUCE")) 
        programa.produce(client);
      
      else if (req.equals("CONSUME")) 
        programa.consume(client);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}