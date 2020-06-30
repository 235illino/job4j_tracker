package stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collectTest() {
        List<Profile> addressList = Arrays.asList(
                new Profile(new Address("Kyiv", "Khreshatyk", 8, 7)),
                new Profile(new Address("New York", "First street", 9, 8)),
                new Profile(new Address("New York", "First street", 9, 8)),
                new Profile(new Address("New York", "Second street", 7, 9)),
                new Profile(new Address("London", "Third street", 7, 9))
        );
        List<Address> addressListExp = Arrays.asList(
                new Address("Kyiv", "Khreshatyk", 8, 7),
                new Address("London", "Third street", 7, 9),
                new Address("New York", "First street", 9, 8),
                new Address("New York", "Second street", 7, 9)
                );
        List<Address> addressListRsl = Profiles.collect(addressList, new AddressSort());

        assertThat(addressListExp, is(addressListRsl));
    }
}