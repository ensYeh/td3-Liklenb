package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class AdresseIPTest {
    @Test
    public void checkConstructor() {
        assertEquals("192.168.1.1", new AdresseIP("192.168.1.1").toString());
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP(""));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP("-12.1000.256.15"));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP("1000.-12.256.15"));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP("15.16.100"));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP("15.16.100.192.168"));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP("abcd"));
        assertThrows(IllegalArgumentException.class, () -> new AdresseIP(null));
    }
}
