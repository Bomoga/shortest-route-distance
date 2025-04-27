import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.awt.*;

public class GraphDisplay extends JPanel
{
    ArrayList<Point> points;
    double localSearchCost;
    int[] localSearchRoute;

    public GraphDisplay(ArrayList<Point> points, double localSearchCost, int[] localSearchRoute) {
        this.points = points;
        this.localSearchCost = localSearchCost;
        this.localSearchRoute = localSearchRoute;
        setPreferredSize(new Dimension(700, 500));
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.BLACK);
        for (Point point : points) {
            g.fillOval(point.x - 4, point.y - 4, 8, 8);
        }

        g.setColor(Color.BLUE);
        for (int i = 0; i < localSearchRoute.length - 1; i++) {
            Point p1 = points.get(localSearchRoute[i]);
            Point p2 = points.get(localSearchRoute[i + 1]);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
        Point first = points.get(localSearchRoute[0]);
        Point last = points.get(localSearchRoute[localSearchRoute.length - 1]);
        g.drawLine(last.x, last.y, first.x, first.y);

        g.setColor(Color.RED);
        g.drawString("Shortest Route Distance: " + localSearchCost, 10, 20);
    }
}
