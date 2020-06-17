public abstract class GeneralCapability implements Capability{
  /** Owner of the UI */ 
  private Named owner = null; 
  private Sharable sharable = null; 
  
  /** @return Returns the named owner of the UI */
  public Named getOwner(){ return owner; }
  /** @param owner Sets the owner of the UI */ 
  public void setOwner(Named owner){ this.owner = owner; };  
  /** @return The shareable associated with the capability. */ 
  public Sharable getSharable(){ return this.sharable; }
  
  //Class methods 
  /** @param s Establish a link between capability and sharable if valid*/ 
  @Override public void linkSharable(Sharable s) throws SharableException{
    if(!recognizeSharable(s)){ throw new SharableException(String.format("cannot handle Sharable %s", s.name())); } //Incompatible sharable
    if(sharable != null) { throw new SharableException("Capability is already linked to a Sharable"); } //Already linked sharable
    sharable = s; 
  } 
  /** @param s Unlinks the sharable if valid */ 
  @Override public void unlinkSharable(Sharable s) throws SharableException{
    if(s == null) { throw new SharableException("non-matching Sharable"); } //If there's no linked sharable
    if(sharable != s) { throw new SharableException("non-matching Sharable"); } //Different sharable } 
    
    sharable = null; 
  }
  
}