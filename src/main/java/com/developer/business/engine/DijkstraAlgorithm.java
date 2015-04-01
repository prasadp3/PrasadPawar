package com.developer.business.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.developer.model.Edge;
import com.developer.model.Graph;
import com.developer.model.Node;

/**
 * Dijkstra Shortest Path algorithm implementation
 *
 */
public class DijkstraAlgorithm {

	private final List<Node> nodes;
	private final List<Edge> edges;

	private Set<Node> settledNodes;
	private Set<Node> unSettledNodes;
	private Map<Node, Node> predecessors;
	private Map<Node, Integer> distance;

	public DijkstraAlgorithm(Graph graph) {
		this.nodes = new ArrayList<Node>(graph.getNodes());
		this.edges = new ArrayList<Edge>(graph.getEdges());
	}

	public void setup(Node source) {
		settledNodes = new HashSet<Node>();
		unSettledNodes = new HashSet<Node>();
		distance = new HashMap<Node, Integer>();
		predecessors = new HashMap<Node, Node>();
		distance.put(source, 0);
		unSettledNodes.add(source);
		while (unSettledNodes.size() > 0) {
			Node node = getMinimum(unSettledNodes);
			settledNodes.add(node);
			unSettledNodes.remove(node);
			findMinimalDistances(node);
		}
	}

	public int getDistance(Node node, Node target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}

	private List<Node> getNeighbours(Node node) {
		List<Node> neighbours = new ArrayList<Node>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbours.add(edge.getDestination());
			}
		}
		return neighbours;
	}

	private void findMinimalDistances(Node node) {
		List<Node> adjacentNodes = getNeighbours(node);
		for (Node target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
				distance.put(target, getShortestDistance(node) + getDistance(node, target));
				predecessors.put(target, node);
				unSettledNodes.add(target);
			}
		}

	}

	private Node getMinimum(Set<Node> vertexes) {
		Node minimum = null;
		for (Node vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;
			} else {
				if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	private boolean isSettled(Node vertex) {
		return settledNodes.contains(vertex);
	}

	private int getShortestDistance(Node destination) {
		Integer d = distance.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public LinkedList<Node> getPath(Node target) {
		LinkedList<Node> path = new LinkedList<Node>();
		Node step = target;

		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}

		Collections.reverse(path);
		return path;
	}

}
