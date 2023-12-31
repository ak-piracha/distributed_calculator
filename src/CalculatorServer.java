import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public CalculatorServer() {}

    public static void main(String[] args) {
        try {
            CalculatorImplementation obj = new CalculatorImplementation();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(0);
//            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Calculator", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
