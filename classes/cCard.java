import java.util.*;

public class cCard {
  protected String name;
  protected int value;

  public cCard(String n, int v){
    this.name = n;
    this.value = v;
  }

  public String getName() {
    return name;
  }

  public int getValue(){
    return this.value;
  }
}