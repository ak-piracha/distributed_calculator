import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ListRegistry {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);
            System.out.println("Searching the RMI Registry...");
            String[] boundNames = registry.list();


            for (String name : boundNames) {
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
