public interface TicketBuilder {
    TicketBuilder setMovieTitle(String title);
    TicketBuilder setHallNumber(String hall);
    TicketBuilder setShowTime(String time);
    TicketBuilder setSeatType(String seat);
    TicketBuilder setPopcorn(boolean popcorn);
    TicketBuilder setDrink(boolean drink);
    MovieTicket build();
}
