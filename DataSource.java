public class DataSource<T> implements Sharable{
  /** The contents the class will work with. */ 
  private T contents;
  /** A listener for Notifications and updates it. */ 
  private NotificationListener notification = null; 
  
  /** @return Returns the content of the Data Source */ 
  public T getContents(){ return this.contents; }
  /** @param contents Set the contents of the Data Source. */ 
  public void setContents(T contents){ 
    
    this.contents = contents; 
    if(notification != null){
      notification.sendNotification(); 
    }
  }
  
  //Constructor
  public DataSource(T contents){
    setContents(contents); 
  }
  
  //Class methods
  @Override public String name(){ return "data source"; }
  
  //Notification
  
  /** @param n1 Sets the DataSource notification to the one provided */ 
  public void setListener(NotificationListener n1){
    this.notification = n1; 
  }
  
  /** @param n1 Removes the n1 notification from the data Source
    * @return Returns true if n1 was removed sucessfully, false otherwise
    * */
  public boolean removeListener(NotificationListener n1){
    if(n1 == notification){
      notification = null;
      return true;
    }
    return false; 
  }
  
  
}