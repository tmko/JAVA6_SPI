package service;

public class DemoValidatorC implements DemoValidator
{
    @Override public DemoValidator factory()        {   return new DemoValidatorC();                }

    @Override public String getImplementationName() {   return "C";                                 }

    @Override public String echo(String input)      {   return "Demo Validator C echo " + input;    }
}
