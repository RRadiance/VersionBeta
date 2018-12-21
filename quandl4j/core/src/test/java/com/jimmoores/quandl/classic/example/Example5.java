package com.jimmoores.quandl.classic.example;

import com.jimmoores.quandl.SearchRequest;
import com.jimmoores.quandl.SearchResult;
import com.jimmoores.quandl.classic.ClassicQuandlSession;

/**
 * Example 4.
 */
public final class Example5 {

  /**
   * Private default constructor.
   */
  private Example5() {
  }
 
  /**
   * The main body of the code.
   */
  private void run() {
    ClassicQuandlSession session = ClassicQuandlSession.create();
    SearchResult searchResult = session.search(SearchRequest.Builder.ofQuery("Apple").withMaxPerPage(2).build());
    System.out.println(searchResult.toPrettyPrintedString());
  }

  /**
   * Main entry point.
   * @param args command line arguments
   */
  public static void main(final String[] args) {
    Example5 example = new Example5();
    example.run();
  }
}
