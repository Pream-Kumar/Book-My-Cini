from datetime import datetime

# User class
class User:
    def __init__(self, user_id, name, email, phone_number, password):
        self.user_id = user_id
        self.name = name
        self.email = email
        self.phone_number = phone_number
        self.password = password
        self.created_at = datetime.now()

# Movie class
class Movie:
    def __init__(self, movie_id, title, genre, release_date, duration, rating, language, description):
        self.movie_id = movie_id
        self.title = title
        self.genre = genre
        self.release_date = release_date
        self.duration = duration  # in minutes
        self.rating = rating
        self.language = language
        self.description = description

# Theater class
class Theater:
    def __init__(self, theater_id, name, location, number_of_screens):
        self.theater_id = theater_id
        self.name = name
        self.location = location
        self.number_of_screens = number_of_screens

# Screen class
class Screen:
    def __init__(self, screen_id, theater_id, screen_number, capacity):
        self.screen_id = screen_id
        self.theater_id = theater_id  # Foreign Key to Theater
        self.screen_number = screen_number
        self.capacity = capacity

# Seat class
class Seat:
    def __init__(self, seat_id, screen_id, seat_number, seat_type, price):
        self.seat_id = seat_id
        self.screen_id = screen_id  # Foreign Key to Screen
        self.seat_number = seat_number
        self.seat_type = seat_type  # Standard, VIP, etc.
        self.price = price

# Showtime class
class Showtime:
    def __init__(self, showtime_id, movie_id, screen_id, start_time, end_time):
        self.showtime_id = showtime_id
        self.movie_id = movie_id  # Foreign Key to Movie
        self.screen_id = screen_id  # Foreign Key to Screen
        self.start_time = start_time
        self.end_time = end_time

# Booking class
class Booking:
    def __init__(self, booking_id, user_id, showtime_id, booking_date, total_price):
        self.booking_id = booking_id
        self.user_id = user_id  # Foreign Key to User
        self.showtime_id = showtime_id  # Foreign Key to Showtime
        self.booking_date = booking_date
        self.total_price = total_price

# BookedSeat class
class BookedSeat:
    def __init__(self, booking_id, seat_id):
        self.booking_id = booking_id  # Foreign Key to Booking
        self.seat_id = seat_id  # Foreign Key to Seat

# Payment class
class Payment:
    def __init__(self, payment_id, booking_id, amount_paid, payment_method, payment_status):
        self.payment_id = payment_id
        self.booking_id = booking_id  # Foreign Key to Booking
        self.amount_paid = amount_paid
        self.payment_method = payment_method  # e.g. Credit Card, PayPal, etc.
        self.payment_status = payment_status  # e.g. Success, Pending, Failed
        self.payment_date = datetime.now()
