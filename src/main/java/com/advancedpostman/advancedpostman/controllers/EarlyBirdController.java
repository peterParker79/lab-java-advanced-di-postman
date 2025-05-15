package com.advancedpostman.advancedpostman.controllers;

import com.advancedpostman.advancedpostman.RequestDTO;
import com.advancedpostman.advancedpostman.services.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@RestController
@RequestMapping("/api")


public class EarlyBirdController {
    private final EarlyBirdDiscountService earlyBirdDiscountService;

    //En el constructor inyecto la dependencia si es necesario
    public EarlyBirdController (@Autowired(required = false) EarlyBirdDiscountService discountService) {
        this.earlyBirdDiscountService = discountService;
    }


    @GetMapping("/discount")
    public String getDiscount(@RequestParam String eventDate, @RequestParam String bookingDate) {
        if (earlyBirdDiscountService != null) {
            return "Discount Service is stop";
        }

        try {
            LocalDate event = LocalDate.parse(eventDate);
            LocalDate booking = LocalDate.parse(bookingDate);
        } catch (DateTimeParseException e) {
            return "Incorrect date. Format date AAAA-MM-DD";
        }
        return "Discount Service is running right now!!";
    }
}
