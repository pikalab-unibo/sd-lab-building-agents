public class Wait implements Behaviour {

  private final Duration duration;
  private boolean started;
  private OffsetDateTime clock;
  private boolean ended;

  public Wait(Duration duration) {
    this.duration = duration;
  }
  
  @Override
  public boolean isOver() { return ended; }
%*\framebreak*)  
  @Override
  public void execute(BehaviouralAgent agent) {
    if (started) {
      if (getElapsedMillis() >= duration.toMillis()) {
        ended = true;
      }
    } else {
      started = true;
      clock = OffsetDateTime.now();
    }
  }
  
  private long getElapsedMillis() {
    return ChronoUnit.MILLIS.between(clock, OffsetDateTime.now());
  }
}
