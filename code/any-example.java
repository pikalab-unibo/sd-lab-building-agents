new AbstractAgent("any-example") {
  @Override public void setup() {
    Behaviour.anyOf(
        Behaviour.of(() -> log(1))
            .andThen(() -> log(2)),

        Behaviour.of(() -> log("a"))
            .andThen(() -> log("b"))
            .andThen(() -> log("c"))
    ).andThen(() -> stop())
    .addTo(this);
  }
}
