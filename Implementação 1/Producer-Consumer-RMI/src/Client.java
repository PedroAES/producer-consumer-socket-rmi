import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
  
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("\n\n1-Solicitar Consumo\n2-Solicitar Produção");
    String value = s.nextLine();

    switch (value) {
      case "1":
        try {
          Registry registry = LocateRegistry.getRegistry("localhost", 3000);
          ProgramaInterface programa = (ProgramaInterface) registry.lookup("programa");
          while (true) {
            System.out.println("\nCliente solicitando consumo");
            programa.consume();
            Thread.sleep(20);
          }
        } catch (Exception e) {
          System.out.println(e);
        }
        break;
      case "2":
        try {
          Registry registry = LocateRegistry.getRegistry("localhost", 3000);
          ProgramaInterface programa = (ProgramaInterface) registry.lookup("programa");
          while (true) {
            programa.produce();
            System.out.println("Cliente solicitando produção");
            Thread.sleep(100);
          }
        } catch (Exception e) {
          System.out.println(e);
        }
        break;
      default:
        break;
    }
  }
}
