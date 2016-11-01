package SearchAlgorithms;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UniformCostSearch {
	// Initialize variables
	int[][] adjacencyMatrix;
	int noOfNodes;
	int indexCount = 0;
	boolean goalTest = false;
	HashMap<String, Integer> indexMap = new HashMap<String, Integer>();;
	String initialState;
	String goal;
	String[] nodeList;
	ArrayList<String> storePath = new ArrayList<String>();
	ArrayList<String> visited = new ArrayList<String>();
	PriorityQueue<Node> frontier;

	// Constructor
	public UniformCostSearch(int noOfNodes, String initialState, String goal) {
		this.noOfNodes = noOfNodes;
		this.initialState = initialState;
		this.goal = goal;
		adjacencyMatrix = new int[noOfNodes][noOfNodes];
		nodeList = new String[noOfNodes];
	}

	// Node Data Structure
	class Node {
		String state;
		Node parent;
		int pathCost;
		String action;

		// Initializing a Node
		Node(String s) {
			state = s;
			pathCost = 0;
			parent = null;
			// action = "EXPLORE_NODE";
		}

	}

	// Initialize the priority queue(i.e Frontier)
	private void initializeFrontier() {
		frontier = new PriorityQueue<Node>(noOfNodes, new Comparator<Node>() {

			public int compare(Node city1, Node city2) {
				// Compare path cost
				if (city1.pathCost < city2.pathCost) {
					return -1;
				} else if (city1.pathCost > city2.pathCost) {
					return 1;
				}

				else {
					return 0;
				}
			}
		});
	}

	// Data Structure to store the graph
	public void createAdjacencyMatrix(String from, String to, int cost) {
		// Creating an index Map to store the index of city corresponding to the
		// adjacency matrix
		if (!indexMap.containsKey(from)) {
			indexMap.put(from, indexCount);
			indexCount++;
		}
		if (!indexMap.containsKey(to)) {
			indexMap.put(to, indexCount);
			indexCount++;
		}

		// Get the index of cities from IndexMap
		int startIndex = indexMap.get(from);
		int endIndex = indexMap.get(to);

		nodeList[startIndex] = from;
		nodeList[endIndex] = to;
		// Populating values into Adjacency matrix
		adjacencyMatrix[startIndex][endIndex] = cost;
		adjacencyMatrix[endIndex][startIndex] = cost;
	}

	// Graph-Search Function
	private void graphSearch() {
		int minCost = Integer.MAX_VALUE;
		// Source Node
		Node start = new Node(initialState);
		// Add source node to Visited Array
		visited.add(initialState);
		// Initialize the priority queue
		initializeFrontier();
		// Add the Source to priority Queue
		frontier.add(start);
		// Test if the goal is reached
		Node fromCity = start;
		Node minCostNode = fromCity;
       
		while(!frontier.isEmpty()) 
		{
			fromCity = chooseNode(frontier);
			// Test if the goal is reached
			goalTest = testGoal(fromCity);
			if (goalTest) {
				if (fromCity.pathCost < minCost) {
					// To find the minimum cost each time when the goal is reached
					minCost = fromCity.pathCost;
					minCostNode = fromCity;
				}
			}
			else {
				// Explore the Node fromCity
				expandNode(fromCity);
			}
		}
		// Print the path and cost if the goal is reached
		printPath(minCostNode, minCost);

	}

	// Choose the node from the frontier that has to be explored
	private Node chooseNode(PriorityQueue<Node> frontier) {
		Node fromCity = frontier.remove();
		return fromCity;
	}

	// Expand the node
	private void expandNode(Node fromNode) {
		int getIndex = indexMap.get(fromNode.state);
		//Get the adjacent nodes from the adjacency matrix
		for (int j = 0; j < adjacencyMatrix[0].length; j++) {
			int cost = adjacencyMatrix[getIndex][j];
			if (cost != 0 && !visited.contains(nodeList[j])) {
				updateFrontier(nodeList[j], fromNode, cost);
			}
		}
	}

	// Test if the goal has been reached
	private Boolean testGoal(Node fromCity) {
		if (fromCity.state.equals(goal)) {
			return true;
		}
		return false;
	}

	// Update the frontier with the explored child node
	private void updateFrontier(String childCity, Node parentNode, int cost) {
		Node childNode = new Node(childCity);
		childNode.parent = parentNode;
		childNode.pathCost = childNode.parent.pathCost + cost;
		testGoal(childNode);
		if (!childNode.state.equals(goal))
			visited.add(childCity);
		frontier.add(childNode);
	}

	private void printPath(Node fromCity, int minCost) {
		System.out.println("The path is: ");
		storePath.add(fromCity.state);

		if (minCost == Integer.MAX_VALUE) {
			System.out.println("No path exists between the given cities");
		} else {
			while (fromCity.parent != null) {
				storePath.add(fromCity.parent.state);
				fromCity = fromCity.parent;
			}

			for (int i = storePath.size() - 1; i >= 0; i--) {
				System.out.print(storePath.get(i));
				if (i > 0)
					System.out.print("-->");
			}
			System.out.println("\n");
			System.out.println("The path cost is: " + minCost);
		}
	}

	// Driver Function
	public static void main(String[] args) {
		int noOfCities = 20;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Source: ");
		String sourceCity = input.next();
		System.out.println("Enter the Destination: ");
		String destinationCity = input.next();
		UniformCostSearch firstSearch = new UniformCostSearch(noOfCities, sourceCity, destinationCity);
		firstSearch.createAdjacencyMatrix("Arad", "Zerind", 75);
		firstSearch.createAdjacencyMatrix("Arad", "Timisoara", 118);
		firstSearch.createAdjacencyMatrix("Arad", "Sibiu", 140);
		firstSearch.createAdjacencyMatrix("Zerind", "Oradea", 71);
		firstSearch.createAdjacencyMatrix("Oradea", "Sibiu", 151);
		firstSearch.createAdjacencyMatrix("Timisoara", "Lugoj", 111);
		firstSearch.createAdjacencyMatrix("Lugoj", "Mehadia", 70);
		firstSearch.createAdjacencyMatrix("Mehadia", "Drobeta", 75);
		firstSearch.createAdjacencyMatrix("Drobeta", "Craiova", 120);
		firstSearch.createAdjacencyMatrix("Craiova", "Rimnicu Vilcea", 146);
		firstSearch.createAdjacencyMatrix("Craiova", "Pitesti", 138);
		firstSearch.createAdjacencyMatrix("Sibiu", "Fagaras", 99);
		firstSearch.createAdjacencyMatrix("Sibiu", "Rimnicu Vilcea", 80);
		firstSearch.createAdjacencyMatrix("Rimnicu Vilcea", "Pitesti", 97);
		firstSearch.createAdjacencyMatrix("Fagaras", "Bucharest", 211);
		firstSearch.createAdjacencyMatrix("Pitesti", "Bucharest", 101);
		firstSearch.createAdjacencyMatrix("Bucharest", "Urziceni", 85);
		firstSearch.createAdjacencyMatrix("Bucharest", "Giurgiu", 90);
		firstSearch.createAdjacencyMatrix("Urziceni", "Vaslui", 142);
		firstSearch.createAdjacencyMatrix("Vaslui", "Iasi", 92);
		firstSearch.createAdjacencyMatrix("Iasi", "Neamt", 87);
		firstSearch.createAdjacencyMatrix("Urziceni", "Hirsova", 98);
		firstSearch.createAdjacencyMatrix("Hirsova", "Eforie", 86);
		firstSearch.graphSearch();
		input.close();
	}
}
