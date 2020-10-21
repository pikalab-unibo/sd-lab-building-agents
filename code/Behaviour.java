@FunctionalInterface
public interface Behaviour {

  // Encapsulate the actual business logic of this behaviour
  void execute(BehaviouralAgent agent) throws Exception;

  // Check if this behaviour is paused
  default boolean isPaused() { return false; }

  // Check if this behaviour has terminated its activity
  default boolean isOver() { return true; }

  // Create a fresh copy of this behaviour and its sub-behaviours
  default Behaviour deepClone() { return this; }
  
  
  /* OTHER STUFF HERE */
}