import java.net.Socket;
import java.util.ArrayList;

public class Programa  {

  protected Programa() {
    super();
  }

  int itemCount = 0;
  ArrayList<String> buffer = new ArrayList<String>();
  Semaphore mutex = new Semaphore(1);
  Semaphore items = new Semaphore(0);
  Consumer consumer = new Consumer(this);
  Producer producer = new Producer(this);

  public void produce(Socket client)  {
    producer.run(client);
  }

  public void consume(Socket client)  {
    consumer.run(client);
  }
}