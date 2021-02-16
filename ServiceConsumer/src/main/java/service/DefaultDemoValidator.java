package service;

public class DefaultDemoValidator implements DemoValidator{

    @Override public DemoValidator factory()        { return new DefaultDemoValidator(); }

    @Override public String getImplementationName() { return "D"; }

    @Override public String echo(String input)      { return "Default Demo Validator echo " + input; }
}
