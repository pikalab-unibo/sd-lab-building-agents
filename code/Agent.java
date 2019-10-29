public interface Agent {
    // Naming
    String getFullName();
    String getLocalName();
    
    // Callbacks
    void onBegin() throws Exception;
    void onRun() throws Exception;
    void onEnd() throws Exception;
    AndThen onUncaughtError(Exception e);

    // Control methods
    Agent start();
    Agent stop();
    Agent pause();
    Agent resume();
    Agent restart();
    void await(Duration duration) throws ...;
    void await() throws ...;

    // Binding to the environment
    Environment getEnvironment();
    
    // To change the environment this agent is bound to
    void setEnvironment(Environment environment);
    
    // Agents borrow the Environment's engine
    default ExecutorService getEngine() { 
      return getEnvironment() != null 
        ? getEnvironment().getEngine() 
        : null;
    }
}