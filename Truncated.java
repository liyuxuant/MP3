/**
 * The truncated version of a text block.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 * 
 */
public class Truncated implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

  int max_width;
  TextBlock tb1;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public Truncated(TextBlock tb1, int max_width) throws Exception {
    if(tb1.width() < max_width) {
      throw new Exception("Error max_width greater than current width");
    }
    this.max_width = max_width;
    this.tb1 = tb1;
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   *builds a new block that truncates the input block to that width.
   */
  public String row(int i) throws Exception {
    if (i > this.tb1.height()) {
      throw new Exception("Invalid max_width " + i);
    } // if the row is invalid
    return tb1.row(i).substring(0, this.max_width);
  } // row(int)

  public int height() {
    return 1;
  } // height()

  public int width() {
    return max_width;
  } // width()
  
  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof Truncated) && 
      (this.tb1.eqv(((Truncated) other).tb1));
  } // eqv(TextBlock)
    
}
