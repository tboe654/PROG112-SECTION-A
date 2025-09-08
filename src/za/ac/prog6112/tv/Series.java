package za.ac.prog6112.tv;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Capture new series
    public void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        String age;
        while (true) {
            System.out.print("Enter Age Restriction (2-18): ");
            age = scanner.nextLine();
            if (isValidAge(age)) {
                break;
            } else {
                System.out.println("Invalid age. Please enter a number between 2 and 18.");
            }
        }

        String episodes;
        while (true) {
            System.out.print("Enter Number of Episodes: ");
            episodes = scanner.nextLine();
            if (isPositiveInteger(episodes)) {
                break;
            } else {
                System.out.println("Invalid number. Please enter a positive number.");
            }
        }

        seriesList.add(new SeriesModel(id, name, age, episodes));
        System.out.println("Series successfully saved!\n");
    }

    // Search for a series
    public SeriesModel SearchSeries(String id) {
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }

    // Update series
    public boolean UpdateSeries(String id) {
        SeriesModel s = SearchSeries(id);
        if (s != null) {
            System.out.print("Enter new Series Name: ");
            s.SeriesName = scanner.nextLine();

            while (true) {
                System.out.print("Enter new Age Restriction (2-18): ");
                String newAge = scanner.nextLine();
                if (isValidAge(newAge)) {
                    s.SeriesAge = newAge;
                    break;
                } else {
                    System.out.println("Invalid age. Try again.");
                }
            }

            while (true) {
                System.out.print("Enter new Number of Episodes: ");
                String newEp = scanner.nextLine();
                if (isPositiveInteger(newEp)) {
                    s.SeriesNumberOfEpisodes = newEp;
                    break;
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            }

            System.out.println("Series updated successfully!\n");
            return true;
        } else {
            System.out.println("Series not found.\n");
            return false;
        }
    }

    // Delete series
    public boolean DeleteSeries(String id) {
        SeriesModel s = SearchSeries(id);
        if (s != null) {
            System.out.print("Are you sure you want to delete this series? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                seriesList.remove(s);
                System.out.println("Series deleted successfully!\n");
                return true;
            }
        }
        System.out.println("Series not found or not deleted.\n");
        return false;
    }

    // Show report
    public void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series available.\n");
            return;
        }

        System.out.println("===== SERIES REPORT =====");
        for (SeriesModel s : seriesList) {
            System.out.println("ID: " + s.SeriesId);
            System.out.println("Name: " + s.SeriesName);
            System.out.println("Age Restriction: " + s.SeriesAge);
            System.out.println("Episodes: " + s.SeriesNumberOfEpisodes);
            System.out.println("-------------------------");
        }
    }

    // Exit app
    public void ExitSeriesApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }

    // Validation helpers
    public boolean isValidAge(String age) {
        try {
            int a = Integer.parseInt(age);
            return a >= 2 && a <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isPositiveInteger(String value) {
        try {
            int num = Integer.parseInt(value);
            return num > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

