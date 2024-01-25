import java.util.*;

public class pPlayer extends pPerson{
  protected int chips;
  protected ArrayList<cArithmeticCard> hiddenDeck;
  protected int deckValue;

  public void pPlayer(String name){
    chips=0;
    hiddenDeck = new ArrayList<>();
    super.pPerson(name);
  }

public int getChips() {
	return chips;
}

public void setChips(int money) {
	chips+=money;
}

public void draw(ArrayList<cCard> a){
  if (a.get(0) instanceof cArithmeticCard){
    hiddenDeck.add(a.get(0));
  } else {
    deck.add(a.get(0));
    deckValue+=a.get(0).getValue();
  } 
  System.out.println("You drew a " + a.get(0).getName());
  a.pop(0);
}
  
}