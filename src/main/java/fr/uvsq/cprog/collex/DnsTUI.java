package fr.uvsq.cprog.collex;

import java.util.Scanner;

public class DnsTUI {
    public static Executor nextCommand() {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine().strip();
        if (command.equals("exit")) {
            return new Executor(new StopCommand());
        }
        else if (command.startsWith("add ")) {
            String[] parts =  command.split(" ");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Wrong command format");
            }
            else {
                return new Executor(new AddItemCommand(parts[1], parts[2]));
            }
        }
        else if (command.startsWith("ls ")) {
            String[] parts =  command.split(" ");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Wrong command format");
            }
            else {
                return new Executor(new FetchNamesCommand(new NomMachine(parts[1])));
            }
        }
        else {
            try {
                return new Executor(new FetchNameCommand(new AdresseIP(command)));
            }
            catch (IllegalArgumentException e) {
                try {
                    return new Executor(new FetchIpCommand(new NomMachine(command)));
                }
                catch (IllegalArgumentException ex) {
                    throw new IllegalArgumentException("Wrong command format");
                }
            }
        }
    }
}
