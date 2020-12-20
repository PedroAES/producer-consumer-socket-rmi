import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProgramaInterface extends Remote{
	public void produce() throws RemoteException;
	public void consume() throws RemoteException;
}
