new AbstractAgent("do-while") {
  private int i = 0;
  
  @Override 
  public void setup() {
    Behaviour.of(() -> log(i))
      .repeatWhile(() -> i < 5)
      .andThen(() -> stop())
      .addTo(this);
  }
}
