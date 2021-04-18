package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate birthDate;
    private final int numOfPosts;

    public ForumUser(final int userId, final String username, final char sex, final LocalDate birthDate, final int numOfPosts) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.birthDate = birthDate;
        this.numOfPosts = numOfPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getNumOfPosts() {
        return numOfPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", birthDate=" + birthDate +
                ", numOfPosts=" + numOfPosts +
                '}';
    }
}
