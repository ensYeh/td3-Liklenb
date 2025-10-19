package fr.uvsq.cprog.collex;

public class FetchNamesCommand extends Command {
    private final NomMachine name;

    public FetchNamesCommand(NomMachine nomMachine) {
        this.name = nomMachine;
    }

    @Override
    public String execute() {
        Dns dns = new Dns();
        StringBuilder result = new StringBuilder();
        for (DnsItem item : dns.getItems(name)) {
            result.append(item.toString());
            result.append("\n");
        }
        return result.toString();
    }
}
