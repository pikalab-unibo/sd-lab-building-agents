public interface Environment {

  // Environments have a name
  String getName();
  
  // Each environment wraps a set of agents
  Set<Agent> getAgents();
  
  // Shared textual spaces can be retrieved by names
  TextualSpace getTextualSpace(String name);
  
  // A shared ExecutorService is exposed for agents
  ExecutorService getEngine();

  // Existing agents can join the environment
  <A extends Agent> A registerAgent(A agent);
  
  // New agents can be created within the environment
  <A extends Agent> A createAgent(Class<A> clazz, String name, Object... args);


  // Users can block until all agents are done
  Environment awaitAllAgentsStop(Duration duration) throws ...;

  // Gracefully shutdown the executor service
  Environment shutdown();
  
  // Users can block until the executor service is over
  Environment awaitShutdown(Duration duration) throws ...;
}