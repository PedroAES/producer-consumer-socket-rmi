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
      //Apenas aceita e inicia a thread o mais rápido possível para ficar disponível novamente
      Socket client = s.accept();
      Thread ct = new ClientHandlerThread(client, programa);
      ct.start();
    }
  }
}

//Ao invés de uma thread para produtor e uma para consumidor, criei uma para os dois
//Dessa forma só preciso instanciar o out e in uma vez e há um ganho em ms de desempenho
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

      if (req.equals("PRODUCE")) {
        String value = in.readLine();
        programa.produce(value);
      }

      else if (req.equals("CONSUME")) {
        out.println(programa.consume());
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}