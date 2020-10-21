public abstract class Await<T> implements Behaviour {

  private enum Phase { CREATED, PAUSED, COMPLETED, DONE }
  
  private Phase phase = Phase.CREATED;
  private CompletableFuture<T> promiseCache;
  
  // callbacks
  
  public abstract CompletableFuture<T> getPromise(BehaviouralAgent agent);
  
  public abstract void onResult(BehaviouralAgent agent, T result);
%*\framebreak*) 

  @Override
  public boolean isPaused() { 
    return phase == Phase.PAUSED; 
  }

  @Override
  public boolean isOver() { 
    phase == Phase.DONE; 
  }
  
  @Override
  public Behaviour deepClone() {
    throw new IllegalStateException("You must override the deepClone method in class " + this.getClass().getName());
  }
  
%*\framebreak*)

  @Override
  public void execute(BehaviouralAgent agent) throws Exception {
    if (phase == Phase.CREATED) {
      promiseCache = getPromise(agent);
      promiseCache.thenRunAsync(() -> {
        phase = Phase.COMPLETED;
        agent.resumeIfPaused();
      }, agent.getEngine());
      phase = Phase.PAUSED;
    } else if (phase == Phase.COMPLETED) {
      onResult(agent, promiseCache.get());
      phase = Phase.DONE;
    } else {
      throw new IllegalStateException("This should never happen");
    }
  }
}
