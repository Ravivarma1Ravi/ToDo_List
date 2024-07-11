import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    private static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Todo List Application");
            System.out.println("1. View Todo List");
            System.out.println("2. Add Task");
            System.out.println("3. Remove Task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    viewTodoList();
                    break;
                case 2:
                    addTask(scanner);
                    break;
                case 3:
                    removeTask(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewTodoList() {
        if (todoList.isEmpty()) {
            System.out.println("Todo list is empty.");
        } else {
            System.out.println("Todo List:");
            for (int i = 0; i < todoList.size(); i++) {
                System.out.println((i + 1) + ". " + todoList.get(i));
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter task description: ");
        String task = scanner.nextLine();
        todoList.add(task);
        System.out.println("Task added.");
    }

    private static void removeTask(Scanner scanner) {
        viewTodoList();
        if (!todoList.isEmpty()) {
            System.out.print("Enter task number to remove: ");
            int taskNumber = scanner.nextInt();
            if (taskNumber > 0 && taskNumber <= todoList.size()) {
                todoList.remove(taskNumber - 1);
                System.out.println("Task removed.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}
