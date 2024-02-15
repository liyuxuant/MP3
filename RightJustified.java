/**
 * The right-justified version of a text block.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 * 
 */

public class RightJustified implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  TextBlock tb1;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public RightJustified(TextBlock tb1, int width) throws Exception {
      if (tb1.width() > width) {
          throw new Exception("Width must be greater than or equal to the block's width.");
      }
      this.tb1 = tb1;
      this.width = width;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
    /**
   * Get one row from the block.
   * 
   * builds a new block that right-justifies the input block within that width.
   */
  public String row(int i) throws Exception {
      String row = tb1.row(i);
      return " ".repeat(width - row.length()) + row;
  }

  public int height() {
      return 1;
  }

  public int width() {
      return this.width;
  }

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof RightJustified) && 
      (this.tb1.eqv(((RightJustified) other).tb1));
  } // eqv(TextBlock)
}
  

