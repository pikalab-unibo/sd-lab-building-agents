new AbstractAgent("seq-example-2"){
  @Override 
  public void setup() {
    Behaviour.of(() -> print("a") )
        .andThen(() -> print("b") )
        .andThen(() -> print("c") )
        .andThen(() -> stop()     )
        .addTo(this);
  }
}
