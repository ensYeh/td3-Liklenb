package fr.uvsq.cprog.collex;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertThrows;

public class DnsTUITest {
    private void setInput(String content) {
        System.setIn(new ByteArrayInputStream(content.getBytes()));
    }

    @Test
    public void testDnsTUI() {
        Dns dns = new Dns();
        dns.deleteDataBase();
        setInput("add 192.168.1.1 test1.uvsq.fr");
        DnsTUI.nextCommand().affiche();
        setInput("192.168.1.1");
        DnsTUI.nextCommand().affiche();
        setInput("test1.uvsq.fr");
        DnsTUI.nextCommand().affiche();
        setInput("test1.uvsq.fr");
        DnsTUI.nextCommand().affiche();
        setInput("ls uvsq.fr");
        DnsTUI.nextCommand().affiche();
        setInput("jlqcsfjnkvbgl");
        assertThrows(IllegalArgumentException.class, () -> DnsTUI.nextCommand().affiche());
        setInput("add ");
        assertThrows(IllegalArgumentException.class, () -> DnsTUI.nextCommand().affiche());
        setInput("add 192.168.1.1");
        assertThrows(IllegalArgumentException.class, () -> DnsTUI.nextCommand().affiche());
        setInput("exit");
        DnsTUI.nextCommand().affiche();
    }
}
