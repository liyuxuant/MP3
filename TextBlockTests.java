import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TextBlockTests {
/**
 * Tests of the TextBlocks for MP3.
 * 
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 * Includes tests for each of the different kinds 
 * of text blocks as parameters to other text blocks (or themselves).
 * @throws Exception
 * 
 */


  @Test
  public void truncatedTest() throws Exception  {
    TextBlock tb1 = new TextLine("Hello, World");
    TextBlock tb2 = new Truncated(tb1, 6);
    TextBlock empty = new TextLine("");
    int maxWidth = 3;
    
    TextBlock truncated1 = new Truncated(tb1, maxWidth);
    TextBlock truncated2 = new Truncated(tb2, maxWidth);
    assertEquals("width equals max_width", truncated1.width(), 3) ;
    assertEquals("width equals max_width", truncated2.width(), 3) ;
    
    TextBlock emptyt = new Truncated(empty, 0);
    assertEquals("width equals 0", emptyt.width(), 0) ;

  }

  @Test
  public void centeredTest () throws Exception {
      TextBlock tb1 = new TextLine("HelloWorld");
      TextBlock tb2 = new Truncated(tb1, 6);
      TextBlock centered1 = new Centered(tb1, 18);
      TextBlock centered2 = new Centered(tb2, 18);
      
      assertEquals("Centered the block", centered1.width(), 18);
      assertEquals("Centered the block", centered1.row(0), "    HelloWorld    ");
      assertEquals("Centered the block", centered2.row(0), "      HelloW      ");


      // test for CenteredBlock block with equal width
      centered1 = new Centered(tb1, 11);
      assertEquals("Centered the block", centered1.width(), 11);

      // Checking for correct spacing row by row
      String c, special;
      
      for (int i = 0; i < centered1.height(); i++) {
        c = centered1.row(i);

        if (centered1.width() == tb1.width()) {
          special = tb1.row(i);
          assertEquals("Correct spacing", c.substring(0, 1), special.substring(0,1));
          assertEquals("Correct spacing", c.substring(c.length() - 1), special.substring(special.length() - 1));
        }
        else if((centered1.width() - tb1.width()) == 1) {
          special = tb1.row(i);
          assertEquals("Correct spacing", c.substring(0, 1), " ");
          assertEquals("Correct spacing", c.substring(c.length() - 1), special.substring(special.length() - 1));
        }
        else {
          assertEquals("Correct spacing", c.substring(0, 1), " ");
          assertEquals("Correct spacing", c.substring(c.length() - 1), " ");
        }
        
        
      }
  }

  @Test
  public void rightJustifiedTest() throws Exception {
    TextBlock tb1 = new TextLine("Hello World");
    TextBlock rBlock = new RightJustified(tb1, 15);

    assertEquals("rightJustified creates block of correct width", rBlock.width(), 15);

    // test for RightJustifiedBlock block with equal width
    rBlock = new RightJustified(tb1, 11);
    assertEquals("rightJustified creates block of correct width", rBlock.width(), 11);

    // Checking for correct spacing row by row
    String c, special;
    for (int i = 0; i < rBlock.height(); i++) {
      c = rBlock.row(i);

      if(rBlock.width() == tb1.width())
      {
        special = tb1.row(i);
        assertEquals("Correct spacing", c.substring(0, 1), special.substring(0, 1));
      }
      else {
        assertEquals("Correct spacing", c.substring(0, 1), " ");
      }
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
