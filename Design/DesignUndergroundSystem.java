// this solution is not working
class UndergroundSystem {
    private Map<String, Map<Integer, Integer>> checkin;
    private Map<Integer, Map<String, Integer>> checkout;

    public UndergroundSystem() {
        checkin = new HashMap<>();
        checkout = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        if (!checkin.containsKey(stationName)) {
            this.checkin.put(stationName, new HashMap<>());
        }
        
        this.checkin.get(stationName).put(id, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if (!checkout.containsKey(id)) {
            this.checkout.put(id, new HashMap<>());
        }
        
        this.checkout.get(id).put(stationName, t);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double totalTime = 0;
        int totalCount = 0;
        Map<Integer, Integer> checkins = checkin.get(startStation);
        for (Map.Entry<Integer, Integer> entry : checkins.entrySet()) {
            int id = entry.getKey();
            int startTime = entry.getValue();
            Map<String, Integer> checkouts = checkout.get(id);
            if (checkouts != null) {
                for (Map.Entry<String, Integer> checkoutEntry : checkouts.entrySet()) {
                    String end = checkoutEntry.getKey();
                    int endTime = checkoutEntry.getValue();
                    if (end.equals(endStation)) {
                        totalCount++;
                        totalTime += (endTime - startTime);
                    }
                }
            }
            
        }
        if (totalCount == 0) return 0;
        return totalTime / totalCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
