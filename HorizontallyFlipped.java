/**
 * The horizontal flipping of a text block.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */

public class HorizontallyFlipped implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  private TextBlock tb1;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public HorizontallyFlipped(TextBlock tb1) {
    this.tb1 = tb1;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
    /**
   * Get one row from the block.
   * 
   * horizontally flipe the block
   */
  public String row(int i) throws Exception {
    return new StringBuilder(tb1.row(i)).reverse().toString();
  }


  public int height() {
    return 1;
  }

  public int width() {
    return tb1.width();
  }

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof HorizontallyFlipped) && 
      (this.tb1.eqv(((HorizontallyFlipped) other).tb1));
  } // eqv(TextBlock)
}