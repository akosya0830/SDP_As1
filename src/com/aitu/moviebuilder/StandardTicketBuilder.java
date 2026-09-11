package com.aitu.moviebuilder;

public class StandardTicketBuilder implements TicketBuilder {
    private String movieTitle;
    private String hallNumber;
    private String showTime;
    private String seatType = "Standard"; // дефолтное значение
    private boolean includePopcorn = false;
    private boolean includeDrink = false;

    @Override
    public TicketBuilder setMovieTitle(String title) {
        this.movieTitle = title;
        return this; // Возвращаем this для method chaining
    }

    @Override
    public TicketBuilder setHallNumber(String hall) {
        this.hallNumber = hall;
        return this;
    }

    @Override
    public TicketBuilder setShowTime(String time) {
        this.showTime = time;
        return this;
    }

    @Override
    public TicketBuilder setSeatType(String seat) {
        this.seatType = seat;
        return this;
    }

    @Override
    public TicketBuilder setPopcorn(boolean popcorn) {
        this.includePopcorn = popcorn;
        return this;
    }

    @Override
    public TicketBuilder setDrink(boolean drink) {
        this.includeDrink = drink;
        return this;
    }

    @Override
    public MovieTicket build() {
        // Простая валидация (Clean Code: Validated construction)
        if (movieTitle == null || movieTitle.isEmpty()) {
            throw new IllegalStateException("Movie title cannot be empty!");
        }
        return new MovieTicket(movieTitle, hallNumber, showTime, seatType, includePopcorn, includeDrink);
    }
}