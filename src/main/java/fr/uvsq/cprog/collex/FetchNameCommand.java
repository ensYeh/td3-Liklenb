package fr.uvsq.cprog.collex;

public class FetchNameCommand extends Command {
    private final AdresseIP ip;

    public FetchNameCommand(AdresseIP adresseIP) {
        this.ip = adresseIP;
    }

    @Override
    public String execute() {
        Dns dns = new Dns();
        return dns.getItem(ip).machine.toString();
    }
}
