/**
 * The centered version of a text block.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 * 
 */
public class Centered implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  TextBlock tb1;
  int width;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Centered(TextBlock tb1, int width) throws Exception {
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
   * builds a new block that centers the block within that width.
   */
  public String row(int i) throws Exception {
    int contentWidth = tb1.width();
    int whiteSpaceWidth = (width - contentWidth) / 2;

    if ((width - contentWidth) == 1) {
      return " " + tb1.row(i);
    }
    return TBUtils.spaces(whiteSpaceWidth) +  tb1.row(i) + TBUtils.spaces(whiteSpaceWidth);
  }

  public int height() {
    return tb1.height();
  } // height()

  public int width() {
    return width;
  } // width()

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof Centered) && 
      (this.tb1.eqv(((Centered) other).tb1));
  } // eqv(TextBlock)
}
  

