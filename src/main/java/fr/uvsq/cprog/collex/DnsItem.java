package fr.uvsq.cprog.collex;

public class DnsItem {
    final AdresseIP ip;
    final NomMachine machine;

    public DnsItem(NomMachine machine, AdresseIP ip) {
        this.ip = ip;
        this.machine = machine;
    }

    @Override
    public String toString() {
        return machine.toString() + " -> " +  ip.toString();
    }
}
