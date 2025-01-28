public class Animal {
    private String name;
    private String type;
    private String birthDate;
    private String[] commands;

    public Animal(String name, String type, String birthDate, String[] commands) {
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String[] getCommands() {
        return commands;
    }

    public void learnCommand(String command) {
        String[] newCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, newCommands, 0, commands.length);
        newCommands[commands.length] = command;
        commands = newCommands;
    }

    public void printCommands() {
        System.out.println(name + " knows the commands: ");
        for (String command : commands) {
            System.out.println("- " + command);
        }
    }
}
