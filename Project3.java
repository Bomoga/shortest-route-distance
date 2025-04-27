import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import javax.swing.JFrame;

public class Project3{

    public static void main(String[] args){
        new Project3();
    }

    public Project3(){
        Scanner in = new Scanner(System.in);
        System.out.print("Name of file: ");
        String filename = in.nextLine();

        ArrayList<Point> points = getPointsFromFile(filename);

        int[][] matrix = generateMatrix(points);
        Graph g = new Graph(matrix);

        int[] localSearchRoute = new int[points.size()];
        double localSearchCost = g.TSP_localSearch(localSearchRoute);
        System.out.print("Route: ");
        for (int i : localSearchRoute){
            System.out.print(i + " ");
        }
        System.out.println();

        FrameDisplay frame = new FrameDisplay(points, localSearchCost, localSearchRoute);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public ArrayList<Point> getPointsFromFile(String filename){
        ArrayList<Point> points = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filename))) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++)
                points.add(new Point(sc.nextInt(), sc.nextInt()));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return points;
    }

    public int[][] generateMatrix(ArrayList<Point> points){
        int size = points.size();
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                if (i != j){
                    Point p1 = points.get(i);
                    Point p2 = points.get(j);
                    matrix[i][j] = (int)Math.hypot(p1.x - p2.x, p1.y - p2.y);
                }
            }
        }
        return matrix;
    }
}