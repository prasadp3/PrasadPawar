package com.developer.business;

import java.util.List;

import com.developer.model.Graph;
import com.developer.model.Node;

/**
 * Determines the Shortest path between source and target node
 * 
 */
public interface ShortestRoute {

	List<Node> determineShortestPath(Graph graph, Node source, Node target);	
	int determineShortestDistance(Graph graph, List<Node> path);	

}
