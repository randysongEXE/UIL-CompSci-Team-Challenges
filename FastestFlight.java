import java.util.*;

class Airport {
    int id;
    int x;
    int y;
    List<Edge> edges;
    boolean visited;
    double minDistance;
    Airport prev;

    public Airport(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.edges = new ArrayList<>();
        this.visited = false;
        this.minDistance = Double.POSITIVE_INFINITY;
        this.prev = null;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public double distanceTo(Airport other) {
        int dx = x - other.x;
        int dy = y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public int compareTo(Airport other) {
        return Double.compare(minDistance, other.minDistance);
    }
}

class Edge {
    Airport from;
    Airport to;
    double weight;

    public Edge(Airport from, Airport to) {
        this.from = from;
        this.to = to;
        this.weight = from.distanceTo(to);
    }
}

public class Airport {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        int n = key.nextInt();
        int e = key.nextInt();

        
        Map<Integer, Airport> airports = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Airport airport = new Airport(id, x, y);
            airports.put(id, airport);
        }

        
        for (int i = 0; i < e; i++) {
            int fromId = scanner.nextInt();
            int toId = scanner.nextInt();
            Airport from = airports.get(fromId);
            Airport to = airports.get(toId);
            Edge edge = new Edge(from, to);
            from.addEdge(edge);
        }

      
        int startId = key.nextInt();
        int endId = key.nextInt();
        Airport start = airports.get(startId);
        start.minDistance = 0;
        PriorityQueue<Airport> queue = new PriorityQueue<>(Comparator.comparingDouble(a -> a.minDistance));
        queue.add(start);

        while (!queue.isEmpty()) {
            Airport current = queue.poll();
            current.visited = true;

            for (Edge edge : current.edges) {
                Airport neighbor = edge.to;
                if (!neighbor.visited) {
                    double distance = current.minDistance + edge.weight;
                    if (distance < neighbor.minDistance) {
                        neighbor.minDistance = distance;
                        neighbor.prev = current;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        
        List<Integer> path = new ArrayList<>();
        Airport current = airports.get(endId);
        while (current != null) {
            path.add(current.id);
            current = current.prev;
        }
        Collections.reverse(path);
        for (int id : path) {
            System.out.print(id + " ");
        }
    }
}
