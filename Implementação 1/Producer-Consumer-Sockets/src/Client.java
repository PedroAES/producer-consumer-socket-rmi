import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n\n1-Solicitar Consumo\n2-Solicitar Produção");
    String value = scanner.nextLine();
    scanner.close();

    switch (value) {
      case "1":
        while(true){
          try {
            Socket s = new Socket("localhost", 3000);
            PrintStream out = new PrintStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("CONSUME");
            System.out.println("Cliente solicitando consumo");
            in.readLine();
            s.close();
            Thread.sleep(100);
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      case "2":
        while (true) {
          try {
            Socket s = new Socket("localhost", 3000);
            PrintStream out = new PrintStream(s.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("PRODUCE");
            System.out.println("Cliente solicitando produção");
            in.readLine();
            s.close();
            Thread.sleep(100);
          } catch (Exception e) {
            System.out.println(e);
          }
        }
      default:
        break;
    }
  }
}
