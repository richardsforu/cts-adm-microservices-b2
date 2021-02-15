package com.cts.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.service.BookingService;

@RestController
@CrossOrigin
@RequestMapping("/api/booking")
@RefreshScope
public class BookingRestController {

	@Autowired
	private BookingService bookingService;
	@Value("${coupon.code}")
	private String couponCode;


	@PostMapping("/{numberofPassengers}")
	public BookingRecord bookFlight(@RequestBody BookingRecord bookingRecord, @PathVariable int numberofPassengers) {
		
		System.out.println(">>>>>>>>>>>>>> COUPON CODE APPLIED <<<<<<<<<<<<<");
		System.out.println(couponCode);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		return bookingService.bookFlight(bookingRecord.getFlightNumber(), bookingRecord.getOrigin(),
				bookingRecord.getDestination(), bookingRecord.getFlightDate(), numberofPassengers,
				bookingRecord.getPassenger());
	}

	@GetMapping("/{bookingId}")
	public BookingRecord getBookingDetails(@PathVariable int bookingId) {
		return bookingService.getBookingInfo(bookingId);
	}

}
