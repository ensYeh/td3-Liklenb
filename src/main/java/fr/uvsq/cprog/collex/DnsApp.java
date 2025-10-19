package fr.uvsq.cprog.collex;

/**
 * Hello world!
 *
 */
public class DnsApp
{
    public static void main( String[] args ) {
        run();
    }

    public static void run() {
        String shouldQuit = "";
        while (shouldQuit != null) {
            shouldQuit = DnsTUI.nextCommand().affiche();
        }
    }
}
