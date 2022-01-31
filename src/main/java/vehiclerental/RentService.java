package vehiclerental;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RentService {
    private static final int maxRent = 180;
    private Map<Rentable, User> actualRenting = new TreeMap<>();
    private Set<User> users = new HashSet<>();
    private Set<Rentable> rentables = new HashSet<>();

    public Map<Rentable, User> getActualRenting() {
        return actualRenting;
    }

    public Set<User> getUsers() {
        return users;
    }

    public Set<Rentable> getRentables() {
        return rentables;
    }
}
