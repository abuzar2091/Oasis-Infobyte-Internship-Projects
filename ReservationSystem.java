import java.util.*;

public class ReservationSystem {

    private HashMap<String, List<Reservation>> reservations;

    public ReservationSystem() {
        this.reservations = new HashMap<>();
    }

    public void addReservation(String customerId, Reservation reservation) {
        if (!reservations.containsKey(customerId)) {
            reservations.put(customerId, new ArrayList<>());
        }
        reservations.get(customerId).add(reservation);
    }

    public List<Reservation> getReservations(String customerId) {
        return reservations.get(customerId);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ReservationSystem reservationSystem = new ReservationSystem();

        while (true) {
            System.out.println("Welcome to the online reservation system. What would you like to do?");
            System.out.println("1. Make a reservation");
            System.out.println("2. View your reservations");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter your customer ID: ");
                    String customerId = scanner.next();

                    System.out.println("Enter the date of your reservation: ");
                    String date = scanner.next();

                    System.out.println("Enter the time of your reservation: ");
                    String time = scanner.next();

                    Reservation reservation = new Reservation(customerId, date, time);
                    reservationSystem.addReservation(customerId, reservation);
                    System.out.println("Reservation successful.");
                    break;
                case 2:
                    System.out.println("Enter your customer ID: ");
                    customerId = scanner.next();

                    List<Reservation> reservations = reservationSystem.getReservations(customerId);
                    if (reservations != null) {
                        for (Reservation reservation : reservations) {
                            System.out.println(reservation);
                        }
                    } else {
                        System.out.println("You do not have any reservations.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the online reservation system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
