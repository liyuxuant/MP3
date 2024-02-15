import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Pranav K Bhandari
 * @author Li, Yuxuan (Tony)
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);
    TextBlock helloBlock = new TextLine("Hello World Hello World");
    TextBlock trunc = new Truncated(helloBlock, 8);

    TextBlock horiz1 = new HorizontallyFlipped(helloBlock);

    TextBlock byeBlock = new TextLine("Goodbye");
    TextBlock joinedBlock = new VComposition(helloBlock, byeBlock);


    TextBlock vert1 = new VerticallyFlipped(joinedBlock);

    TextBlock diag = new Diagonal(helloBlock, byeBlock);

    TBUtils.print(pen, diag);

    TBUtils.print(pen, trunc);
    // TBUtils.print(pen, horiz1);

    // TBUtils.print(pen, vert1);
    // // Prepare for input and output
    // PrintWriter pen = new PrintWriter(System.out, true);

    // // Create a block to use
    // TextBlock block1 = new TextLine("Hello World!");
    // BoxedBlock boxedBlock1 = new BoxedBlock(block1);

    // // Create a block to use
    // TextBlock block2 = new TextLine("Hello World!");
    // BoxedBlock boxedBlock2 = new BoxedBlock(block2);
    // BoxedBlock boxedBlock22 = new BoxedBlock(boxedBlock2);

    // // Create a block to use
    // TextBlock block3 = new TextLine("");
    // BoxedBlock boxedBlock3 = new BoxedBlock(block3);

    // // Print out the block
    // TBUtils.print(pen, boxedBlock1);
    // TBUtils.print(pen, boxedBlock22);
    // TBUtils.print(pen, boxedBlock3);

    // TextBlock helloBlock = new TextLine("Hello");
    // TextBlock trunc = new Truncated(helloBlock, 10);
    // TextBlock byeBlock = new TextLine("Goodbye");

    // // (a)
    // TextBlock joinedBlock = new VComposition(helloBlock, byeBlock);
    // BoxedBlock joinedBox = new BoxedBlock(joinedBlock);
    // TBUtils.print(pen, joinedBox);

    // // (b)
    // BoxedBlock helloboxed = new BoxedBlock(helloBlock);
    // BoxedBlock byeboxed = new BoxedBlock(byeBlock);
    // TextBlock twoBoxed = new VComposition(helloboxed, byeboxed);
    // TBUtils.print (pen, twoBoxed);

    // // (c)
    // TextBlock hboxed = new HComposition(helloboxed, byeBlock);
    // TBUtils.print(pen, hboxed);

    // // (d)
    // TextBlock hboxed2 = new HComposition(byeBlock, helloboxed);
    // TBUtils.print(pen, hboxed2);

    // // Clean up after ourselves.
    // pen.close();
  } // main(String[])

} // class TBExpt
