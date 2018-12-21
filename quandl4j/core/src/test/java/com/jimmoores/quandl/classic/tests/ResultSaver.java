package com.jimmoores.quandl.classic.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.jimmoores.quandl.HeaderDefinition;
import com.jimmoores.quandl.MetaDataResult;
import com.jimmoores.quandl.SearchResult;
import com.jimmoores.quandl.TabularResult;
import com.jimmoores.quandl.util.ArgumentChecker;
import com.jimmoores.quandl.util.PrettyPrinter;
import com.jimmoores.quandl.util.QuandlRuntimeException;

/**
 * Class that either saves a sequence of results into files.
 */
public class ResultSaver implements ResultProcessor {
  private static Logger s_logger = LoggerFactory.getLogger(ResultSaver.class);

  private File _baseDir;

  private AtomicLong _fileNumber = new AtomicLong();
  
  /**
   * Create a ResultSaver using the resource folder 'testresults' with it's filename counter set to zero.
   */
  public ResultSaver() {
    File file;
    try {
      file = new File(RecordingRESTDataProvider.class.getResource("testresults/").toURI());
      s_logger.info(file.getAbsolutePath());
      _baseDir = file;
    } catch (URISyntaxException ex) {
      throw new QuandlRuntimeException("Problem parsing path of testdata directory", ex);
    }
  }
  
  /**
   * Create a ResultSaver using a custom base directory with it's filename counter set to zero.
   * @param baseDir the directory in which to save files
   */  
  public ResultSaver(final File baseDir) {
    ArgumentChecker.notNull(baseDir, "baseDir");
    _baseDir = baseDir;
  }
  
  /**
   * Save a TabularResult into a file in pretty printed format.
   * @param tabularResult the tabular result to save
   */
  public final void processResult(final TabularResult tabularResult) {
    ArgumentChecker.notNull(tabularResult, "tabularResult");
    File file = new File(_baseDir, TABULAR + _fileNumber.getAndIncrement() + TXT);
    writeFile(file, PrettyPrinter.toPrettyPrintedString(tabularResult));
  }
  /**
   * Save a MetaDataResult into a file in pretty printed format.
   * @param metaDataResult the metaDataResult object to save
   */
  public final void processResult(final MetaDataResult metaDataResult) {
    ArgumentChecker.notNull(metaDataResult, "metaDataResult");
    processResult(metaDataResult.getRawJSON());
  }
  
  /**
   * Save a map of String to HeaderDefinition.
   * @param multiHeaderDefinitionResult a map of String to HeaderDefinition, not null
   */
  public final void processResult(final Map<String, HeaderDefinition> multiHeaderDefinitionResult) {
    ArgumentChecker.notNull(multiHeaderDefinitionResult, "multiHeaderDefinitionResult");
    File file = new File(_baseDir, METADATA + _fileNumber.getAndIncrement() + TXT);
    writeFile(file, PrettyPrinter.toPrettyPrintedString(multiHeaderDefinitionResult));
  }
  
  /**
   * Save a SearchResult into a file in pretty printed format.
   * @param searchResult the JSON object to save
   */
  public final void processResult(final SearchResult searchResult) {
    processResult(searchResult.getRawJSON());
  }
  
  /**
   * Save a JSONObject into a file in pretty printed format.
   * @param jsonObject the JSON object to save
   */
  private void processResult(final JSONObject jsonObject) {
    File file = new File(_baseDir, METADATA + _fileNumber.getAndIncrement() + JSON);
    // subtlety alert! The JSON object pretty printer adds a line separator at the end of the string to match the tabular result pretty printer.
    // This means when these are read back from a file, every line is terminated with a line separator.
    writeFile(file, PrettyPrinter.toPrettyPrintedString(jsonObject)); 
  }
  
  private void writeFile(final File file, final String contents) {
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.append(contents);
      writer.close();
    } catch (IOException ex) {
      Assert.fail();
    }
  }


}
