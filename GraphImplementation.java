import java.util.*;

public class GraphImplementation implements Graph {

	private int[][] adjMatrix;

	public GraphImplementation(int vertices) {
		adjMatrix = new int[vertices][vertices];
	}

	public void addEdge(int src, int tar) {
		adjMatrix[src][tar] = 1;
		// adjMatrix = [tar][src];

	}

	public int[] neighbors(int vertex) {
		int count = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[vertex][i] == 1) {
				count++;
			}
		}
		int[] arr = new int[count];
		count = 0;
		for (int i = 0; i < adjMatrix.length; i++) {
			if (adjMatrix[vertex][i] == 1) {
				arr[count++] = i;
			}
		}
		return arr;
	}

	public List <Integer> topologicalSort(){
		 int [] NumIncident = new int [adjMatrix.length];
		 List<Integer> TopologicalOrder = new ArrayList<Integer>(); 
		 for (int v = 0; v < adjMatrix.length; v++){
		 	NumIncident[v] = 0; 
		 }
		 for (int i = 0; i < adjMatrix.length; i++){
		 	for (int j = 0; j < adjMatrix.length; j++){
		 		if (adjMatrix[j][i] == 1) {
		 			NumIncident[i]++; 
		 		}
		 	}
		 }
		 for(int k = 0; k < adjMatrix.length;k++) {
			for (int i = 0; i < adjMatrix.length; i++){
				if (NumIncident[i] == 0){
					TopologicalOrder.add(i);
					NumIncident[i] = -1; 
					int[] temp = neighbors(i); 
					for (int j = 0; j < temp.length;j++) {
						NumIncident[temp[j]]--; 
					}
					break;
				}
		 
			}
		 }
		 return TopologicalOrder;
	

	}
}