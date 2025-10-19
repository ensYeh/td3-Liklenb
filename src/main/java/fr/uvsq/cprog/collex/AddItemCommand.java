package fr.uvsq.cprog.collex;

public class AddItemCommand extends Command {
    private final String name;
    private final String ip;

    public AddItemCommand(String ip, String name) {
        this.name = name;
        this.ip = ip;
    }

    @Override
    public String execute() {
        Dns dns = new Dns();
        dns.addItem(new NomMachine(name), new AdresseIP(ip));
        return "";
    }
}
