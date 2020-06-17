import java.util.ArrayList;
public class ParticipantUI extends BaseParticipantUI{
  public ParticipantUI(String name){
    super(name); 
    addCapability(new ChatHandler());
    addCapability(new VideoHandler()); 
  }
  public void send(String message){
    for(Capability i: list){
      if(i instanceof ChatHandler){
        ChatHandler x = (ChatHandler) i; 
        x.send(message); 
      }
    }
    
  }
}