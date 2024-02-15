/**
 * The diagonal composition of two text blocks.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */

public class Diagonal implements TextBlock {

  // +--------------+------------------------------------------------------
  // | Class Fields |
  // +--------------+

    TextBlock tb1;
    TextBlock tb2;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

   public Diagonal(TextBlock tb1, TextBlock tb2) throws Exception {
       this.tb1 = tb1;
       this.tb2 = tb2;
   }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
      /**
   * Get one row from the block.
   * 
   * Combines the two textblock in a diagonal form
   */
   public String row(int i) throws Exception {

    String padTop = TBUtils.spaces(this.tb2.width());
    String padBottom = TBUtils.spaces(this.tb1.width());

    int toph = this.tb1.height();

    int h = this.tb1.height() + this.tb2.height();

    if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
    }
    else if (i < toph) {
        return this.tb1.row(i) + padTop;
    }
    else {
        return padBottom + this.tb2.row(i - toph);
    }
   }

  public int height() {
    return this.tb1.height() + this.tb2.height();
  } // height()

  public int width() {
     return this.tb1.width() + this.tb2.width();
  } // width()

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv(TextBlock other) {
    return (other instanceof Diagonal) && 
      (this.tb1.eqv(((Diagonal) other).tb1)) && 
      (this.tb2.eqv(((Diagonal) other).tb2));
  } // eqv(TextBlock)

}