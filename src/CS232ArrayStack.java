public class CS232ArrayStack<E> implements CS232Stack<E> {
  private CS232ArrayList<E> list;

  public CS232ArrayStack() {
    list = new CS232ArrayList<>();
  }

  @Override
  public void push(E obj) {
    list.add(obj);
  }

  @Override
  public E pop() {
    if (list.size() ==  0) {
      throw new IndexOutOfBoundsException("Cannot pop from an empty stack");
    }
    return list.remove(list.size() - 1);
    
  }

  @Override
  public E peek() {
    if (list.size() == 0) {
      throw new IndexOutOfBoundsException("Cannot peek from an empty stack");
    }
    return list.get(list.size() - 1);
  }

  @Override
  public int size() {
    return list.size();
  }
}