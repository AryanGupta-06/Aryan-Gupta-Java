package Java_collections_worksheet_1;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Task {
    String name;
    int priority;
    Date deadline;

    public Task(String name, int priority, String deadline) throws ParseException {
        this.name = name;
        this.priority = priority;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.deadline = sdf.parse(deadline);
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", deadline=" + deadline + '}';
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.deadline.equals(t2.deadline)) {
            return Integer.compare(t2.priority, t1.priority); // Higher priority first
        }
        return t1.deadline.compareTo(t2.deadline); // Closest deadline first
    }
}

public class Q4_Task_Prioritization_Engine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Task> taskQueue = new PriorityQueue<>(new TaskComparator());

        System.out.println("Enter the number of tasks:");
        int numberOfTasks = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfTasks; i++) {
            try {
                System.out.println("Enter task name:");
                String name = scanner.nextLine();
                System.out.println("Enter task priority:");
                int priority = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println("Enter task deadline (yyyy-MM-dd):");
                String deadline = scanner.nextLine();

                taskQueue.add(new Task(name, priority, deadline));
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
                i--; // Retry the current task input
            }
        }

        System.out.println("Tasks in order of execution:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }

        scanner.close();
    }
}
