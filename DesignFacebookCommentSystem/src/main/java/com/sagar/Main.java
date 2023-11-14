package com.sagar;

import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        User u1 = new User("Sagar");
        User u2=new User("Mohit");
        System.out.println(u1.getId());


        Comment c1 = new Comment("First Comment");
        Comment c2 = new Comment("Second Comment");
        Comment c21 = new Comment("Second Nested Comment");
        Comment c11 = new Comment("First Nested Comment");
        Comment c12 = new Comment("First Second Nested Comment");
        Comment c13 = new Comment("First Third Nested Comment");

        Post p = new Post();

        u1.addCommentToPost(p, c1);
        u1.addCommentToPost(p, c2);

        u1.replyToComment(p, c1.getId(), c11);
        u1.replyToComment(p, c1.getId(), c12);
        u1.replyToComment(p, c1.getId(), c13);
        u1.replyToComment(p, c2.getId(), c21);

        System.out.println("========================================================================");
        System.out.println("Printing Comments on the post");
        System.out.println("========================================================================");

        for (Comment com : p.getComments()) {
            System.out.println(com.getDescription());
            for (Comment j : com.getComments()) {
                System.out.println("\t" + j.getDescription());
            }
        }

        System.out.println("========================================================================");
        System.out.println("Editing Comments");
        System.out.println("========================================================================");
        u1.editComment(p, c1.getId(), c11.getId(), "Edited Comment");
        u1.editComment(p, c2.getId(), c12.getId(), "Edited Comment 2");

        System.out.println("========================================================================");
        System.out.println("Deleting Comments");
        System.out.println("========================================================================");
        u1.deleteComment(p, c2.getId(), c12.getId());

        System.out.println("========================================================================");
        System.out.println("Printing Comments on the post");
        System.out.println("========================================================================");

        for (Comment com : p.getComments()) {
            System.out.println(com.getDescription());
            for (Comment j : com.getComments()) {
                System.out.println("\t" + j.getDescription());
            }
        }

        System.out.println("--");

        System.out.println(c1.getDescription());
    }
}
