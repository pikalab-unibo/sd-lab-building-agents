new AbstractAgent("double-counter-agent") {
    private int i = 0;
    private int j = 100;
    
    @Override public void setup() {
        addBehaviour(
            Behaviour.of(() -> { if (++i == j) stop(); })
                     .repeatWhile(() -> i < 100)
        );        
        addBehaviour(
            Behaviour.of(() -> { if (--j == i) stop(); })
                     .repeatWhile(() -> j > 0)
        );    
    }
}
