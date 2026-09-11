public class TicketDirector {

    // Директор собирает премиум-билет по стандартному сценарию
    public MovieTicket constructVIPPackage(TicketBuilder builder, String movieTitle) {
        return builder.setMovieTitle(movieTitle)
                .setHallNumber("Hall 1 (IMAX)")
                .setShowTime("20:00")
                .setSeatType("VIP Recliner")
                .setPopcorn(true)
                .setDrink(true)
                .build();
    }
}