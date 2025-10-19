package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.*;

public class DnsTest {
    @Test
    public void testDns() {
        Dns dns = new Dns();
        dns.addItem(new NomMachine("test1.uvsq.fr"), new AdresseIP("192.168.1.1"));
        dns.addItem(new NomMachine("test2.uvsq.fr"), new AdresseIP("192.168.1.2"));
        dns.addItem(new NomMachine("test2.uvsk.fr"), new AdresseIP("192.168.1.3"));
        assertThrows(IllegalArgumentException.class, () -> dns.addItem(new NomMachine("test2.uvsq.fr"), new AdresseIP("192.168.1.2")));
        assertEquals(new DnsItem(new NomMachine("test1.uvsq.fr"), new AdresseIP("192.168.1.1")), dns.getItem(new NomMachine("test1.uvsq.fr")));
        assertEquals(new DnsItem(new NomMachine("test1.uvsq.fr"), new AdresseIP("192.168.1.1")), dns.getItem(new AdresseIP("192.168.1.1")));
        DnsItem[] items = {
                new DnsItem(new NomMachine("test2.uvsq.fr"), new AdresseIP("192.168.1.2")),
                new DnsItem(new NomMachine("test1.uvsq.fr"), new AdresseIP("192.168.1.1"))
        };
        assertArrayEquals(items, dns.getItems(new NomMachine("uvsq.fr")));
        new Dns();
    }
}
