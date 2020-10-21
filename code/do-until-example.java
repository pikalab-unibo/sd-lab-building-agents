new AbstractAgent("do-until") {
  private int i = 0;
  
  @Override 
  public void setup() {
    Behaviour.of(() -> log(i))
      .repeatUntil(() -> i >= 5)
      .andThen(() -> stop())
      .addTo(this);
  }
}
