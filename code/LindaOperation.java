public abstract class LindaOperation<R> extends Await<R> {

  @Override
  public final CompletableFuture<R> getPromise(BehaviouralAgent agent) {
    return invokeOnTupleSpace(
      agent, 
      agent.getEnvironment()
        .getTextualSpace(getTupleSpaceName(agent))
    );
  }
  
  public abstract CompletableFuture<R> invokeOnTupleSpace(BehaviouralAgent agent, TextualSpace tupleSpace);

  public abstract String getTupleSpaceName(BehaviouralAgent agent);
  
  /* callback getResult(...) is inherited by Await  */
}
