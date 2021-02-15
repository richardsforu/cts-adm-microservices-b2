package com.cts.flight.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.Fare;
import com.cts.flight.service.FareService;

@RestController
@CrossOrigin
@RequestMapping("/api/fare")
@RefreshScope
public class FareRestController {

	@Autowired
	private FareService fareService;
	@Value("${fares.discount}")
	private String faresDiscount;

	@GetMapping("/{flightNumber}/{flightDate}/{origin}/{destination}")
	public Fare getFareByFlightInfo(@PathVariable String flightNumber,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate, @PathVariable String origin,
			@PathVariable String destination) {

		System.out.println(">>>>>>>>>> FARE DISCOUNT <<<<<<<<<");
		System.out.println(faresDiscount);
		System.out.println(">>>>>>>>>> FARE DISCOUNT <<<<<<<<<");

		return fareService
				.findByFlightNumberAndFlightDateAndOriginAndDestination(flightNumber, flightDate, origin, destination)
				.getFare();
	}

	@GetMapping("/{fareId}")
	public Fare findByFareId(@PathVariable int fareId) {

		System.out.println(">>>>>>>>>> FARE DISCOUNT <<<<<<<<<");
		System.out.println(faresDiscount);
		System.out.println(">>>>>>>>>> FARE DISCOUNT <<<<<<<<<");

		return fareService.getFareById(fareId);
	}

}
