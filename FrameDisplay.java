
import javax.swing.JFrame;
import java.util.ArrayList;

public class FrameDisplay extends JFrame
{
    int WIDTH = 450;
    int HEIGHT = 450;

    public FrameDisplay(ArrayList<Point> points, double localSearchCost, int[] localSearchRoute) {
        setTitle("Traveling Salesman Solution");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphDisplay panel = new GraphDisplay(points, localSearchCost, localSearchRoute);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
