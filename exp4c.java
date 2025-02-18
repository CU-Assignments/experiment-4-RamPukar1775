import java.util.ArrayList;
import java.util.List;

class TicketBookingSystem {
    private List<Integer> availableSeats;

    public TicketBookingSystem(int totalSeats) {
        availableSeats = new ArrayList<>();
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }

    public synchronized boolean bookSeat(String customerType) {
        if (!availableSeats.isEmpty()) {
            int seat = availableSeats.remove(0);
            System.out.println(customerType + " booked seat number: " + seat);
            return true;
        } else {
            System.out.println(customerType + " tried to book a seat, but none are available.");
            return false;
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private String customerType;

    public BookingThread(TicketBookingSystem bookingSystem, String customerType, int priority) {
        this.bookingSystem = bookingSystem;
        this.customerType = customerType;
        setPriority(priority);
    }

    @Override
    public void run() {
        bookingSystem.bookSeat(customerType);
    }
}

public class exp4c {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5);

        BookingThread vip1 = new BookingThread(bookingSystem, "VIP Customer 1", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(bookingSystem, "VIP Customer 2", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(bookingSystem, "Regular Customer 1", Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(bookingSystem, "Regular Customer 2", Thread.NORM_PRIORITY);
        BookingThread regular3 = new BookingThread(bookingSystem, "Regular Customer 3", Thread.NORM_PRIORITY);
        BookingThread regular4 = new BookingThread(bookingSystem, "Regular Customer 4", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
        regular4.start();
    }
}
