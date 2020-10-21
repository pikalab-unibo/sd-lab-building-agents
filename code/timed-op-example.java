new AbstractAgent("timed-operation") {
  @Override 
  public void setup() {
    Behaviour.anyOf(
        /* some durable behaviour here */

        Behaviour.wait(
          Duration.ofSeconds(3)
        )
    ).andThen(() -> stop())
    .addTo(this);
  }
}
