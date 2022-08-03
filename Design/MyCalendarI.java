class MyCalendar {
    private TreeMap<Integer, Integer> calender;
    
    public MyCalendar() {
        this.calender = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer ceilingStart = calender.ceilingKey(start);
        if (ceilingStart != null && ceilingStart < end) return false;
        Integer floorStart = calender.floorKey(start);
        if (floorStart != null && calender.get(floorStart) > start) return false;
        calender.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
