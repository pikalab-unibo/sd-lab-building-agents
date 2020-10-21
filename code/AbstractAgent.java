public abstract class AbstractAgent 
    extends ThreadBasedAgentFSM implements Agent {

  private final Queue<Behaviour> toDoList = new LinkedList<>();
  private final Set<Behaviour> toBeRemoved = new HashSet<>();

  @Override public final void onBegin() { setup(); }
  @Override public void setup() { /* to be overridden */ }
  
  @Override public final void onEnd() { tearDown(); }
  @Override public void tearDown() { /* to be overridden */ }
%*\framebreak*)
  @Override
  public void addBehaviour(Behaviour behaviour) {
    toDoList.add(behaviour);
    resumeIfPaused(); // notice this!
  }
  
  @Override
  public void removeBehaviour(Behaviour behaviour) {
    toBeRemoved.add(behaviour);
    resumeIfPaused(); // notice this!
  }

  @Override public void onRun() throws Exception {
    // TODO implement internal scheduling here
  }
}
