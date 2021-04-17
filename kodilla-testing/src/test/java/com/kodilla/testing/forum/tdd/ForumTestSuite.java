package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Forum Test Suite")
public class ForumTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("Tests for posts")
    class TestsPosts {

        @DisplayName("when add a new post, then number of posts should be 1 ")
        @Test
        void testAddPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");

            //When
            forumUser.addPost("mrsmith", "Hello everyone, this is my first contribution here!");

            //Then
            Assertions.assertEquals(1, forumUser.getPostsQuantity());
        }

        @DisplayName("when get the post from class ForumUser, then the post should be the same which was added")
        @Test
        void testGetPost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            ///When
            ForumPost retrievedPost;
            retrievedPost = forumUser.getPost(0);

            //Then
            Assertions.assertEquals(thePost, retrievedPost);
        }

        @DisplayName("when remove post which is not exist, then should return false")
        @Test
        void testRemovePostNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("verification of successful post remove")
        @Test
        void testRemovePost() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

            //When
            boolean result = forumUser.removePost(thePost);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getPostsQuantity());
        }
    }

    @Nested
    @DisplayName("Tests for comments")
    class TestsComments {

        @DisplayName("when add a new comment, then number of comments should be 1")
        @Test
        void testAddComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");

            //When
            forumUser.addComment(thePost, "mrsmith", "Thank you for all good words!");

            //Then
            Assertions.assertEquals(1, forumUser.getCommentsQuantity());
        }

        @DisplayName("when get the comment from class ForumUser, then the comment should be the same which was added")
        @Test
        void testGetComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith","Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            ForumComment retrievedComment = forumUser.getComment(0);

            //Then
            Assertions.assertEquals(theComment, retrievedComment);
        }

        @DisplayName("when remove comment which is not exist, then should return false")
        @Test
        void testRemoveCommentNotExisting() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith","Thank you for all good words!");

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertFalse(result);
        }

        @DisplayName("verification of successful comment remove")
        @Test
        void testRemoveComment() {
            //Given
            ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
            ForumPost thePost = new ForumPost("Hello everyone, this is my first contribution here!", "mrsmith");
            ForumComment theComment = new ForumComment(thePost, "mrsmith","Thank you for all good words!");
            forumUser.addComment(thePost, theComment.getAuthor(), theComment.getCommentBody());

            //When
            boolean result = forumUser.removeComment(theComment);

            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0, forumUser.getCommentsQuantity());
        }
    }
}
