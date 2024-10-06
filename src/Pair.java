public class Pair<T, U> {
  private T first;
  private U second;

  public Pair(T first, U second) {
    this.first = first;
    this.second = second;
  }

  public T getFirst() {
    return first;
  }

  public U getSecond() {
    return second;
  }

  public void setFirst(T first) { 
    this.first = first;
  }

  public void setSecond(U second) {
    this.second = second;
  }

  // Question 2
  public static void main(String[] args) {
    // i. Integer Pair
    Pair<Integer, Integer> intPair = new Pair<>(10, 20);

    // ii. Double and String Pair
    Pair<Double, String> mixPair = new Pair<>(3.14, "Pi");

    // iii. Pair of Pairs
    Pair<Pair, Pair> pairPair = new Pair<>(intPair, mixPair);

  }
}