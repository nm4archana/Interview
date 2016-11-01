package SearchAlgorithms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearch {
	// Initialize variables
	int[][] adjacencyMatrix;
	int noOfNodes;
	HashMap<String, Integer> indexMap;
	int indexCount = 0;
	Stack<Node> frontier;
	ArrayList<String> storePath = new ArrayList<String>();
	ArrayList<String> visited = new ArrayList<String>();
	String initialState;
	String goal;
	String[] nodeList;
	boolean goaltest = false;
	int totalPathCost = 0;

	// Constructor
	public DepthFirstSearch(int noOfNodes, String initialState, String goal) {
		this.noOfNodes = noOfNodes;
		this.initialState = initialState;
		this.goal = goal;
		adjacencyMatrix = new int[noOfNodes][noOfNodes];
		indexMap = new HashMap<String, Integer>();
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

	// Data Structure to store the graph
	private void createAdjacencyMatrix(String from, String to, int cost) {
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

	// Initialize the stack(i.e Frontier)
	private void initializeFrontier() {
		frontier = new Stack<Node>();
	}

	// Graph-Search Function
	private void graphSearch() { // Source Node
		Node start = new Node(initialState);
		// Add source node to Visited Array
		visited.add(initialState);
		// Initialize the stack
		initializeFrontier();
		// Add the Source to Stack
		frontier.add(start);
		// Test if the goal is reached
		Node fromCity = start;
		goaltest = testGoal(fromCity.state);
		while (!frontier.isEmpty()) {
			if (goaltest == true) {
				// Print the path and cost if the goal is reached
				printPath(fromCity);
				break;
			}
			// Choose the node from the
			fromCity = chooseNode(frontier);
			// Explore the Node fromCity
			expandNode(fromCity);
		}

		// If no path exists between the source and destination
		if (goaltest == false) {
			System.out.println("No path exists between the initial and goal cities");
		}
	}

	// Choose the node from the frontier that has to be explored
	private Node chooseNode(Stack<Node> frontier) {
		Node fromCity = frontier.pop();
		return fromCity;
	}

	// Expand the node
	private void expandNode(Node fromNode) {
		int getIndex = indexMap.get(fromNode.state);
		// Get the adjacent nodes from the adjacency matrix
		for (int j = 0; j < adjacencyMatrix[0].length; j++) {
			int cost = adjacencyMatrix[getIndex][j];
			if (cost != 0 && !visited.contains(nodeList[j])) {
				if (testGoal(nodeList[j]) == false) {
					updateFrontier(nodeList[j], fromNode, cost);
				} else {
					goaltest = true;
					totalPathCost = fromNode.pathCost + cost;
					break;
				}
			}
		}
	}

	// Test if the goal has been reached
	private Boolean testGoal(String fromCity) {
		if (fromCity.equals(goal)) {
			return true;
			// testNode.action="";
		}
		return false;
	}

	// Update the frontier with the explored child node
	public void updateFrontier(String childCity, Node parentNode, int cost) {
		Node childNode = new Node(childCity);
		childNode.parent = parentNode;
		childNode.pathCost = childNode.parent.pathCost + cost;
		visited.add(childCity);
		frontier.add(childNode);
	}

	//Print the path and cost
	private void printPath(Node fromCity) {
		System.out.println("The path is: ");
		storePath.add(goal);
		storePath.add(fromCity.state);
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
		System.out.println("The Path Cost is: " + totalPathCost);
	}

	// Driver Function
	public static void main(String[] args) {
		int noOfCities = 20;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Source: ");
		String source = input.next();
		System.out.println("Enter the Destination: ");
		String destination = input.next();
		DepthFirstSearch firstSearch = new DepthFirstSearch(noOfCities, source, destination);
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
