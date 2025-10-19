package fr.uvsq.cprog.collex;

public class Executor {
    private final Command command;

    public Executor(Command command) {
        this.command = command;
    }

    public String affiche() {
        String result = command.execute();
        System.out.print(result);
        return result;
    }
}
