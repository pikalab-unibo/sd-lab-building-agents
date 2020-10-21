class ExampleAgentFSM /* ... */ {
  int x = 0;
  
  void onBegin() throws Exception {
    log(x++);
    if (x >= 1) { throw new IllegalStateException(); }
  }
  
  void onRun() throws Exception {
    if (x < 5) {
      log(x++);
    } else {
      throw new NullPointerExecption();
    }
  }
  
  void onEnd() throws Exception {
    log(x);
  }
  
  void onUncaughtError(Exception e) {
    log(x++);
    if (e instanceof NullPointerExecption()) {
      stop();
    }
  }
}
