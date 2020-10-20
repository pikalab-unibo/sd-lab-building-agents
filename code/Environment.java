interface Environment<A extends AgentFSM> {

  // Environments have a name
  String getName();
  
  // Each environment wraps a set of agents
  Set<AID> getAgents();

  // Existing agents can join the environment
  A registerAgent(A agent);
  
  // New agents can be created within the environment
  A createAgent(Class<A> clazz, String name, Object... args);
%*\framebreak*)

  // Users can block until all agents are done
  void awaitAllAgents(Duration duration);
  
  
  // Creates a new environment where each agent has its own thread
  static Environment<A> multiThreaded(String name)
  
  // Creates a new environment where all agent run on the same executor service
  static Environment<A> executorBased(String name)
}
