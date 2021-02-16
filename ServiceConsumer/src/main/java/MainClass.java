import ServiceProviderInterface.Provider;
import service.DefaultDemoValidator;
import service.DemoValidator;

import java.util.Scanner;

public class MainClass {


    public static void main(String[] args) {
        new MainClass().runInteractive();
        new MainClass().runTest();
    }

    public void runInteractive() {
        System.out.println("===========================Interactive===========================");
        DemoValidator defaultObj = new DefaultDemoValidator();
        Provider provider = Provider.getInstance();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next().toUpperCase();
            String fakeMessage = String.format("[input at %d, is %s]", System.currentTimeMillis(), input);

            if (input.equals("Q")) break;
            if (input.equals("R")) { provider.reload(); continue; }

            DemoValidator validator = provider.getImplementationByName(input).orElse(defaultObj).factory();
            System.out.println(validator.echo(fakeMessage));
        }
        System.out.println("=============================Done=============================");
    }


    public void runTest () {
        Provider provider = Provider.getInstance();
        String[] impls = new String[]{"A", "B"};
        long load = 10000;

        long start;
        start = System.currentTimeMillis();
        for (int i=0; i<load; i++) {
            DemoValidator temp = new DefaultDemoValidator();
            temp.echo("");
        }
        long staticLoadTest = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        for (int i=0; i<load; i++) {
            String choice = impls[i % impls.length];
            DemoValidator temp = provider.getImplementationByName(choice).get().factory();
            temp.echo("");
        }
        long dynanmicLoadTest = System.currentTimeMillis() - start;

        long diff = (dynanmicLoadTest - staticLoadTest);
        System.out.println( String.format("static %d, dynamic %d, diff %d", staticLoadTest, dynanmicLoadTest, diff));
    }
}
