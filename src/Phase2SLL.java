public interface Phase2SLL<T> {
  /** 
   *  Inserts the given item at the tail of the list
   *  @param v to insert
   */
  void addLast(T v);

  /** 
   *  Inserts the given item after the specified node
   *  @param here node to insert after
   *  @param v item to insert 
   */
  void addAfter(NodeSL<T> here, T v);

  /** 
   *  Removes the given item from the head of the list
   *  @return item removed
   */
  T removeFirst();

  /** 
   *  Removes the given item from the tail of the list
   *  @return item removed
   */
  T removeLast();

  /** 
   *  Removes the node after the given position
   *  @param here marks position to remove after
   *  @return item removed
   */
  T removeAfter(NodeSL<T> here);

  /**
   *  Returns a count of the number of elements in the list
   *  @return current number of nodes
   */
  int size();
}