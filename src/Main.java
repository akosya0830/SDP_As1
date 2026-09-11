public class Main {
    public static void main(String[] args) {
        // Создаем директора
        TicketDirector director = new TicketDirector();

        // Создаем билдер
        TicketBuilder builder = new StandardTicketBuilder();

        // Директор оркестрирует создание VIP билета
        MovieTicket vipTicket = director.constructVIPPackage(builder, "Interstellar");
        System.out.println("Generated via Director: " + vipTicket);

        // Клиент может создавать объект напрямую через method chaining (Fluent API)
        MovieTicket customTicket = new StandardTicketBuilder()
                .setMovieTitle("Avatar 2")
                .setHallNumber("Hall 3")
                .setShowTime("15:30")
                .setSeatType("Balcony")
                .setPopcorn(true)
                .setDrink(false)
                .build();

        System.out.println("Generated via Fluent API: " + customTicket);
    }
}