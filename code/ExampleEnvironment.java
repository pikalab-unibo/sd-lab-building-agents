Environment<?> env = Environment.multiThreaded();

env.createAgent(ExampleAgentFSM.class, "Alice").start();

env.awaitAllAgentsStop(MAX_WAIT);
