import java.util.ArrayList;

public class Programa {
  private int itemCount = 0;
  private ArrayList<String> buffer = new ArrayList<String>();
  private Semaphore mutex = new Semaphore(1);
  private Semaphore items = new Semaphore(0);

  public void produce(String value) {
    mutex.down();
    items.up();
    buffer.add(value);
    itemCount++;
    mutex.up();
  }

  public String consume() {
    items.down();
    mutex.down();
    String item = (String) buffer.get(0);
    buffer.remove(0);
    itemCount--;
    mutex.up();

    return item;
  }
}