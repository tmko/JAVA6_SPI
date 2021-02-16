package service;

public interface DemoValidator {
    DemoValidator factory ();

    String getImplementationName ();

    String echo(String input);
}
