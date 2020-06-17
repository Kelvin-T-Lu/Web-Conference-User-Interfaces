import java.util.ArrayList; 

public class Chat implements Sharable{
  private ArrayList<MessageSink> sink = new ArrayList<MessageSink>(); 
  
  /** Delivers a specified message to all of the Message sink */
  public void send(Named sender, String message){
    for(MessageSink i: this.sink){
      i.deliver(sender, message);
    }
  }
  /** @param s Adds a MessageSink to the sink list. */ 
  public void addSink(MessageSink s){
    sink.add(s);
  }
  
  /** @param s Removes s from list if applicable*/ 
  public boolean removeSink(MessageSink s){
    return sink.remove(s);
  }
  
  @Override public String name(){ return "chat"; }    
  
}