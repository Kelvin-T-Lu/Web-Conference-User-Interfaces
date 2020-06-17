import java.util.ArrayList;

public class BaseParticipantUI implements Named,Capability {
  /** Owner of the UI */ 
  private Named owner; 
  /** List of capabilities */ 
  protected ArrayList<Capability> list = new ArrayList<Capability>();  
  
  public BaseParticipantUI(String name){
    owner = new Person(name); 
  }
  
  @Override public String name(){ return owner.name(); }
  
  @Override public void setOwner(Named owner){}
  
  /** @param c Adds a capability of the UI */ 
  public final void addCapability(Capability c){
    list.add(c);
    c.setOwner(owner);
  }
  
  /** @param c Removes the capability from the list if valid */ 
  public final boolean removeCapability(Capability c){ return list.remove(c); }
  
  /** @param i Returns a capabaility of index i in the list */ 
  public final Capability getCapability(int i){ return list.get(i);  }
  
  /** @return Return the number of Capabilities */ 
  public final int numCapabilities(){ return list.size(); }
  
  /** @param s Finding a capabiility that is recognizable in the list 
    * @return Return true if a capability is present in the UI can recognize, false otherwise*/ 
  
  @Override public boolean recognizeSharable(Sharable s){
    for(Capability i: list){
      if(i.recognizeSharable(s)){
        return true; 
      }
    }
    return false; 
  }
  /** @param s Tries to link sharable s from the UI list*/ 
  @Override public void linkSharable(Sharable s) throws SharableException{
    boolean test = false; 
    for(Capability i: list){
      try{
        i.linkSharable(s);
        test = true; 
        break;
      }
      catch(SharableException e){
        continue; 
      }
    }
    if(!test){
      throw new SharableException(String.format("Cannot handle Sharable %s", s.name()));
    }
  }
  /** @param s Unlinks the given sharable if applicable */ 
  @Override public void unlinkSharable(Sharable s) throws SharableException{
    boolean test = false; 
    for(Capability i: list){
      try{
        i.unlinkSharable(s);
        test = true; 
        break;
      }
      catch(SharableException e){
        continue; 
      }
    }
    if(!test){
      throw new SharableException("non-matching Sharable");
    }
  }
}