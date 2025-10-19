package fr.uvsq.cprog.collex;

public class AdresseIP {
    final String address;

    public AdresseIP(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("address must not be null or empty");
        }
        String[] parts = address.split("\\.");
        if (parts.length != 4) {
            throw new IllegalArgumentException("address must have 4 parts");
        }
        for (int i = 0; i < parts.length; i++) {
            int x;
            try {
                x = Integer.parseInt(parts[i]);
            }
            catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid IP address format: " + address);
            }
            if (x > 255 || x < 0) {
                throw new IllegalArgumentException("Invalid IP address format: " + address);
            }
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof AdresseIP) return address.equals(((AdresseIP) o).address);
        else return false;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }
}
