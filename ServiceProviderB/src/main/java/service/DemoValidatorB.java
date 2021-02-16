package service;

public class DemoValidatorB implements DemoValidator
{
    @Override public DemoValidator factory()        {   return new DemoValidatorB();                }

    @Override public String getImplementationName() {   return "B";                                 }

    @Override public String echo(String input)   {   return "Demo Validator B echo " + input;    }
}
