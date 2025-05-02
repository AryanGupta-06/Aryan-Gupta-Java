package Java_collections_worksheet_1;

import java.util.*;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Manager {
    String name;

    Manager(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Q8_Employee_Hierarchy_System {
    private Map<Manager, TreeMap<Integer, List<Person>>> hierarchy;

    public Q8_Employee_Hierarchy_System() {
        hierarchy = new HashMap<>();
    }

    public void addPerson(Manager manager, int level, Person person) {
        hierarchy.putIfAbsent(manager, new TreeMap<>());
        TreeMap<Integer, List<Person>> levels = hierarchy.get(manager);
        levels.putIfAbsent(level, new ArrayList<>());
        levels.get(level).add(person);
    }

    public void printHierarchy() {
        for (Map.Entry<Manager, TreeMap<Integer, List<Person>>> entry : hierarchy.entrySet()) {
            Manager manager = entry.getKey();
            TreeMap<Integer, List<Person>> levels = entry.getValue();
            System.out.println("Manager: " + manager);
            for (Map.Entry<Integer, List<Person>> levelEntry : levels.entrySet()) {
                int level = levelEntry.getKey();
                List<Person> persons = levelEntry.getValue();
                System.out.println("  Level " + level + ": " + persons);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Q8_Employee_Hierarchy_System hierarchySystem = new Q8_Employee_Hierarchy_System();

        System.out.println("Enter the number of managers:");
        int numManagers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numManagers; i++) {
            System.out.println("Enter manager name:");
            String managerName = scanner.nextLine();
            Manager manager = new Manager(managerName);

            System.out.println("Enter the number of levels for manager " + managerName + ":");
            int numLevels = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int j = 0; j < numLevels; j++) {
                System.out.println("Enter level number:");
                int level = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter the number of persons at level " + level + ":");
                int numPersons = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                for (int k = 0; k < numPersons; k++) {
                    System.out.println("Enter person name:");
                    String personName = scanner.nextLine();
                    Person person = new Person(personName);
                    hierarchySystem.addPerson(manager, level, person);
                }
            }
        }

        System.out.println("\nHierarchy:");
        hierarchySystem.printHierarchy();
    }
}
