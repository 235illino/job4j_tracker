package stream;

import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Address getAddress() {
        return address;
    }

    public static List<Address> collect(List<Profile> profiles) {
      return profiles.stream().map(Profile::getAddress).collect(Collectors.toList());
    }
}
