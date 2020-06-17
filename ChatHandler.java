public class ChatHandler extends GeneralCapability implements MessageSink{
  private Chat chat = null;
  /** @return Returns chat object */ 
  public Chat getChat(){ return chat; }
  
  /** @return Returns true if s is a chat */ 
  @Override public boolean recognizeSharable(Sharable s){
    if(s instanceof Chat){ return true; }
    return false; 
  }
  
  /** @param s Links ChatHandler to the chat object and adds chat object into the Chat's Object message sink*/ 
  @Override public void linkSharable(Sharable s) throws SharableException{
    super.linkSharable(s); 
    chat = (Chat) s; 
    chat.addSink(this);
  }
  /** @param s Unlinks ChatHandler to the chat object and remove chatHandler from the message sink*/ 
  @Override public void unlinkSharable(Sharable s)throws SharableException{
    super.unlinkSharable(s);
    chat.removeSink(this);
    chat = null; 
  }
  
  /** @param message Sends a message from the owner. */ 
  public void send(String message){
    if(getSharable() == null){ return; } // Makes sure the chat is linked
    chat.send(getOwner(), message);
  }
  
  @Override public void deliver(Named sender, String message){
    System.out.printf("%s: %s\n", sender.name(), message);
  }
}