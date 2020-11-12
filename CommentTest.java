

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private Comment comment1;

    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
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
        // Add a comment to the test fixture.
        comment1 = new Comment("Tester", "Test comment", 4);

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

    @Test
    public void testDownvote()
    {
        // Downvote comment once
        comment1.downvote();
        //confirm vote count is -1
        assertEquals(-1, comment1.getVoteCount());
        // Downvote and upvote comment several times.
        comment1.downvote();
        comment1.upvote();
        comment1.upvote();
        comment1.upvote();
        comment1.upvote();
        comment1.downvote();
        // Confirm vote count is correct.
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testGetRating()
    {
        // Call the comment's getRating method.
        // Confirm it returns the correct rating.
        assertEquals(4, comment1.getRating());
    }
}


