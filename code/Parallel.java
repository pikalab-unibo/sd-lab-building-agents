public class Parallel implements Behaviour {

  public enum TerminationCriterion { ANY, ALL }
  
  private LinkedList<Behaviour> subBehaviours = new LinkedList<>();
  private TerminationCriterion criterion;
  private boolean shortCircuitEnd = false;

  public Parallel(TerminationCriterion c, Behaviour b, Behaviour... bs) {
    this.criterion = c;
    subBehaviours.add(b);
    subBehaviours.addAll(Arrays.asList(bs));
  }
%*\framebreak*)

  @Override
  public boolean isOver() {
    if (criterion == TerminationCriterion.ALL) {
      return subBehaviours.isEmpty();
    else
      return shortCircuitEnd || subBehaviours.isEmpty();
  }
  
  @Override
  public boolean isPaused() {
    return subBehaviours.stream()
        .allMatch(Behaviour::isPaused);
  }
%*\framebreak*)
  @Override
  public void execute(BehaviouralAgent agent) throws Exception {
    final Queue<Behaviour> skipped = new LinkedList<>();
    Behaviour behaviour = subBehaviours.poll();
    try {
      while (behaviour != null && behaviour.isPaused()) {
        skipped.add(behaviour);
        behaviour = subBehaviours.poll();
      }
      if (behaviour != null) behaviour.execute(agent);
    } finally {
      if (behaviour != null && !behaviour.isOver())
        subBehaviours.addLast(behaviour);
      else if (criterion == TerminationCriterion.ANY)
        shortCircuitEnd = true;
      subBehaviours.addAll(skipped);
    }
  }
}