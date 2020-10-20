public interface AgentFSM {
    // Naming
    AID getAID();
    void setAid(AID aid);
    
    // Callbacks
    void onBegin() throws Exception;
    void onRun() throws Exception;
    void onEnd() throws Exception;
    void onUncaughtError(Exception e);

    // Control methods
    void start();
    void stop();
    void pause();
    void resume();
    void restart();
    void resumeIfPaused();
    
    
    // Awaiting termination
    void await(Duration duration) throws ...;
    void await() throws ...;

    // Binding to the environment
    Environment<?> getEnvironment();
    
    // To change the environment this agent is bound to
    void setEnvironment(Environment<?> environment);
}
