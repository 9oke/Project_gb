import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {
    private List<Animal> animals;

    public AnimalRegistry() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to the registry.");
    }

    public void listAnimalsByBirthDate() {
        animals.sort((a, b) -> a.getBirthDate().compareTo(b.getBirthDate()));
        for (Animal animal : animals) {
            System.out.println(animal.getName() + " (" + animal.getType() + ") - Born on " + animal.getBirthDate());
        }
    }

    public void findAnimalCommands(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.printCommands();
                return;
            }
        }
        System.out.println("Animal with name " + name + " not found.");
    }

    public void teachAnimalCommand(String name, String command) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                animal.learnCommand(command);
                System.out.println(name + " has learned a new command: " + command);
                return;
            }
        }
        System.out.println("Animal with name " + name + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry registry = new AnimalRegistry();

        while (true) {
            System.out.println("\nAnimal Registry Menu:");
            System.out.println("1. Add Animal");
            System.out.println("2. List Animals by Birth Date");
            System.out.println("3. Find Animal Commands");
            System.out.println("4. Teach Animal a New Command");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter type (Pet/Pack Animal): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter birth date (YYYY-MM-DD): ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Enter commands (comma-separated): ");
                    String[] commands = scanner.nextLine().split(",");

                    Animal animal;
                    if (type.equalsIgnoreCase("Pet")) {
                        animal = new Pet(name, type, birthDate, commands);
                    } else {
                        animal = new PackAnimal(name, type, birthDate, commands);
                    }

                    registry.addAnimal(animal);
                    break;

                case 2:
                    registry.listAnimalsByBirthDate();
                    break;

                case 3:
                    System.out.print("Enter animal name: ");
                    String searchName = scanner.nextLine();
                    registry.findAnimalCommands(searchName);
                    break;

                case 4:
                    System.out.print("Enter animal name: ");
                    String teachName = scanner.nextLine();
                    System.out.print("Enter new command: ");
                    String newCommand = scanner.nextLine();
                    registry.teachAnimalCommand(teachName, newCommand);
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}

