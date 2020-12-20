import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProgramaServidor {
  public ProgramaServidor() {
    try {
      ProgramaInterface programa = new Programa();
      Registry registry = LocateRegistry.createRegistry(3000);
      registry.rebind("programa", programa);
      System.out.println("\nServidor RMI em execução");
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void main(String[] args) {
    new ProgramaServidor();
  }
}
