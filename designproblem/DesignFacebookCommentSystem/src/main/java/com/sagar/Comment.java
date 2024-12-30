package com.sagar;

import java.util.ArrayList;
import java.util.List;

class Comment {
    private static int counter = 0;
    private int postId;
    private int userId;
    private String description;
    private int id;
    private List<Comment> comments = new ArrayList<>();
    private int parentId;
    private boolean isParent;

    public Comment(String description) {
        this.description = description;
        this.id = getUniqueID();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        description = value;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int value) {
        parentId = value;
    }

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int value) {
        postId = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        userId = value;
    }

    private int getUniqueID() {
        counter++;
        return counter;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void deleteNestedComment(int commentId) {
        for (Comment comment : comments) {
            if (comment.getId() == commentId) {
                comments.remove(comment);
                return;
            }
        }
    }
}