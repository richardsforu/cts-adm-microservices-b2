package com.cts.flight.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Flight;
import com.cts.flight.model.SearchQuery;

@RestController
@CrossOrigin
@RequestMapping("/api/pss")
public class FlightRestController {

	@Autowired
	private FlightDao dao;

	@GetMapping
	public List<Flight> findAllFlights() {
		return dao.findAll();
	}

	@PostMapping
	public List<Flight> findFlights(@RequestBody SearchQuery qry) {

		List<Flight> flights = dao.findFlightByOriginAndDestinationAndFlightDate(qry.getOrigin(), qry.getDestination(),
				qry.getFlightDate());

		System.out.println(">>> LIST Size: " + flights.size());
		System.out.println("Passengers: " + qry.getNumberofPassengers());

		flights = flights.stream().filter(flight -> flight.getInventory().getCount() >= qry.getNumberofPassengers())
				.collect(Collectors.toList());

		System.out.println("<<<< LIST Size: " + flights.size());

		return flights;
	}

	@GetMapping("/{origin}/{destination}/{flightDate}/{numberofPassengers}")
	public List<Flight> findFlightsV1(@PathVariable("origin") String origin,
			@PathVariable("destination") String destination, 
			@PathVariable("flightDate") @DateTimeFormat(iso = ISO.DATE) LocalDate flightDate,
			@PathVariable("numberofPassengers") int numberofPassengers) {

		List<Flight> flights = dao.findFlightByOriginAndDestinationAndFlightDate(origin, destination, flightDate);

		flights = flights.stream().filter(flight -> flight.getInventory().getCount() >= numberofPassengers)
				.collect(Collectors.toList());
		
		return flights;
	}

}
