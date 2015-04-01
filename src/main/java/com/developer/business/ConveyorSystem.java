package com.developer.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.developer.business.constants.PathFinderConstants;
import com.developer.model.Edge;
import com.developer.model.Node;

/**
 * Conveyor graph with nodes and edges configuration
 * 
 */
public class ConveyorSystem {

	private List<Node> nodes;
	private List<Edge> edges;

	private Map<String, Node> nodeIndexMap = null;

	public ConveyorSystem() {

		nodes = new ArrayList<Node>();
		edges = new ArrayList<Edge>();

		Node catNode = new Node("Node_0", PathFinderConstants.NODE_CAT);
		Node node1 = new Node("Node_1", PathFinderConstants.NODE_A1);
		Node node2 = new Node("Node_2", PathFinderConstants.NODE_A2);
		Node node3 = new Node("Node_3", PathFinderConstants.NODE_A3);
		Node node4 = new Node("Node_4", PathFinderConstants.NODE_A4);
		Node node5 = new Node("Node_5", PathFinderConstants.NODE_A5);
		Node node6 = new Node("Node_6", PathFinderConstants.NODE_A6);
		Node node7 = new Node("Node_7", PathFinderConstants.NODE_A7);
		Node node8 = new Node("Node_8", PathFinderConstants.NODE_A8);
		Node node9 = new Node("Node_9", PathFinderConstants.NODE_A9);
		Node node10 = new Node("Node_10", PathFinderConstants.NODE_A10);
		Node bcNode = new Node("Node_11", PathFinderConstants.NODE_BC);

		nodes.add(catNode);
		nodes.add(node1);
		nodes.add(node2);
		nodes.add(node3);
		nodes.add(node4);
		nodes.add(node5);
		nodes.add(node6);
		nodes.add(node7);
		nodes.add(node8);
		nodes.add(node9);
		nodes.add(node10);
		nodes.add(bcNode);

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

		
		nodeIndexMap = new HashMap<String, Node>();
		nodeIndexMap.put(PathFinderConstants.NODE_CAT, nodes.get(0));
		nodeIndexMap.put(PathFinderConstants.NODE_A1, nodes.get(1));
		nodeIndexMap.put(PathFinderConstants.NODE_A2, nodes.get(2));
		nodeIndexMap.put(PathFinderConstants.NODE_A3, nodes.get(3));
		nodeIndexMap.put(PathFinderConstants.NODE_A4, nodes.get(4));
		nodeIndexMap.put(PathFinderConstants.NODE_A5, nodes.get(5));
		nodeIndexMap.put(PathFinderConstants.NODE_A6, nodes.get(6));
		nodeIndexMap.put(PathFinderConstants.NODE_A7, nodes.get(7));
		nodeIndexMap.put(PathFinderConstants.NODE_A8, nodes.get(8));
		nodeIndexMap.put(PathFinderConstants.NODE_A9, nodes.get(9));
		nodeIndexMap.put(PathFinderConstants.NODE_A10, nodes.get(10));
		nodeIndexMap.put(PathFinderConstants.NODE_BC, nodes.get(11));

	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public Map<String, Node> getNodeIndexMap() {
		return nodeIndexMap;
	}

	public void setNodeIndexMap(Map<String, Node> nodeIndexMap) {
		this.nodeIndexMap = nodeIndexMap;
	}

	private void addLane(String laneId, int source, int target, int duration) {
		Edge lane = new Edge(laneId, nodes.get(source), nodes.get(target), duration);
		edges.add(lane);
	}

}
