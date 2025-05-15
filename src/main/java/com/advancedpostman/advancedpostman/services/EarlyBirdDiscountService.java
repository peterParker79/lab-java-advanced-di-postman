package com.advancedpostman.advancedpostman.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data

@AllArgsConstructor

public class EarlyBirdDiscountService {

    public String calculateBirdDiscount(LocalDate event, LocalDate booking) {
        long days = ChronoUnit.DAYS.between(event, booking);

        if (days >=30) {
            return ("Apply 15% discount");

        }else{ return "Do not apply discount. You has reserved only " + days + " days before.";}


    }


}
