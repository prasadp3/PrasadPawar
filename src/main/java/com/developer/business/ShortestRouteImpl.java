package com.developer.business;

import java.util.LinkedList;
import java.util.List;

import com.developer.business.engine.DijkstraAlgorithm;
import com.developer.model.Graph;
import com.developer.model.Node;

/**
 * Implementation of the Shortest path between source and target node
 *
 */
public class ShortestRouteImpl implements ShortestRoute{

	@Override
	public List<Node> determineShortestPath(Graph graph, Node source, Node target) {		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);		
		dijkstra.setup(source);
		LinkedList<Node> path = dijkstra.getPath(target);

		return path;
	}

	@Override
	public int determineShortestDistance(Graph graph, List<Node> shortestPath) {		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);		
		int dist = 0;
		if (shortestPath != null && !shortestPath.isEmpty()) {
			for (int i = 0; i < shortestPath.size() - 1; i++) {
				dist = dist + dijkstra.getDistance(shortestPath.get(i), shortestPath.get(i + 1));
			}
		}
		return dist;

	}

}
