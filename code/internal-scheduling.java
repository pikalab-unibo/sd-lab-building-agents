@Override public void onRun() throws Exception {
  if (toDoList.isEmpty()) { // if nothing to do...
    pause(); return; // ... pause the agent and quit
  }
  // queue to keep track of skipped behaviours
  final Queue<Behaviour> skipped = new LinkedList<>();
  Behaviour behaviour = toDoList.poll();
  try { // skip all PAUSED behaviours
    while (behaviour != null && behaviour.isPaused()) {
      skipped.add(behaviour);
      behaviour = toDoList.poll(); // poll() removes queue head
    }
    if (behaviour == null) pause(); // pause if no more behaviors
    else behaviour.execute(this); // otherwise execute non-paused
  } finally {
    if (behaviour != null && !behaviour.isOver())
      toDoList.add(behaviour);  // re-schedule if non-terminated
    toDoList.addAll(skipped); // reschedule skipped behaviours
  }
}