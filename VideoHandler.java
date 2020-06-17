public class VideoHandler extends GeneralCapability implements NotificationListener{
  private VideoSource source = null;
  
  public VideoSource getVideoSource(){ return this.source; } 
  
  /** @param s Returns true if s is a VideoSource */ 
  @Override public boolean recognizeSharable(Sharable s){ 
    if(s instanceof VideoSource){ return true; }
    return false; 
  }
  
  @Override public void linkSharable(Sharable s) throws SharableException{
    super.linkSharable(s);
    source = (VideoSource) s; 
    source.setListener(this);
  }
  
  @Override public void unlinkSharable(Sharable s) throws SharableException{
    super.unlinkSharable(s);
    source.removeListener(new VideoHandler());
    source = null; 
  }
  
  /** Sends a notification when the contents of source is updated */ 
  @Override public void sendNotification(){
    if(source != null){ 
      System.out.printf("%s\n", source.getContents()); 
    }
  }
  
}