package fr.uvsq.cprog.collex;

import org.junit.Test;
import static org.junit.Assert.*;

public class DnsitemTest {
    @Test
    public void checkConstructor() {
        assertEquals("www.uvsq.fr -> 192.168.1.1", new DnsItem(new NomMachine("www.uvsq.fr"), new AdresseIP("192.168.1.1")).toString());
    }
}
