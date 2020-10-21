new AbstracAgent("seq-example") {
  @Override 
  public void setup() {
    Behaviour.sequence(
        Behaviour.of(() -> log("a") ),
        Behaviour.of(() -> log("b") ),
        Behaviour.of(() -> log("c") ),
        Behaviour.of(() -> stop()   ),
    ).addTo(this);
  }
}
