package com.advancedpostman.advancedpostman.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class EarlyBirdDiscountService {
    boolean applyDiscount = false;

    public String calculateBirdDiscount(LocalDate event, LocalDate booking) {
        long days = ChronoUnit.DAYS.between(booking, event);
        if (days >= 30) {
            applyDiscount = true;
            return "Yo has been applied to the early Bird Discount 15%.";
        }
        return "You have not been applied any Discount, Sorry!!";
    }
}

