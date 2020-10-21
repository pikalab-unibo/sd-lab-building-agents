interface Agent extends AgentFSM {
    
    Queue<Behaviour> getToDoList(); // Scheduling queue

    void setup();     // Callback to be called AFTER startup
    void tearDown(); // Callback to be called BEFORE termination

    // Methods for adding or removing behaviours
    BehaviouralAgent addBehaviour(Behaviour behaviour);
    BehaviouralAgent removeBehaviour(Behaviour behaviour);
}
