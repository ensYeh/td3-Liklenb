package fr.uvsq.cprog.collex;

public class NomMachine {
    final String name;

    public NomMachine(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        String[] parts = name.split("\\.");
        if (parts.length != 3) {
            throw new IllegalArgumentException("name must have 3 parts");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
