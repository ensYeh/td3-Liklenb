package fr.uvsq.cprog.collex;

import java.util.Objects;

public class NomMachine {
    final String name;

    public NomMachine(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        String[] parts = name.split("\\.");
        if (parts.length < 2) {
            throw new IllegalArgumentException("name must have at least 2 parts");
        }
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof NomMachine) {
            return Objects.equals(name, ((NomMachine) obj).name);
        }
        else return false;
    }
}
