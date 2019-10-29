Environment env = new LocalEnvironment(
    Executors.newSingleThreadExecutor()
);

env.createAgent(Receiver.class, "Bob").start();
env.createAgent(Receiver.class, "Carl").start();
env.createAgent(Sender.class, "Alice").start();

env.awaitAllAgentsStop(MAX_WAIT);