package com.sagar;

import java.util.ArrayList;
import java.util.List;

class Post {
    private static int counter = 0;
    private int id;
    private List<Comment> comments = new ArrayList<>();

    public Post() {
        this.id = getUniqueID();
    }

    private int getUniqueID() {
        counter++;
        return counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        id = value;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addNestedComment(Comment comment, int commentId) {
        for (Comment c : comments) {
            if (c.getId() == commentId) {
                c.addComment(comment);
                return;
            }
        }
    }

    public void editComment(int parentId, int commentId, String description) {
        for (Comment comment : comments) {
            if (comment.getParentId() == parentId) {
                if (comment.getId() == commentId) {
                    comment.setDescription(description);
                    return;
                } else {
                    for (Comment nestedComment : comment.getComments()) {
                        if (nestedComment.getId() == commentId) {
                            nestedComment.setDescription(description);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void deleteComment(int parentId, int commentId) {
        for (Comment comment : comments) {
            if (comment.getParentId() == parentId) {
                if (comment.getId() == commentId) {
                    comments.remove(comment);
                    return;
                } else {
                    comment.deleteNestedComment(commentId);
                }
            }
        }
    }
}

