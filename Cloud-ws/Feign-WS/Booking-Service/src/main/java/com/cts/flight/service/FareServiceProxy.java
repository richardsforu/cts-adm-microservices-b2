package com.cts.flight.service;

import java.time.LocalDate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.flight.entity.Fare;
@FeignClient(name = "fare-service", url = "http://localhost:8081/api/fare")
public interface FareServiceProxy {
	@GetMapping("/{flightNumber}/{flightDate}/{origin}/{destination}")
	public Fare findFare(@PathVariable String flightNumber,
			@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate, @PathVariable String origin,
			@PathVariable String destination);

}
