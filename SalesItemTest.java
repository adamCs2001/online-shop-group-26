
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test item", 200);
        assertEquals("test item", salesIte1.getName());
        assertEquals(200, salesIte1.getPrice());
        assertEquals(0, salesIte1.getNumberOfComments());
    }

    /**
     * Test that get number of comments returns the correct number of comments attached to a sale item.
     */
    @Test
    public void testGetNumberOfComments()
    {
        SalesItem salesIte1 = new SalesItem("TestBook, 2nd ed", 20); 
        // check that initial array returns 0
        assertEquals(true, salesIte1.getNumberOfComments() == 0);

        // add comment, check that get comments returns 1
        salesIte1.addComment("Adam Lichter", "This is a successful test comment", 1);
        assertEquals(true, salesIte1.getNumberOfComments() == 1);

        //remove comment, check that it returns 0 again
        salesIte1.removeComment(0);
        assertEquals(true, salesIte1.getNumberOfComments() == 0);
    }

    /**
     * Test add comment.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("TestBook, 2nd ed", 20);

        //test valid comment
        assertEquals(true, salesIte1.addComment("Adam Lichter", "great", 4));
        assertEquals(1, salesIte1.getNumberOfComments());

        //test invalid comment (rating out of range)
        assertEquals(false, salesIte1.addComment("Adam Lichter 2", "great", 400));
        assertEquals(1, salesIte1.getNumberOfComments());

        //test invalid comment (rating out of range)
        assertEquals(false, salesIte1.addComment("Adam Lichter 3", "great", -400));
        assertEquals(1, salesIte1.getNumberOfComments());

        //test invalid comment (dup[licate author)
        assertEquals(false, salesIte1.addComment("Adam Lichter", "great", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test remove comment.
     */
    @Test
    public void testRemoveComment()
    {
        SalesItem salesIte1 = new SalesItem("TestBook, 2nd ed", 20);

        //test remove comment
        salesIte1.addComment("Adam Lichter", "great", 4);
        salesIte1.removeComment(0);
        assertEquals(0, salesIte1.getNumberOfComments());

        //test invalid remove comment (index out of range)
        salesIte1.addComment("Adam Lichter", "great", 4);
        salesIte1.removeComment(1);
        assertEquals(1, salesIte1.getNumberOfComments());

        //test invalid remove comment (index out of range)
        salesIte1.removeComment(-1);
        assertEquals(1, salesIte1.getNumberOfComments());

        //test invalid remove comment (index out of range)
        // reset to zero comments
        salesIte1.removeComment(0);
        // try removing comment that doesn't exist
        salesIte1.removeComment(0);
        assertEquals(0, salesIte1.getNumberOfComments());

        // test two comment removing
        salesIte1.addComment("Adam Lichter", "great", 4);
        salesIte1.addComment("Adam Lichter2", "great", 5);
        assertEquals(2, salesIte1.getNumberOfComments());
        // remove at 0th index
        salesIte1.removeComment(0);
        //check that there is one comment
        assertEquals(1, salesIte1.getNumberOfComments());
        
    }

    

    @Test
    public void testUpvoteComment()
    {
        //add item, add comment on item
        SalesItem salesIte1 = new SalesItem("test item", 123);
        assertEquals(true, salesIte1.addComment("A", "comment A", 0));
        //upvote comment once
        salesIte1.upvoteComment(0);
        //
        Comment comment1 = salesIte1.findMostHelpfulComment();
        //confirm vote count is 1
        assertEquals(1, comment1.getVoteCount());
        //add second comment
        assertEquals(true, salesIte1.addComment("B", "comment B", 0));
        //upvote second comment 4 times
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        //second comment is now most helpful
        Comment comment2 = salesIte1.findMostHelpfulComment();
        //confirm vote count is 4
        assertEquals(4, comment2.getVoteCount());
    }



    @Test
    public void testFindMostHelpfulComment()
    {
        //add 2 comments
        SalesItem salesIte1 = new SalesItem("test item", 1234);
        assertEquals(true, salesIte1.addComment("A", "comment A", 0));
        assertEquals(true, salesIte1.addComment("B", "comment B", 0));
        
        //upvote first comment once
        salesIte1.upvoteComment(0);
        
        //comment1 = most helpful comment
        Comment comment1 = salesIte1.findMostHelpfulComment();
        
        //confirm that comment1 is the one it should be
        assertEquals("A", comment1.getAuthor());
        assertEquals(1, comment1.getVoteCount());
        
        //upvote second comment 3 times
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        salesIte1.upvoteComment(1);
        
        //comment2 = most helpful comment
        Comment comment2 = salesIte1.findMostHelpfulComment();
        
        //confirm that comment2 is the correct one
        assertEquals("B", comment2.getAuthor());
        assertEquals(3, comment2.getVoteCount());
        
        //test when one comment has negative votes
        
        //downvote second comment 4 times (now rating should = -1)
        salesIte1.downvoteComment(1);
        salesIte1.downvoteComment(1);
        salesIte1.downvoteComment(1);
        salesIte1.downvoteComment(1);
        
        //upvote first comment three times, downvote twice (net +1, now rating should = 2)
        salesIte1.downvoteComment(0);
        salesIte1.upvoteComment(0);
        salesIte1.downvoteComment(0);
        salesIte1.upvoteComment(0);
        salesIte1.upvoteComment(0);
        
        //confirm that comment1 is now most helpful again and has correct number of votes
        assertEquals(comment1, salesIte1.findMostHelpfulComment());
        assertEquals("A", comment1.getAuthor());
        assertEquals(2, comment1.getVoteCount());
        
        //test when both comments have negative votes
        
        //downvote comment1 three times, rating should now be -2
        salesIte1.downvoteComment(0);
        salesIte1.downvoteComment(0);
        salesIte1.downvoteComment(0);
        salesIte1.downvoteComment(0);
        
        //most helpful comment should now be comment2 with -1 rating
        assertEquals(comment2, salesIte1.findMostHelpfulComment());
        assertEquals(-1, comment2.getVoteCount());
    }
}






