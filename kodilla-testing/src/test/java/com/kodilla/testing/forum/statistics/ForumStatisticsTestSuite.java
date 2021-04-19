package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    private static int testCounter = 0;

    @BeforeEach
    public void before() {
        testCounter ++;
        System.out.println("Preparing to execute test # " + testCounter);
    }

    private List<String> generateListOfUsers(int usersQuantity) {
        List<String> usersList = new ArrayList<>();
        for(int n = 0; n < usersQuantity; n++) {
            usersList.add("user" + n);
        }
        return usersList;
    }

    @Mock
    private Statistics statisticsMock;


    @DisplayName("0 posts, 100 users, 300 comments")
    @Test
    void testCalculateAdvStatistics1() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(300);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(100, resultUsersNum);
        assertEquals(0, forumStatistics.getPostsNum());
        assertEquals(300, resultCommentsNum);
        assertEquals(0.0, resultAvgUserPosts);
        assertEquals(3, resultAvgUserComments);
        assertNotEquals(0.0, resultAvgPostComments);

    }

    @DisplayName("0 posts, 100 users, 0 comments")
    @Test
    void testCalculateAdvStatistics2() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(100, resultUsersNum);
        assertEquals(0, forumStatistics.getPostsNum());
        assertEquals(0, resultCommentsNum);
        assertEquals(0.0, resultAvgUserPosts);
        assertEquals(0.0, resultAvgUserComments);
        assertEquals(0.0, resultAvgPostComments);

    }

    @DisplayName("1000 posts, 100 users, posts > comments")
    @Test
    void testCalculateAdvStatistics3() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(100, resultUsersNum);
        assertEquals(1000, forumStatistics.getPostsNum());
        assertEquals(0, resultCommentsNum);
        assertEquals(10.0, resultAvgUserPosts);
        assertEquals(0.0, resultAvgUserComments);
        assertEquals(0.0, resultAvgPostComments);
    }

    @DisplayName("1000 posts, 0 users, posts > comments")
    @Test
    void testCalculateAdvStatistics4() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(0);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(0, resultUsersNum);
        assertEquals(1000, forumStatistics.getPostsNum());
        assertEquals(100, resultCommentsNum);
        assertNotEquals(0.0, resultAvgUserPosts);
        assertNotEquals(0.0, resultAvgUserComments);
        assertEquals(0.1, resultAvgPostComments);
    }

    @DisplayName("1000 posts, 100 users, posts < comments")
    @Test
    void testCalculateAdvStatistics5() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(100, resultUsersNum);
        assertEquals(1000, forumStatistics.getPostsNum());
        assertEquals(2000, resultCommentsNum);
        assertEquals(10.0, resultAvgUserPosts);
        assertEquals(20.0, resultAvgUserComments);
        assertEquals(2.0, resultAvgPostComments);
    }

    @DisplayName("1000 posts, 0 users, posts < comments")
    @Test
    void testCalculateAdvStatistics6() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(0);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);

        //When
        double resultUsersNum = forumStatistics.getUsersNum();
        double resultCommentsNum = forumStatistics.getCommentsNum();
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertEquals(0, resultUsersNum);
        assertEquals(1000, forumStatistics.getPostsNum());
        assertEquals(2000, resultCommentsNum);
        assertNotEquals(0.0, resultAvgUserPosts);
        assertNotEquals(0.0, resultAvgUserComments);
        assertEquals(2.0, resultAvgPostComments);
    }
}
