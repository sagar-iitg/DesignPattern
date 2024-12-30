package com.sagar;

class User {
    private static int counter = 0;
    private int id;
    private String name;

    public User(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public void addCommentToPost(Post post, Comment comment) {
        comment.setUserId(getId());
        comment.setPostId(post.getId());
        comment.setParentId(comment.getId());
        post.addComment(comment);
    }

    public void replyToComment(Post post, int parentId, Comment comment) {
        comment.setUserId(getId());
        comment.setPostId(post.getId());
        comment.setParentId(parentId);
        post.addNestedComment(comment, parentId);
    }

    public void editComment(Post post, int parentId, int commentId, String description) {
        for (Comment comment : post.getComments()) {
            if (comment.getId() == commentId) {
                if (comment.getUserId() != getId()) {
                    System.out.println("Unauthorized user");
                    return;
                }
                break;
            }
        }
        post.editComment(parentId, commentId, description);
    }

    public void deleteComment(Post post, int parentId, int commentId) {
        for (Comment comment : post.getComments()) {
            if (comment.getId() == commentId) {
                if (comment.getUserId() != getId()) {
                    System.out.println("Unauthorized user");
                    return;
                }
                break;
            }
        }
        post.deleteComment(parentId, commentId);
    }
}