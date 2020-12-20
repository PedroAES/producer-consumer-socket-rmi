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
  Consumer consumer = new Consumer(this);
  Producer producer = new Producer(this);

  @Override
  public void produce() throws RemoteException {
    producer.run();
  }

  @Override
  public void consume() throws RemoteException {
    consumer.run();
  }
}