package ServiceProviderInterface;

import service.DemoValidator;

import java.util.*;


public class Provider
{
    private static final Provider singleton = new Provider();
    private final ServiceLoader<DemoValidator> implementations = ServiceLoader.load(DemoValidator.class);

    public static Provider getInstance () {
        return singleton;
    }

    public void reload() {
        implementations.reload();
    }

    public Optional<DemoValidator> getImplementationByName(String wanted) {
        List<DemoValidator> list = new ArrayList<>();
        try {
            implementations.iterator().forEachRemaining(list::add);
            return list.stream().filter(x -> x.getImplementationName().equalsIgnoreCase(wanted)).findFirst();
        }
        catch (ServiceConfigurationError e) {
            throw new RuntimeException(e);
        }
    }

}
