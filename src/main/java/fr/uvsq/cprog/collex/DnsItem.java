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

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DnsItem other) {
            return this.ip.equals(other.ip) && this.machine.equals(other.machine);
        }
        return false;
    }
}
