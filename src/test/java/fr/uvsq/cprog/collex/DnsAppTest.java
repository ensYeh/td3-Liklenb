package fr.uvsq.cprog.collex;

import org.junit.Test;

import java.io.ByteArrayInputStream;

public class DnsAppTest
{
    @Test
    public void shouldAnswerWithTrue() {
        System.setIn(new ByteArrayInputStream("exit".getBytes()));
        DnsApp.main(null);
    }
}
