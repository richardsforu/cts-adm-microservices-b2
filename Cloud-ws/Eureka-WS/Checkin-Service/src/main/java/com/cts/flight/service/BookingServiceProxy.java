package com.cts.flight.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.BookingRecord;

@FeignClient(name = "checkin-service",url = "http://localhost:8083/api/booking")
public interface BookingServiceProxy {

	@GetMapping("/{bookingId}")
	public BookingRecord getBookingRecord(@PathVariable int bookingId);
}
