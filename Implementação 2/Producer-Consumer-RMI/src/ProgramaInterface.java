import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProgramaInterface extends Remote{
	public void produce(String value) throws RemoteException;
	public String consume() throws RemoteException;
}
