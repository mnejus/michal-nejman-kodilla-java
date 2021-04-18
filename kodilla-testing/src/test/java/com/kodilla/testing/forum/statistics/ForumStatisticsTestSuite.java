package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.library.LibraryDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @Test
    void testCalculateAdvStatistics0Posts0Comments0Users() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(0);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.postCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(0);

        //When
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();

        //Then
        assertNotEquals(0.0, resultAvgUserPosts);
        assertNotEquals(0.0, resultAvgPostComments);
        assertNotEquals(0.0, resultAvgPostComments);
    }

    @Test
    void testCalculateAdvStatistics1000Posts0Comments100Users() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();

        //Then
        assertEquals(10.0, resultAvgUserPosts);
        assertEquals(0.0, resultAvgPostComments);
        assertEquals(0.0, resultAvgUserComments);
    }

    @Test
    void testCalculateAdvStatistics1000PostsLessComments100Users() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.commentsCount()).thenReturn(500);
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();

        //Then
        assertEquals(10.0, resultAvgUserPosts);
        assertEquals(0.5, resultAvgPostComments);
        assertEquals(5, resultAvgUserComments);
    }

    @Test
    void testCalculateAdvStatistics1000PostsMoreComments100Users() {
        //Given
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        List<String> userList = generateListOfUsers(100);
        when(statisticsMock.userNames()).thenReturn(userList);
        when(statisticsMock.commentsCount()).thenReturn(10000);
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        double resultAvgUserPosts = forumStatistics.getAvgUserPosts();
        double resultAvgPostComments = forumStatistics.getAvgPostComments();
        double resultAvgUserComments = forumStatistics.getAvgUserComments();

        //Then
        assertEquals(10.0, resultAvgUserPosts);
        assertEquals(10.0, resultAvgPostComments);
        assertEquals(100, resultAvgUserComments);
    }
}
