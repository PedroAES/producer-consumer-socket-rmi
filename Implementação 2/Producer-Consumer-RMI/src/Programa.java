import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Programa extends UnicastRemoteObject implements ProgramaInterface {

  private static final long serialVersionUID = 1L;

  protected Programa() throws RemoteException {
    super();
  }

  int itemCount = 0;
  ArrayList<String> buffer = new ArrayList<String>();
  Semaphore mutex = new Semaphore(1);
  Semaphore items = new Semaphore(0);

  @Override
  public void produce(String value) throws RemoteException {
    mutex.down();
    items.up();
    buffer.add(value);
    itemCount++;
    mutex.up();
  }

  @Override
  public String consume() throws RemoteException {
    items.down();
    mutex.down();
    String item = (String) buffer.get(0);
    buffer.remove(0);
    itemCount--;
    mutex.up();

    return item;
  }
}