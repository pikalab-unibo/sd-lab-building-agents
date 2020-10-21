new AbstractAgent("seq-example-2"){
  @Override 
  public void setup() {
    Behaviour.of(() -> log("a") )
        .andThen(() -> log("b") )
        .andThen(() -> log("c") )
        .andThen(() -> stop()   )
        .addTo(this);
  }
}
