package service;

public class DemoValidatorA implements DemoValidator
{
    @Override public DemoValidator factory()        {   return new DemoValidatorA();                }

    @Override public String getImplementationName() {   return "A";                                 }

    @Override public String echo(String input)   {
        return "Demo Validator A echo " + input;
    }
}
