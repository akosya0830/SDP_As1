package com.aitu.moviebuilder;

public class Main {
    public static void main(String[] args) {

        // 1) Через Director — готовый, известный сценарий (VIP-пакет)
        TicketDirector director = new TicketDirector();
        MovieTicket vipTicket = director.constructVIPPackage(new StandardTicketBuilder(), "Dune: Part Two");
        System.out.println(vipTicket);

        // 2) Вручную через Builder — кастомный, разовый билет
        MovieTicket standardTicket = new StandardTicketBuilder()
                .setMovieTitle("Avatar 3")
                .setHallNumber("Hall 2")
                .setShowTime("18:30")
                .setSeatType("Standard")
                .setPopcorn(false)
                .setDrink(true)
                .build();
        System.out.println(standardTicket);

        // 3) Проверка валидации build() — обязательное поле не задано
        try {
            new StandardTicketBuilder()
                    .setHallNumber("Hall 3")
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}