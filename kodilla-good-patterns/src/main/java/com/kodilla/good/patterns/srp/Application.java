package com.kodilla.good.patterns.srp;

public class Application {

    public static void main(String[] args) {
        RentRequestRetriever rentRequestRetriever = new RentRequestRetriever(); //info retrieval
        RentRequest rentRequest = rentRequestRetriever.retrieve(); //implementation of the rent process

        //sending email, renting, sending info to database
        RentalProcessor rentalProcessor = new RentalProcessor(new MailService(), new CarRentalService(), new CarRentalRepository());
        rentalProcessor.process(rentRequest);
    }
}
