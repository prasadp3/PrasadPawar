package com.developer.algorithms.dijkstra.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.developer.business.engine.DijkstraAlgorithm;
import com.developer.model.Edge;
import com.developer.model.Graph;
import com.developer.model.Node;

public class DijkstraAlgorithmTest {

	private List<Node> nodes;
	private List<Edge> edges;

	@Test
	public void testExcute() {
		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 12; i++) {
			Node location = new Node("Node_" + i, "Node_" + i);
			nodes.add(location);
		}

		// CAT - A0
		addLane("Edge_0", 0, 5, 5);

		// BC - A11
		addLane("Edge_1", 5, 11, 5);
		addLane("Edge_2", 11, 5, 5);

		addLane("Edge_2", 5, 10, 4);
		addLane("Edge_3", 5, 1, 6);
		addLane("Edge_4", 5, 0, 5);

		addLane("Edge_5", 1, 2, 1);
		addLane("Edge_6", 1, 5, 6);

		addLane("Edge_7", 2, 3, 1);
		addLane("Edge_8", 2, 1, 1);

		addLane("Edge_9", 3, 4, 1);
		addLane("Edge_10", 3, 2, 1);

		addLane("Edge_11", 4, 3, 1);

		addLane("Edge_12", 10, 9, 1);
		addLane("Edge_13", 10, 5, 4);

		addLane("Edge_14", 9, 8, 1);
		addLane("Edge_15", 9, 10, 1);

		addLane("Edge_16", 8, 9, 1);
		addLane("Edge_17", 8, 7, 1);

		addLane("Edge_18", 7, 6, 1);
		addLane("Edge_19", 7, 8, 1);

		addLane("Edge_20", 6, 7, 1);

		Graph graph = new Graph(nodes, edges);
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);

		LinkedList<Node> path = printPath(dijkstra, nodes.get(8) , nodes.get(5));
		getDistanceFromPath(dijkstra, path);

	}

	private LinkedList<Node> printPath(DijkstraAlgorithm dijkstra, Node source, Node target) {

		dijkstra.setup(source);
		LinkedList<Node> path = dijkstra.getPath(target);

		System.out.println("Path " + path);
		return path;

	}

	private int getDistanceFromPath(DijkstraAlgorithm dijkstra, LinkedList<Node> path) {

		int dist = 0;

		if (path != null && !path.isEmpty()) {
			for (int i = 0; i < path.size() - 1; i++) {
				dist = dist + dijkstra.getDistance(path.get(i), path.get(i + 1));
			}
		}

		System.out.println("Distance" + dist);
		return dist;

	}

	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) {
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
		edges.add(lane);
	}
}