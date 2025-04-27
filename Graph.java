
public class Graph implements GraphInterface
{

    private int[][] matrix;
    private int verticesNumber;

    public Graph() {
        this(5);
    }

    public Graph(int n) {
        verticesNumber = n;
        matrix = new int[n][n];
    }

    public Graph(int[][] matrix) {
        this.matrix = matrix;
        this.verticesNumber = matrix.length;
    }

    public void addEdge(int v, int w, int weight) {
        matrix[v][w] = weight;
        matrix[w][v] = weight;
    }

    public int[] findAdjacencyVertices(int v) {
        int count = 0;
        for (int weight : matrix[v]) if (weight > 0) count++;
        int[] adj = new int[count];
        int index = 0;
        for (int i = 0; i < verticesNumber; i++)
            if (matrix[v][i] > 0) adj[index++] = i;
        return adj;
    }

    public int getNumberOfVertices() {
        return verticesNumber;
    }

    public int getWeight(int v, int w) {
        return matrix[v][w];
    }

    public void removeEdge(int v, int w) {
        matrix[v][w] = 0;
        matrix[w][v] = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++)
                sb.append(matrix[i][j]).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }

    private int totalDistance(int[] a) {
        int distance = 0;
        for (int i = 0; i < a.length - 1; i++)
            distance += matrix[a[i]][a[i + 1]];
        distance += matrix[a[a.length - 1]][a[0]];
        return distance;
    }

    private void randomPermutation(int[] a) {
        java.util.Random rnd = new java.util.Random();
        for (int i = a.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }
    }

    public int TSP_localSearch(int[] shortestRoute) {
        for (int i = 0; i < shortestRoute.length; i++){
            shortestRoute[i] = i;
        }
        randomPermutation(shortestRoute);
        int bestDistance = totalDistance(shortestRoute);
        boolean improvement;
        do {
            improvement = false;
            for (int i = 1; i < verticesNumber - 1; i++) {
                for (int j = i + 1; j < verticesNumber; j++) {
                    swap(shortestRoute, i, j);
                    int newDistance = totalDistance(shortestRoute);
                    if (newDistance < bestDistance) {
                        bestDistance = newDistance;
                        improvement = true;
                    } else {
                        swap(shortestRoute, i, j);
                    }
                }
            }
        } while (improvement);

        return bestDistance;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
