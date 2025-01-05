package gr.aueb.cf.solutions.projects;

public class Theater {

    private static final int ROWS = 30;
    private static final int COLUMNS = 12;
    private boolean[][] seats = new boolean[ROWS][COLUMNS]; // πίνακας κρατήσεων

    public static void main(String[] args) {
        Theater theater = new Theater();
        theater.book('C', 2);
        theater.book('C', 2); // προσπάθεια να κλείσουμε ξανά την ίδια θέση
        theater.cancel('C', 2);
        theater.cancel('C', 2); // προσπάθεια να ακυρώσουμε κράτηση που ήδη δεν υπάρχει
    }

    // Μέθοδος για την κράτηση μιας θέσης
    public void book(char column, int row) {
        int colIndex = columnToIndex(column);  // Μετατροπή γράμματος στήλης σε δείκτη
        int rowIndex = row - 1;  // Μετατροπή αριθμού σειράς σε δείκτη (0-based)

        if (isValidPosition(colIndex, rowIndex)) {
            if (!seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = true;
                System.out.println("Position " + column + row + " has been booked.");
            } else {
                System.out.println("Position " + column + row + " is already booked.");
            }
        } else {
            System.out.println("Invalid position: " + column + row);
        }
    }

    // Μέθοδος για την ακύρωση κράτησης μιας θέσης
    public void cancel(char column, int row) {
        int colIndex = columnToIndex(column);  // Μετατροπή γράμματος στήλης σε δείκτη
        int rowIndex = row - 1;  // Μετατροπή αριθμού σειράς σε δείκτη (0-based)

        if (isValidPosition(colIndex, rowIndex)) {
            if (seats[rowIndex][colIndex]) {
                seats[rowIndex][colIndex] = false;
                System.out.println("Booking for position " + column + row + " has been cancelled.");
            } else {
                System.out.println("No booking exists for position " + column + row + ".");
            }
        } else {
            System.out.println("Invalid position: " + column + row);
        }
    }

    // Μετατροπή από γράμμα σε δείκτη στήλης
    private int columnToIndex(char column) {
        return column - 'A';
    }

    // Έλεγχος αν η θέση είναι έγκυρη
    private boolean isValidPosition(int colIndex, int rowIndex) {
        return colIndex >= 0 && colIndex < COLUMNS && rowIndex >= 0 && rowIndex < ROWS;
    }
}