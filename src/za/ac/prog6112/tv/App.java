package za.ac.prog6112.tv;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Series manager = new Series();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== TV SERIES MANAGER ===");
            System.out.println("1. Capture a new Series");
            System.out.println("2. Search for a Series");
            System.out.println("3. Update a Series");
            System.out.println("4. Delete a Series");
            System.out.println("5. View Series Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.CaptureSeries();
                    break;
                case "2":
                    System.out.print("Enter Series ID to search: ");
                    String searchId = scanner.nextLine();
                    SeriesModel found = manager.SearchSeries(searchId);
                    if (found != null) {
                        System.out.println("Series Found!");
                        System.out.println("ID: " + found.SeriesId);
                        System.out.println("Name: " + found.SeriesName);
                        System.out.println("Age Restriction: " + found.SeriesAge);
                        System.out.println("Episodes: " + found.SeriesNumberOfEpisodes + "\n");
                    } else {
                        System.out.println("No series found with that ID.\n");
                    }
                    break;
                case "3":
                    System.out.print("Enter Series ID to update: ");
                    String updateId = scanner.nextLine();
                    manager.UpdateSeries(updateId);
                    break;
                case "4":
                    System.out.print("Enter Series ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.DeleteSeries(deleteId);
                    break;
                case "5":
                    manager.SeriesReport();
                    break;
                case "6":
                    manager.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.\n");
            }
        }
    }
}
