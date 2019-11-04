class Sender extends BaseAgent {

  public Sender(String name) {
    super(name);
  }

  @Override
  public void onRun() throws Exception {
    getEnvironment()
        .getTextualSpace("someTS")
        .out("message{hello}") // OUT
        .thenApplyAsync(t -> stop(), getEngine());
    pause();
  }
}