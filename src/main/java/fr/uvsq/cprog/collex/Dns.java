package fr.uvsq.cprog.collex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Dns {
    private final HashMap<AdresseIP, DnsItem> dnsItemsFromIp = new HashMap<>();
    private final HashMap<NomMachine, DnsItem> dnsItemsFromName = new HashMap<>();

    public Dns() {
        Path databasePath = Path.of("database.data");
        File  databaseFile = databasePath.toFile();
        try {
            databaseFile.createNewFile();
            Scanner reader = new Scanner(databaseFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] dataSplit = data.split(" ");
                DnsItem item = new DnsItem(new NomMachine(dataSplit[0]), new AdresseIP(dataSplit[1]));
                dnsItemsFromName.put(new NomMachine(dataSplit[0]), item);
                dnsItemsFromIp.put(new AdresseIP(dataSplit[1]), item);
            }
        }
        catch (IOException e) {
            System.err.println("Erreur de chargement de la base de données.");
        }
    }

    private void save() {
        Path databasePath = Path.of("database.data");
        File  databaseFile = databasePath.toFile();
        try {
            FileWriter writer = new FileWriter(databaseFile);
            for (DnsItem item : dnsItemsFromName.values()) {
                writer.write(item.machine.toString() + " " + item.ip + "\n");
            }
            writer.close();
        }
        catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde de la base de données.");
        }
    }

    public DnsItem getItem(NomMachine machine) {
        return dnsItemsFromName.get(machine);
    }
    public DnsItem getItem(AdresseIP ip) {
        return dnsItemsFromIp.get(ip);
    }

    public DnsItem[] getItems(NomMachine name) {
        List<DnsItem> items = new ArrayList<>();
        for (NomMachine subName : dnsItemsFromName.keySet()) {
            if (subName.name.endsWith(name.name)) {
                items.add(dnsItemsFromName.get(subName));
            }
        }
        return items.toArray(new DnsItem[0]);
    }

    public void addItem(NomMachine machine, AdresseIP ip) {
        if (dnsItemsFromName.containsKey(machine)) {
            throw new IllegalArgumentException("ERREUR : Le nom de machine " + machine + " existe déjà !");
        }
        dnsItemsFromIp.put(ip, new DnsItem(machine, ip));
        dnsItemsFromName.put(machine, new DnsItem(machine, ip));
        save();
    }
}
