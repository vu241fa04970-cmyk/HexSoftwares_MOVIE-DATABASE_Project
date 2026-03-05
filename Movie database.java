import java.util.ArrayList;
import java.util.Scanner;

// Movie class
class Movie {
    String title;
    String director;
    int year;
    String genre;

    // Constructor
    Movie(String title, String director, int year, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    // Display movie details
    void display() {
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year: " + year);
        System.out.println("Genre: " + genre);
        System.out.println("---------------------------");
    }
}

// Main class
public class MovieDatabase {

    public static void main(String[] args) {

        ArrayList<Movie> movies = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMovie Database Menu");
            System.out.println("1. Add Movie");
            System.out.println("2. Search Movie");
            System.out.println("3. Display All Movies");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter movie title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter director name: ");
                    String director = sc.nextLine();

                    System.out.print("Enter release year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();

                    movies.add(new Movie(title, director, year, genre));
                    System.out.println("Movie added successfully!");
                    break;

                case 2:
                    System.out.print("Enter movie title to search: ");
                    String searchTitle = sc.nextLine();
                    boolean found = false;

                    for (Movie m : movies) {
                        if (m.title.equalsIgnoreCase(searchTitle)) {
                            m.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Movie not found!");
                    }
                    break;

                case 3:
                    if (movies.isEmpty()) {
                        System.out.println("No movies in database.");
                    } else {
                        for (Movie m : movies) {
                            m.display();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}