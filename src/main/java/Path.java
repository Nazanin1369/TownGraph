/**
 * Created by nazanin on 6/8/15.
 */
public class Path {
    private int distance;
    private int stops;

    public Path(int distance, int hops) {
        this.distance = distance;
        this.stops = hops;
    }
    public String toString() {
        return "(" + distance + ", " + stops +")";
    }
    public int getDistance() {
        return distance;
    }
    public int getStops() {
        return stops;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setStops(int hops) {
        this.stops = hops;
    }
}
