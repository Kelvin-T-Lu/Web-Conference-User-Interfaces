public interface Capability{
  /** @return True if the object understands how to process the data stream. 
    * @param s The sharable object that is being established a link to. 
    */
  public boolean recognizeSharable(Sharable s);
  /** 
   * @param s Creates a link between the Capability and input Shareable
   * @exception SharableException if input is incomptabile with Capability or if Capability is accepting another input
   */
  public void linkSharable(Sharable s) throws SharableException;
  /** 
   * @param s Unlink a Capability to the input Sharable
   * @exception SharableException if input is not recognized 
   */ 
  public void unlinkSharable(Sharable s) throws SharableException;
  /**
   * @param owner Informs Capability the owner of the user interface 
   */ 
  public void setOwner(Named owner); 
}