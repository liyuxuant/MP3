/**
 * One line of text.
 * 
 * @author Samuel A. Rebelsky
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */
public class TextLine implements TextBlock {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The contents of the line.
   */
  String line;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Build a new line with the specified contents.
   */
  public TextLine(String line) {
    this.line = line;
  } // TextLine(String)

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i == 0
   * @exception Exception if i != 0
   */
  public String row(int i) throws Exception {
    if (i != 0) {
      throw new Exception("Invalid row " + i);
    } // if the row is invalid
    return this.line;
  } // row(int)

  /**
   * Determine how many rows are in the block.
   */
  public int height() {
    return 1;
  } // height()

  /**
   * Determine how many columns are in the block.
   */
  public int width() {
    return this.line.length();
  } // width()

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof TextLine);
  } // eqv(TextBlock)

} // class TextLine
