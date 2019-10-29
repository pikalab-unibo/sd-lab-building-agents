class Receiver extends BaseAgent {

  public Receiver(String name) {
    super(name);
  }

  @Override
  public void onRun() throws Exception {
    getEnvironment()
        .getTextualSpace("someTS")
        .rd("message\\{.*?\\}") // RD
        .thenApplyAsync(t -> stop(), getEngine());
    pause();
  }
}