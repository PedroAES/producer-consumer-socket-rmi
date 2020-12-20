import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Producer {
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.getRegistry("localhost", 3000);
      ProgramaInterface programa = (ProgramaInterface) registry.lookup("programa");
      Integer contador = 0;
      while (true) {
        contador++;
        String item = contador.toString();
        programa.produce(item);
        System.out.println("Produtor-RMI produziu - " + item);
        Thread.sleep(100);
      }
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}