new BaseBehaviouralAgent("linda-op") {
  private int i = 0;
  
  @Override public void setup() {
    Behaviour.lindaOperation("inbox",
                ts -> ts.in("msg\\{.*?}"),
                tuple -> print(tuple)
        ).andThen(() -> stop())
        .addTo(this);
  }
}
