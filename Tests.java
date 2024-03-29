import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Tests {
  /**
 * Tests of the for MP3.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
   * @throws Exception
 * 
 */


  @Test
  public void truncatedTest() throws Exception  {
    TextBlock tb1 = new TextLine("Hello, World");
    TextBlock empty = new TextLine("");
    int maxWidth = 3;
    
    TextBlock truncated = new Truncated(tb1, maxWidth);
    assertEquals("width equals max_width", truncated.width(), 3) ;
    
    TextBlock emptyt = new Truncated(empty, 0);
    assertEquals("width equals 0", emptyt.width(), 0) ;

  }

  @Test
  public void centeredTest () throws Exception {
      TextBlock tb1 = new TextLine("Hello World");
      TextBlock centered = new Centered(tb1, 18);
      
      assertEquals("Centered the block", centered.width(), 18);

      // Checking for correct spacing row by row
      String c;
      for (int i = 0; i < centered.height(); i++) {
        c = centered.row(i);
        assertEquals("Correct spacing", c.substring(0, 3), "   ");
        assertEquals("Correct spacing", c.substring(c.length() - 3), "   ");
      }
  }

  @Test
  public void rightJustifiedTest() throws Exception {
    TextBlock tb1 = new TextLine("Hellow World");
    TextBlock rBlock = new RightJustified(tb1, 20);

    assertEquals("rightJustified creates block of correct width", rBlock.width(), 20);

    // Checking for correct spacing row by row
    String c;
    for (int i = 0; i < rBlock.height(); i++) {
      c = rBlock.row(i);
      assertEquals("Correct spacing", c.substring(0, 3), "   ");
    }  
  }

  @Test
  public void DiagonalTest() throws Exception {
    TextBlock tb1 = new TextLine("Hello World");
    TextBlock tb2 = new TextLine("Bye bye");
    TextBlock dBlock = new Diagonal(tb1, tb2);
    
    assertEquals("leftJustified creates block of correct width", dBlock.width(), 18);
  }


 @Test
  public void horizontallyFlippedTest() throws Exception {
    TextBlock tb1 = new TextLine("Hellow World");
    TextBlock tb2 = new TextLine("dlroW wolleH");
    TextBlock flipped = new HorizontallyFlipped(tb1);
    
    assertTrue("Horizontally flipping once changes the block", TBUtils.equals(flipped, tb2));

    TextBlock emptyb = new HorizontallyFlipped(new TextLine(""));
    assertEquals("HorizontallyFlipped works with empty block", emptyb.width(), 0);
  }

  @Test
  public void verticallyFlippedTest() throws Exception {
    TextBlock tb1 = new TextLine("Hello World");
    TextBlock tb2 = new TextLine("Bye Bye");
    
    TextBlock tb = new VComposition(tb1, tb2);
    
    TextBlock flippedTwice = new VerticallyFlipped(new VerticallyFlipped(tb));
    
    assertTrue("Vertically flipping twice gives the same block", TBUtils.equals(tb, flippedTwice));

    TextBlock emptyb = new VerticallyFlipped(new TextLine(""));
    assertEquals("empty block works", emptyb.width(), 0);
  }

  @Test
  public void equalsTest() throws Exception {
    TextBlock tb1 = new TextLine("Hello World");
    TextBlock tb2 = new TextLine("Bye Bye");
    TextBlock vftb = new VerticallyFlipped(tb1);
    
    TextBlock tb3 = new TextLine("HB");
    
    assertFalse("text is the same", TBUtils.equals(tb1, tb2));
    assertTrue("text is same as well", TBUtils.equals(tb1, vftb));
    assertFalse("text is different", TBUtils.equals(tb1, tb3));
  }

  @Test
  public void eqvTest() throws Exception {
    TextBlock notFlipped = new TextLine("Hello World");
    TextBlock flippedTwice = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hellow World")));
    TextBlock FlippedTwice2 = new HorizontallyFlipped(new HorizontallyFlipped(new TextLine("Hellow World")));
    
    assertTrue("blocks were built in the same way", TBUtils.eqv(flippedTwice, FlippedTwice2));
    assertFalse("blocks were built in different ways", TBUtils.eqv(flippedTwice, notFlipped));
  }


  @Test
  public void eqTest() throws Exception {
    TextBlock tb1 = new TextLine("Hellow World");
    TextBlock tb2 = tb1;
    TextBlock tb3 = new TextLine("Hellow World");
    
    assertTrue("same memory location", TBUtils.eq(tb1, tb2));
    assertFalse("different memory locations", TBUtils.eq(tb1, tb3));
  }

}
