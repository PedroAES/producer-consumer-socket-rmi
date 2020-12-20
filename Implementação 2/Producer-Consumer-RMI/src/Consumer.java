import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Consumer {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 3000);
      ProgramaInterface programa = (ProgramaInterface) registry.lookup("programa");
      while (true) {
        System.out.println("\nConsumidor-RMI pronto para consumir");
        String item = programa.consume();
        System.out.println("Consumidor-RMI consumiu - " + item);
        Thread.sleep(20);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
