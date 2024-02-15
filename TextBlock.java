/**
 * Simple blocks of text for a lab on polymorphism
 * 
 * @author Samuel A. Rebelsky
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */

public interface TextBlock {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Get one row from the block.
   * 
   * @pre i < this.height()
   * @exception Exception if the row number is invalid.
   */
  public String row(int i) throws Exception;

  /**
   * Determine how many rows are in the block.
   */
  public int height();

  /**
   * Determine how many columns are in the block.
   */
  public int width();

  /**
   * Determine if two blocks are structurally the same.
   */
  public boolean eqv (TextBlock other);

} // interface TextBlock
