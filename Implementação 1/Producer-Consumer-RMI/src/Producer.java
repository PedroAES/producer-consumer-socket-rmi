public class Producer extends Thread {

  Programa a;

  Integer contador;

  public Producer(Programa x) {

    a = x;
    contador = 0;
  }

  public void run() {
      a.mutex.down();
      a.items.up();
      contador++;
      a.buffer.add(contador.toString());
      a.itemCount++;
      System.out.println("produtor: producing item " + contador);
      a.mutex.up();
  }
}
