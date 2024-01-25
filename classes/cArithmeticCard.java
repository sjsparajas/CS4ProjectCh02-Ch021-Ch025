import java.util.*;

public class cArithmeticCard extends cCard{
  protected int additiveValue;
  protected int multiplicativeValue;

  public cArithmeticCard(String n, int v, int v2){
    super.cCard(n,1);
    additiveValue=v;
    multiplicativeValue=v2;
  }
}