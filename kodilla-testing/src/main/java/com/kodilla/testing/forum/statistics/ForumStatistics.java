package com.kodilla.testing.forum.statistics;

public class ForumStatistics {

    private Statistics statistics;

    int usersNum;
    int postsNum;
    int commentsNum;
    double avgUserPosts;
    double avgUserComments;
    double avgPostComments;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getUsersNum() {
        usersNum = statistics.userNames().size();
        return usersNum;
    }

    public int getPostsNum() {
        postsNum = statistics.postCount();
        return postsNum;
    }

    public int getCommentsNum() {
        commentsNum = statistics.commentsCount();
        return commentsNum;
    }

    public double getAvgUserPosts() {
        avgUserPosts = statistics.postCount() / (float) statistics.userNames().size();
        return avgUserPosts;
    }

    public double getAvgUserComments() {
        avgUserComments = statistics.commentsCount() / (float) statistics.userNames().size();
        return avgUserComments;
    }

    public double getAvgPostComments() {
        avgPostComments = statistics.commentsCount() / (float) statistics.postCount();
        return (double) Math.round(avgPostComments * 100) / 100;

    }

    public void calculateAdvStatistics(Statistics statistics) {
        usersNum = getUsersNum();
        postsNum = getPostsNum();
        commentsNum = getCommentsNum();
        avgUserPosts = getAvgUserPosts();
        avgUserComments = getAvgUserComments();
        avgPostComments = getAvgPostComments();
    }

    public void showStatistics() {
        System.out.println("Number of users: " + usersNum);
        System.out.println("Number of posts: " + postsNum);
        System.out.println("Number of comments: " + commentsNum);
        System.out.println("Average number of posts per user: " + avgUserPosts);
        System.out.println("Average number of comments per user: " + avgUserComments);
        System.out.println("Average number of comments per post: " + avgPostComments);
    }
}
