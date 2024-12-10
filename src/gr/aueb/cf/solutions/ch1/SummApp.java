package gr.aueb.cf.solutions.ch1;

/**
 * Πρώτον: Δηλώνει δύο μεταβλητές ακεραίων num1 και num2
 * και τις αρχικοποιεί στις τιμές 19 και 30 αντίστοιχα.
 * Δεύτερον: Υπολογίζει το άθροισμα num1 + num2 και το
 * αποθηκεύει στη μεταβλητή sum. Και, Τρίτον: εκτυπώνει
 * το εξής κείμενο: Το αποτέλεσμα της πρόσθεσης είναι
 * ίσο με [το αποτέλεσμα της πρόσθεσης]. Αναμενόμενη τιμή
 * είναι το 49.
 */
public class SummApp {

    public static void main(String[] args) {
        int num1 = 19;
        int num2 = 30;
        int sum = 0;

        sum = num1 + num2;

        System.out.println("Το αποτέλεσμα της πρόσθεσης είναι ίσο με " + sum);
    }
}