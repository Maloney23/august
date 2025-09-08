package prog.series;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Series manager = new Series();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("=== TV Series Management ===");
            System.out.println("1. Capture new TV series");
            System.out.println("2. Search series");
            System.out.println("3. Update series");
            System.out.println("4. Delete series");
            System.out.println("5. View report");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Age (2-18): "); String age = sc.nextLine();
                    System.out.print("Episodes: "); String eps = sc.nextLine();
                    if (manager.captureSeries(id, name, age, eps))
                        System.out.println("Series saved.");
                    else System.out.println("Invalid input. Try again.");
                    break;
                case "2":
                    System.out.print("Enter ID: "); id = sc.nextLine();
                    manager.searchSeries(id).ifPresentOrElse(
                        s -> System.out.println(s),
                        () -> System.out.println("Series not found.")
                    );
                    break;
                case "3":
                    System.out.print("Enter ID to update: "); id = sc.nextLine();
                    System.out.print("New name: "); name = sc.nextLine();
                    System.out.print("New age: "); age = sc.nextLine();
                    System.out.print("New episodes: "); eps = sc.nextLine();
                    if (manager.updateSeries(id, name, age, eps))
                        System.out.println("Updated successfully.");
                    else System.out.println("Update failed.");
                    break;
                case "4":
                    System.out.print("Enter ID to delete: "); id = sc.nextLine();
                    if (manager.deleteSeries(id))
                        System.out.println("Deleted successfully.");
                    else System.out.println("Series not found.");
                    break;
                case "5":
                    System.out.println(manager.seriesReport());
                    break;
                case "6":
                    manager.exitSeriesApplication();
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            System.out.println();
        }
        sc.close();
    }
}
