import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServer {
    public CalculatorServer() {}

    public static void main(String args[]) {
        try {
            CalculatorImplementation obj = new CalculatorImplementation();
            Calculator stub = (Calculator) UnicastRemoteObject.exportObject(obj, 9100);

            Registry registry;
            try {
                registry = LocateRegistry.createRegistry(9100);
                System.out.println("Java RMI registry created.");
            } catch (RemoteException e) {
                // If the registry is already created, fetch the existing one
                registry = LocateRegistry.getRegistry();
                System.out.println("Using existing RMI registry.");
            }

            // Bind the remote object's stub in the registry
            registry.rebind("Calculator", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
