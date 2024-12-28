package com.sagar.example1;

public class ChaiShop {

    public static void main(String[] args) {
        Chai basicChai=new BasicChai();
        System.out.println(basicChai.makeChai());

        Chai adrakChai=new AdrakChai(basicChai);
        System.out.println(adrakChai.makeChai());

        Chai elachiChai=new ElaichiChai(basicChai);
        System.out.println(elachiChai.makeChai());
    }
}
