public class SearchResult<T> {
  public int counter;
  public TElementoAB<T> inserted;

  public SearchResult(int counter, TElementoAB<T> inserted) {
    this.counter = counter;
    this.inserted = inserted;
  }
}
