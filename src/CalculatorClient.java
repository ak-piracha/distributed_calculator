import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    private CalculatorClient() {}

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            Calculator stub = (Calculator) registry.lookup("Calculator");

            stub.pushValue(10);
            stub.pushValue(20);
            stub.pushValue(30);

            stub.pushOperation("min");
            System.out.println("min: " + stub.pop());

            stub.pushValue(40);
            stub.pushValue(50);
            stub.pushOperation("max");
            System.out.println("max: " + stub.pop());

            stub.pushValue(2);
            stub.pushValue(3);
            stub.pushOperation("gcd");
            System.out.println("gcd: " + stub.pop());

            stub.pushValue(15);
            stub.pushValue(25);
            stub.pushOperation("lcm");
            System.out.println("lcm: " + stub.pop());

            System.out.println("delayPop: " + stub.delayPop(1000));

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
