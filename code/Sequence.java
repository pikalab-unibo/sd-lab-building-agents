public class Sequence implements Behaviour {

  private Deque<Behaviour> subBehaviours = new LinkedList<>();
  
  public Sequence(Behaviour b, Behaviour... bs) {
    subBehaviours.add(b);
    subBehaviours.addAll(Arrays.asList(bs));
  }

  @Override
  public boolean isPaused() {
    Behaviour nextBehaviour = subBehaviours.peek();
    return nextBehaviour != null && nextBehaviour.isPaused();
  }

  @Override
  public boolean isOver() {
    return subBehaviours.isEmpty();
  }
%*\framebreak*)
  @Override
  public void execute(BehaviouralAgent agent) throws Exception {
    final Behaviour nextBehaviour = subBehaviours.poll();
    try {
      if (nextBehaviour != null) {
        nextBehaviour.execute(agent);
      }
    } finally {
      if (nextBehaviour != null && !nextBehaviour.isOver()) {
        subBehaviours.addFirst(b);
      }
    }  
  }
  
}