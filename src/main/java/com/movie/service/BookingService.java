//package com.movie.service;
//
//import com.movie.dto.BookingRequestDto;
//import com.movie.dto.PaymentRequestDto;
//import com.movie.model.BookingModel;
//import com.movie.model.Seat;
//import com.movie.model.Showtime;
//import com.movie.model.User;
//import com.movie.repository.BookingRepository;
//import com.movie.repository.SeatRepository;
//import com.movie.repository.ShowtimeRepository;
//import com.movie.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private SeatRepository seatRepository;
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private ShowtimeRepository showtimeRepository;
//
//    public Object createBooking(BookingRequestDto bookingRequest) {
//        User user = userRepository.findById(bookingRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
//        Showtime showtime = showtimeRepository.findById(bookingRequest.getShowtimeId()).orElseThrow(() -> new RuntimeException("Showtime not found"));
//
//        List<Seat> selectedSeats = seatRepository.findByScreen_ScreenIdAndIsBookedFalse(bookingRequest.getSeatIds());
//        if (selectedSeats.size() != bookingRequest.getSeatIds().size()) {
//            throw new RuntimeException("Some seats are already booked.");
//        }
//
//        double totalPrice = selectedSeats.stream().mapToDouble(Seat::getPrice).sum();
//
//        BookingModel booking = new BookingModel();
//        booking.setUser(user);
//        booking.setShowtime(showtime);
//        booking.setBookingDate(LocalDateTime.now());
//        booking.setTotalPrice(totalPrice);
//        booking.setBookedSeats(new ArrayList<>());
//
//        booking = bookingRepository.save(booking);
//
//        // Mark seats as booked
//        for (Seat seat : selectedSeats) {
//            seat.setBooked(true);
//            seatRepository.save(seat);
//        }
//
//        return booking;
//    }
//
//    public BookingModel getBookingById(Long id) {
//        return null;
//    }
//
//    public List<BookingModel> getAllBookings() {
//        return null;
//    }
//
//    public void cancelBooking(Long id) {
//    }
//
//    public List<BookingModel> getBookingsByUser(Long userId) {
//        return null;
//    }
//
//    public List<BookingModel> getBookingsByShowtime(Long showtimeId) {
//        return null;
//    }
//
//    public Object makePayment(Long id, PaymentRequestDto paymentRequest) {
//        return null;
//    }
//}
