package com.developer.business;

import java.util.ArrayList;
import java.util.List;

import com.developer.business.constants.PathFinderConstants;
import com.developer.model.BagEndpoint;
import com.developer.model.FlightDeparture;

/**
 * Setup of bag and flight departure configuration
 *
 */
public class Bootstrap {
	
	
	public List<FlightDeparture> bootstrapFlightDeparture(){
		
		List<FlightDeparture> flightDepLst = new ArrayList<FlightDeparture>();

		FlightDeparture flightDeparture1 = new FlightDeparture(PathFinderConstants.FLIGHT_UA10, PathFinderConstants.NODE_A1, "MIA", "08:00");
		FlightDeparture flightDeparture2 = new FlightDeparture(PathFinderConstants.FLIGHT_UA11, PathFinderConstants.NODE_A1, "LAX", "09:00");
		FlightDeparture flightDeparture3 = new FlightDeparture(PathFinderConstants.FLIGHT_UA12, PathFinderConstants.NODE_A1, "JFK", "09:45");
		FlightDeparture flightDeparture4 = new FlightDeparture(PathFinderConstants.FLIGHT_UA13, PathFinderConstants.NODE_A2, "JFK", "08:30");
		FlightDeparture flightDeparture5 = new FlightDeparture(PathFinderConstants.FLIGHT_UA14,PathFinderConstants.NODE_A2, "JFK", "09:45");
		FlightDeparture flightDeparture6 = new FlightDeparture(PathFinderConstants.FLIGHT_UA15, PathFinderConstants.NODE_A2, "JFK", "10:00");
		FlightDeparture flightDeparture7 = new FlightDeparture(PathFinderConstants.FLIGHT_UA16, PathFinderConstants.NODE_A3, "JFK", "09:00");
		FlightDeparture flightDeparture8 = new FlightDeparture(PathFinderConstants.FLIGHT_UA17, PathFinderConstants.NODE_A4, "JFK", "09:15");
		FlightDeparture flightDeparture9 = new FlightDeparture(PathFinderConstants.FLIGHT_UA18, PathFinderConstants.NODE_A5, "LAX", "10:15");
		
		FlightDeparture flightDeparture10 = new FlightDeparture(PathFinderConstants.FLIGHT_ARRIVAL,PathFinderConstants.NODE_BC, "", "10:15");

		flightDepLst.add(flightDeparture1);
		flightDepLst.add(flightDeparture2);
		flightDepLst.add(flightDeparture3);
		flightDepLst.add(flightDeparture4);
		flightDepLst.add(flightDeparture5);
		flightDepLst.add(flightDeparture6);
		flightDepLst.add(flightDeparture7);
		flightDepLst.add(flightDeparture8);
		flightDepLst.add(flightDeparture9);
		flightDepLst.add(flightDeparture10);

		return flightDepLst;
		
	}

	public List<BagEndpoint>  bootstrapBags(){
		
		List<BagEndpoint> bagEndpointLst = new ArrayList<BagEndpoint>();

		BagEndpoint bagEndpoint1 = new BagEndpoint("0001", PathFinderConstants.NODE_CAT, PathFinderConstants.FLIGHT_UA12);
		BagEndpoint bagEndpoint2 = new BagEndpoint("0002", PathFinderConstants.NODE_A5, PathFinderConstants.FLIGHT_UA17);
		BagEndpoint bagEndpoint3 = new BagEndpoint("0003",  PathFinderConstants.NODE_A2, PathFinderConstants.FLIGHT_UA10);
		BagEndpoint bagEndpoint4 = new BagEndpoint("0004",  PathFinderConstants.NODE_A8,PathFinderConstants.FLIGHT_UA18);
		BagEndpoint bagEndpoint5 = new BagEndpoint("0005",  PathFinderConstants.NODE_A7, PathFinderConstants.FLIGHT_ARRIVAL);

		bagEndpointLst.add(bagEndpoint1);
		bagEndpointLst.add(bagEndpoint2);
		bagEndpointLst.add(bagEndpoint3);
		bagEndpointLst.add(bagEndpoint4);
		bagEndpointLst.add(bagEndpoint5);
		
		return bagEndpointLst;
		
	}
}
