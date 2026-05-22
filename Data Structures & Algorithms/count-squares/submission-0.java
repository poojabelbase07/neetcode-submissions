
class CountSquares {

    // store frequency of each point
    private Map<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {

        String key = point[0] + "," + point[1];

        points.put(key, points.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {

        int x = point[0];
        int y = point[1];

        int result = 0;

        // iterate through all stored points
        for (String key : points.keySet()) {

            String[] parts = key.split(",");

            int x2 = Integer.parseInt(parts[0]);
            int y2 = Integer.parseInt(parts[1]);

            // diagonal point conditions
            if (Math.abs(x - x2) != Math.abs(y - y2) || x == x2 || y == y2) {
                continue;
            }

            // other two square points
            String p1 = x + "," + y2;
            String p2 = x2 + "," + y;

            result += points.get(key)
                    * points.getOrDefault(p1, 0)
                    * points.getOrDefault(p2, 0);
        }

        return result;
    }
}