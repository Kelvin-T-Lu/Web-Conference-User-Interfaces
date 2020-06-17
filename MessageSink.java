public interface MessageSink {
  /** 
   * Delivers a message from a given sender
   * @param sender The Sender of the message
   * @param message The message being delivered 
   * */ 
  void deliver(Named sender, String message);
}