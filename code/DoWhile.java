public class DoWhile extends Sequence {

  private final Deque<Behaviour> backup;
  private boolean isEndOfRound = false;
  
  public DoWhile(Behaviour b, Behaviour... bs) {
    super(b, bs);
    backup = getSubBehaviours().stream()
          .map(b -> b.deepClone())
          .collect(toCollection(LinkedList::new));
  }
%*\framebreak*)
  
  @Override  // Loops never terminate by default
  public boolean condition() { return true; }
  
  /* method isPaused() is inherited from Sequence */
  
  @Override
  public boolean isOver() {
    return isEndOfRound && !condition();
  }
%*\framebreak*)
  @Override
  public void execute(BehaviouralAgent agent) throws Exception {
    isEndOfRound = false;
    super.execute(agent);
    
    if (getSubBehaviours().size() == 0) {
      isEndOfRound = true;
      getSubBehaviours().addAll(
        behavioursBackup.stream()
          .map(b -> b.deepClone())
          .collect(Collectors.toList())
      );
    }
  }
  
  /* method getSubBehaviours() is inherited from Sequence */
}
