

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
<<<<<<< Updated upstream
=======
    private Comment comment1;

>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        
        comment1 = new Comment("Tester", "Test comment", 4);
        
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
}
=======

    @Test
    public void testDownvote()
    {
        comment1.downvote();
        assertEquals(-1, comment1.getVoteCount());
        comment1.downvote();
        comment1.upvote();
        comment1.upvote();
        comment1.upvote();
        comment1.upvote();
        comment1.downvote();
        assertEquals(1, comment1.getVoteCount());
    }

    @Test
    public void testGetRating()
    {
        assertEquals(4, comment1.getRating());
    }
}


>>>>>>> Stashed changes
