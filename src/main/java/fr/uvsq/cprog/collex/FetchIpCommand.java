package fr.uvsq.cprog.collex;

public class FetchIpCommand extends Command {
    private final NomMachine machine;

    public FetchIpCommand(NomMachine machine) {
        this.machine = machine;
    }

    @Override
    public String execute() {
        Dns dns = new Dns();
        return dns.getItem(machine).ip.toString();
    }
}
