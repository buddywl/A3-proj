
  /** Nested class to keep track of nodes */
  public class NodeSL<T> {
      /** The data at the node */
      private T data;

      
      /** Link to the next node */
      private NodeSL<T> next;

      /** A constructor */
      NodeSL(T data){
          this.data = data;
      }

      NodeSL(T data, NodeSL<T> next) {
          this.data = data;
          this.next = next;
      }

      /** @return data field */
      public T getData() {
        return data;
      }

      /** @param d new data value */
      public void setData(T d) {
        this.data = d;
      }

      /** @return next node */
      public NodeSL<T> getNext() {
        return next;
      }

      /** @param next new next node */
      public void setNext(NodeSL<T> next) {
        this.next = next;
      }
    }