package com.developer.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.developer.model.BagEndpoint;
import com.developer.model.FlightDeparture;
import com.developer.model.Graph;
import com.developer.model.Node;

/**
 * Core execution of the bag routing
 *
 */
public class BagPathFinder {

	private static final Logger LOG = LoggerFactory.getLogger(BagPathFinder.class);

	private ShortestRoute algorithm;	
	
	private Bootstrap bootstrap;
	
	private ConveyorSystem conveyorSystem;

	
	public ShortestRoute getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(ShortestRoute algorithm) {
		this.algorithm = algorithm;
	}

	public Bootstrap getBootstrap() {
		return bootstrap;
	}

	public void setBootstrap(Bootstrap bootstrap) {
		this.bootstrap = bootstrap;
	}

	public ConveyorSystem getConveyorSystem() {
		return conveyorSystem;
	}

	public void setConveyorSystem(ConveyorSystem conveyorSystem) {
		this.conveyorSystem = conveyorSystem;
	}

	public void execute() {

		
		List<FlightDeparture> flightDepLst = this.bootstrap.bootstrapFlightDeparture();
		List<BagEndpoint> bagEndpointLst = this.bootstrap.bootstrapBags();

		Graph graph = new Graph(conveyorSystem.getNodes(), conveyorSystem.getEdges());

		Map<String, Node> nodeNameIndexMap = conveyorSystem.getNodeIndexMap();

		Map<String, String> flightIdNodeMap = new HashMap<String, String>();

		for (FlightDeparture flightDep : flightDepLst) {
			flightIdNodeMap.put(flightDep.getFlightId(), flightDep.getFlightGate());
		}

		
		//Print the paths and distance
		for (int i = 0; i < 5; i++) {

			BagEndpoint bagEndpoint = bagEndpointLst.get(i);
			Node startNode = nodeNameIndexMap.get(bagEndpoint.getEntryPoint());
			Node targetNode = nodeNameIndexMap.get(flightIdNodeMap.get(bagEndpoint.getFlightId()));
			List<Node> path = algorithm.determineShortestPath(graph, startNode, targetNode);
			int dist = algorithm.determineShortestDistance(graph, path);

			LOG.debug(" {}  {} : {} ", bagEndpoint.getBagNumber(), printPath(path), dist);

		}

	}

	
	private String printPath(List<Node> path) {

		StringBuilder sb = new StringBuilder();

		if (path != null && !path.isEmpty()) {
			for (int j = 0; j < path.size(); j++) {
				Node node = path.get(j);
				sb = sb.append(node.getName());
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
