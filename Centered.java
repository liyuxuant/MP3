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
        String row = tb1.row(i);
        int padding = (width - row.length()) / 2;
        return " ".repeat(padding) + row + " ".repeat(padding);
    }

  public int height() {
    return 1;
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
  

