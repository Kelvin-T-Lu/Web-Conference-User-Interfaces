public class Person implements Named{
  private String name; 
  
  public Person(String name){
    this.name = name; 
  }
  
  /*
   * @return Returns a person's name
   */
  @Override public String name(){
    return this.name; 
  }
}
  