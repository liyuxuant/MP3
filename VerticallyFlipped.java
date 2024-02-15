/**
 * The vertical flipping of a text block.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */

public class VerticallyFlipped implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  private TextBlock tb1;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public VerticallyFlipped(TextBlock tb1) {
    this.tb1 = tb1;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
      /**
   * Get one row from the block.
   * 
   * Vertically plipped the block
   */
  public String row(int i) throws Exception {
    return tb1.row(tb1.height() - 1 - i);
  }

  public int height() {
    return tb1.height();
  }

  public int width() {
    return tb1.width();
  }

   /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof VerticallyFlipped) && 
      (this.tb1.eqv(((VerticallyFlipped) other).tb1));
  } // eqv(TextBlock)
}
  

