class MinStack {
    List<Integer> l;
    public MinStack() {
        this.l = new ArrayList<>();
    }
    
    public void push(int val) {
        l.add(val);
    }
    
    public void pop() {
        l.remove(l.size() - 1);
    }
    
    public int top() {
        return l.get(l.size() - 1);
    }
    
    public int getMin() {
        int min = l.get(0);
        for(int e: l){
            min = Math.min(min, e);
        }
        return min;
    }
}
