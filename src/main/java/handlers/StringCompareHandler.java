package handlers;

public class StringCompareHandler implements CompareHandler<String> {

  @Override
  public int compare(String first, String second) {
    return first.compareTo(second);
  }

}
