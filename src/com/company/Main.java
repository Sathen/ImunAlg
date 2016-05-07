package com.company;


import java.util.*;

public class Main {

    static private int[] Ag1 = {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};
    static private int[] Ag2 = {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1};
    static private int[] Ag3 = {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1};
    static private final int X_MIN = -1;
    static private final int X_MAX = 1;

    //static static

    static private List<Antibody> antibodyList = new ArrayList<Antibody>();

    static private Random random = new Random();


    // from min to max
    private static Comparator<Antibody> sortMinToMax = new Comparator<Antibody>() {
        @Override
        public int compare(Antibody o1, Antibody o2) {
            if (o1.getAffinity() > o2.getAffinity()) return 1;
            if (o1.getAffinity() < o2.getAffinity()) return -1;
            return 0;
        }
    };

    // from max to min
    private static Comparator<Antibody> sortMaxToMin = new Comparator<Antibody>() {
        @Override
        public int compare(Antibody o1, Antibody o2) {
            if (o1.getAffinity() > o2.getAffinity()) return -1;
            if (o1.getAffinity() < o2.getAffinity()) return 1;
            return 0;
        }
    };


    public static void main(String[] args) {


        antibodyList.add(new Antibody("Ab1"));
        antibodyList.add(new Antibody("Ab2"));
        antibodyList.add(new Antibody("Ab3"));
        antibodyList.add(new Antibody("Ab4"));
        antibodyList.add(new Antibody("Ab5"));
        antibodyList.add(new Antibody("Ab6"));
        antibodyList.add(new Antibody("Ab7"));
        antibodyList.add(new Antibody("Ab8"));
        antibodyList.add(new Antibody("Ab9"));
        antibodyList.add(new Antibody("Ab10"));


        int gen = 500;

        while (gen >= 0) {
            runAg1();
            gen--;
        }

        System.out.println(antibodyList.get(0).getAffinity());


    }

    private static void runAg1() {

        List<Antibody> antibodiesCloneList = new ArrayList<Antibody>();
        List<Antibody> newPopulation = new ArrayList<Antibody>();


        for (Antibody a : antibodyList) {
            affinity(a);
        }

        // select by affinity
        Collections.sort(antibodyList, sortMaxToMin);
//

        //count of copy and make clone
        for (Antibody a : antibodyList) {
            makeClone(a, antibodiesCloneList);
        }

        mutationClonePopulation(antibodiesCloneList);

        for (Antibody a : antibodiesCloneList) {
            affinity(a);

        }
        Collections.sort(antibodiesCloneList, sortMaxToMin);

        //replace
        for (int i = 0; i < 10; i++) {

            for (Antibody a : antibodiesCloneList) {
                if (a.getName().equals(antibodyList.get(i).getName())) {
                    if (a.getAffinity() > antibodyList.get(i).getAffinity()) {
                        antibodyList.get(i).setX1(a.getX1());
                        antibodyList.get(i).setX2(a.getX2());

                    }
                }
            }

        }


        newPopulation.add(new Antibody("Ab1"));
        newPopulation.add(new Antibody("Ab2"));
        newPopulation.add(new Antibody("Ab3"));
        newPopulation.add(new Antibody("Ab4"));
        newPopulation.add(new Antibody("Ab5"));
        newPopulation.add(new Antibody("Ab6"));
        newPopulation.add(new Antibody("Ab7"));
        newPopulation.add(new Antibody("Ab8"));
        newPopulation.add(new Antibody("Ab9"));
        newPopulation.add(new Antibody("Ab10"));

        // affinity antibody after replace mutation's body

        for (Antibody a : antibodyList) {
            affinity(a);
        }
        for (Antibody a : newPopulation) {
            affinity(a);
        }
        Collections.sort(newPopulation, sortMaxToMin);


        for (int i = 8; i < 10; i++) {
            antibodyList.set(i, newPopulation.get(i));

        }
    }

    private static void mutationClonePopulation(List<Antibody> antibodiesCloneList) {

        for (Antibody a : antibodiesCloneList) {

            a.setpMutation(0.3);
            int index = 0;
            int[] x1;
            int[] x2;
            x1 = a.getX1();
            x2 = a.getX2();
            for (int i = 0; i < 22 * a.getpMutation(); i++) {
                index = random.nextInt(2);
                if (x1[index] == 0)
                    x1[index] = 1;
                else x1[index] = 0;
            }
            for (int i = 0; i < 22 * a.getpMutation(); i++) {
                index = random.nextInt(2);
                if (x2[index] == 0)
                    x2[index] = 1;
                else x2[index] = 0;
            }

            a.setX1(x1);
            a.setX2(x2);
        }


    }

    private static void makeClone(Antibody antibody, List<Antibody> antibodiesCloneList) {
        for (int i = 0; i < 5; i++) {
            antibodiesCloneList.add(new Antibody(antibody));
        }
    }


    private static void affinity(Antibody currentAntBody) {

        double x1 = 0;
        double x2 = 0;

        for (int i = 0; i < currentAntBody.getX1().length - 1; i++) {

            x1 += currentAntBody.getX1()[i] * Math.pow(2, i);
            x2 += currentAntBody.getX2()[i] * Math.pow(2, i);

        }
        x1 = X_MIN + x1 * ((X_MAX - X_MIN) / Math.pow(2, currentAntBody.getX1().length) - 1);
        x2 = X_MIN + x2 * ((X_MAX - X_MIN) / Math.pow(2, currentAntBody.getX2().length) - 1);


        double f = Math.pow(x1, 2) + Math.pow(x2, 2) - Math.cos(18 * x1) - Math.cos(18 * x2);
        currentAntBody.setAffinity(f);

    }
}
