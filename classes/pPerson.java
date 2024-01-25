import java.util.ArrayList; 

public abstract class pPerson{
  protected String name;
  protected  ArrayList<cCard> deck;

  public void pPerson(String n){
    name = n;
    deck = new ArrayList<>();
  }

  public String getName(){
    return name;
  }
}