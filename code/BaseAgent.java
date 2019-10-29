abstract class BaseAgent implements Agent {

  protected enum States {
    CREATED, STARTED, RUNNING, PAUSED, STOPPED
  }

  // Current state of FSA
  private States currentState = States.CREATED;
  
  // Next input for FSA
  private AndThen nextOperation = null;
  
  // Promise to be completed after onEnd()
  private final CompletableFuture<Void> termination = 
    new CompletableFuture<>();
  
  %*\framebreak*)
  
  public Agent start() {
    doStateTransition(AndThen.CONTINUE); return this;
  }
  
  public Agent resume() {
    doStateTransition(AndThen.CONTINUE); return this;
  }
  
  public Agent pause() {
    doStateTransition(AndThen.PAUSE); return this;
  }
  
  public Agent stop() {
    if (currentStateIs(States.PAUSED))
      doStateTransition(AndThen.STOP);
    else
      nextOperation = AndThen.STOP;
    return this;
  }
  %*\framebreak*)
  
  // General method for state transition
  // from any state to any state
  private void doStateTransition(AndThen whatToDo) {
    switch (currentState) {
      case CREATED:
        doStateTransitionFromCreated(whatToDo); break; // <--
      case STARTED:
        doStateTransitionFromStarted(whatToDo); break;
      case RUNNING:
        doStateTransitionFromRunning(whatToDo); break;
      case PAUSED:
        doStateTransitionFromPaused(whatToDo); break;
      case STOPPED:
        doStateTransitionFromStopped(whatToDo); break;
      default: 
        throw new IllegalStateException("Illegal state: " + state);
    }
  }
  %*\framebreak*)
  
  // General method for state transition
  // from the CREATED state to any state
  protected void doStateTransitionFromCreated(AndThen whatToDo){
    switch (whatToDo) {
      case CONTINUE:
        state = States.STARTED;
        doBegin(); // this is where onBegin() is indirecly called
        break;
        
      default: 
        throw new IllegalArgumentException("Unexpected transition")
    }
  }
  
  %*\framebreak*)
  
  // We need to ensure that onBegin() is executed on  
  // the ExecutorService returned by this.getEngine()
  private void doBegin() {
    getEngine().submit(this::begin);
  }
  
  // We also need to capture uncaught exceptions
  private void begin() {
    nextOperation = AndThen.CONTINUE;
    try {
      onBegin(); // Actual callback invocation
    } catch (Exception e) {
      nextOperation = onUncaughtError(e);
    } finally {
      doStateTransition(nextOperation);
    }
  }
  
  // Notice the flow doBegin -> begin -> onBegin
}