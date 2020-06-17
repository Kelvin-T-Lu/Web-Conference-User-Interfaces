public class VideoSource extends DataSource<String>{
  //Constructors 
  /** A source of updating Video data */ 
  public VideoSource(String contents){
    super(contents);
  }
  public VideoSource(){
    this("");
  }
  
  @Override public String name(){ return "video source"; }
}