new BaseBehaviouralAgent("Alice") {
  @Override public void setup() {
    Behaviour.of(() -> print("hello"))
      .andThen(Behaviour.send("Bob", "world"))
      .andThen(() -> stop())
      .addTo(this);
  }
}