package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class NomMachineTest {
    @Test
    public void testConstructor() {
        assertEquals("www.uvsq.fr", new NomMachine("www.uvsq.fr").toString());
        assertThrows(IllegalArgumentException.class, () -> new NomMachine(""));
        assertThrows(IllegalArgumentException.class, () -> new NomMachine("uvsq"));
        assertThrows(IllegalArgumentException.class, () -> new NomMachine(null));
    }
}
