public class MovieTicket {
    private String movieTitle;
    private String hallNumber;
    private String showTime;
    private String seatType; // VIP, Standard, Balcony
    private boolean includePopcorn;
    private boolean includeDrink;

    // Конструктор принимает построенные параметры
    public MovieTicket(String movieTitle, String hallNumber, String showTime,
                       String seatType, boolean includePopcorn, boolean includeDrink) {
        this.movieTitle = movieTitle;
        this.hallNumber = hallNumber;
        this.showTime = showTime;
        this.seatType = seatType;
        this.includePopcorn = includePopcorn;
        this.includeDrink = includeDrink;
    }

    @Override
    public String toString() {
        return "MovieTicket [Movie: " + movieTitle +
                ", Hall: " + hallNumber +
                ", Time: " + showTime +
                ", Seat: " + seatType +
                ", Popcorn: " + includePopcorn +
                ", Drink: " + includeDrink + "]";
    }
}
