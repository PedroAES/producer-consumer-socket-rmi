public class Consumer extends Thread {

  Programa a;

  public Consumer(Programa x) {

    a = x;
  }

  public void run() {

    try {
      a.items.down();
      a.mutex.down();
      String item;
      item = (String) a.buffer.get(0);
      a.buffer.remove(0);
      a.itemCount--;
      System.out.println("consumer: consuming item " + item);
      a.mutex.up();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}