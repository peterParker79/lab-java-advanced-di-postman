package com.advancedpostman.advancedpostman.controllers;

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

    //En el constructor con el servicio como param
    //Este servicio no siempre está disponible, su bean se activa en el properties
    //Inyección permite que esté o no esté presente. @Autowired(required = false)
    public EarlyBirdController(@Autowired(required = false) EarlyBirdDiscountService discountService) {
        this.earlyBirdDiscountService = discountService;
    }


    @GetMapping("/discount")
    public String getDiscount(@RequestParam String eventDate, @RequestParam String bookingDate) {
        if (earlyBirdDiscountService != null) {
            try {
                LocalDate event = LocalDate.parse(eventDate);
                LocalDate booking = LocalDate.parse(bookingDate);
                return earlyBirdDiscountService.calculateBirdDiscount(event, booking);
            } catch (DateTimeParseException e) {
                return "Incorrect date. Format date AAAA-MM-DD";
            }


        }
        return "Discount Service is STOP";
    }
}
