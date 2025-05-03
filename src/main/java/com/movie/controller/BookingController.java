//package com.movie.controller;
//
//import com.movie.dto.BookingRequestDto;
//import com.movie.dto.PaymentRequestDto;
//import com.movie.model.BookingModel;
//import com.movie.service.BookingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/bookings")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping("/createBooking")
//    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDto bookingRequest){
//        return ResponseEntity.ok(bookingService.createBooking(bookingRequest));
//    }
//
//    @GetMapping("/getBookingById/{id}")
//    public ResponseEntity<BookingModel> getBookingById(@PathVariable Long id) {
//        return ResponseEntity.ok(bookingService.getBookingById(id));
//    }
//
//    @PreAuthorize("hasRole('ADMIN')")
//    @GetMapping("/getAllBookings")
//    public ResponseEntity<List<BookingModel>> getAllBookings() {
//        return ResponseEntity.ok(bookingService.getAllBookings());
//    }
//
//    @DeleteMapping("/cancelBookingById/{id}")
//    public ResponseEntity<?> cancelBooking(@PathVariable Long id) {
//        bookingService.cancelBooking(id);
//        return ResponseEntity.ok("Booking cancelled successfully.");
//    }
//
//    @GetMapping("/getUserBookings/{userId}")
//    public ResponseEntity<List<BookingModel>> getUserBookings(@PathVariable Long userId) {
//        return ResponseEntity.ok(bookingService.getBookingsByUser(userId));
//    }
//
//    @PreAuthorize("hasAnyRole('THEATER_ADMIN', 'ADMIN')")
//    @GetMapping("/showtime/{showtimeId}")
//    public ResponseEntity<List<BookingModel>> getBookingsByShowtime(@PathVariable Long showtimeId) {
//        return ResponseEntity.ok(bookingService.getBookingsByShowtime(showtimeId));
//    }
//
//    @PostMapping("/{id}/payment")
//    public ResponseEntity<?> makePayment(@PathVariable Long id, @RequestBody PaymentRequestDto paymentRequest) {
//        return ResponseEntity.ok(bookingService.makePayment(id, paymentRequest));
//    }
//
//}
