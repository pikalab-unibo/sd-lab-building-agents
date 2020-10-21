new BaseBehaviouralAgent("Bob") {
  @Override public void setup() {
    Behaviour.receive(
          msg -> print(msg.getContent())
      )
      .andThen(() -> stop())
      .addTo(this);
  }
}