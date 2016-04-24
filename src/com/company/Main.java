package com.company;


import java.util.*;

public class Main {

    static private int[] Ag1 = {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};
    static private int[] Ag2 = {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1};
    static private int[] Ag3 = {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1};

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

        affinity(antibodyList.get(1));






//        int gen = 50;
//
//        while (gen >= 0) {
////            runAg1();
////            runAg2();
////            runAg3();
//            gen--;
//        }

//        for (Antibody a : antibodyList) {
//            for (int i : a.getValue()) {
//                System.out.print(i);
//            }
//            System.out.println();
//        }


    }

//    private static void runAg1() {
//
//        List<Antibody> antibodiesCloneList = new ArrayList<Antibody>();
//        List<Antibody> newPopulation = new ArrayList<Antibody>();
//
//
//        for (Antibody a : antibodyList) {
//            affinity(Ag1, a);
//        }
//
//        // select by affinity
//        Collections.sort(antibodyList, sortMinToMax);
//
//        for (int i = 0; i < antibodyList.size(); i++) {
//
//            antibodyList.get(i).setPositionInPopulation(i + 1);
//        }
//
//        //count of copy and make clone
//        for (int i = 0; i < 4; i++) {
//            int index = i + 1;
//            int N = 6 / (index);
//            antibodyList.get(i).setCountOfClone(N);
//            makeClone(antibodyList.get(i), antibodiesCloneList);
//        }
//
//        Collections.sort(antibodiesCloneList, sortMaxToMin);
//        mutationClonePopulation(antibodiesCloneList);
//
//        //affinity clone to Ag
//        for (Antibody a : antibodiesCloneList) {
//            affinity(Ag1, a);
//        }
//
//        //Select
//        Collections.sort(antibodiesCloneList
//                , sortMinToMax);
//
//        //replace
//        for (int i = 0; i < 6; i++) {
//            if (antibodyList.get(i).getName().equals("Ab1")) {
//                if (antibodyList.get(i).getAffinity() >= antibodiesCloneList.get(0).getAffinity())
//                    antibodyList.get(i).setValue(antibodiesCloneList.get(0).getValue());
//            }
//
//        }
//
//
//        newPopulation.add(new Antibody("Ab1"));
//        newPopulation.add(new Antibody("Ab2"));
//        newPopulation.add(new Antibody("Ab3"));
//        newPopulation.add(new Antibody("Ab4"));
//        newPopulation.add(new Antibody("Ab5"));
//        newPopulation.add(new Antibody("Ab6"));
//
//
//        int cof = 0;
//
//
//        for (int i = 0; i < 6; i++) {
//
//            if (antibodyList.get(i).getName().equals("Ab4")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab5")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab6")) {
//                antibodyList.set(i, newPopulation.get(i));
//            }
//
//        }
//
//    }

//    private static void runAg2() {
//
//        List<Antibody> antibodiesCloneList = new ArrayList<Antibody>();
//        List<Antibody> newPopulation = new ArrayList<Antibody>();
//
//
//        for (Antibody a : antibodyList) {
//            affinity(Ag2, a);
//        }
//
//        // select by affinity
//        Collections.sort(antibodyList, sortMinToMax);
//
//        for (int i = 0; i < antibodyList.size(); i++) {
//
//            antibodyList.get(i).setPositionInPopulation(i + 1);
//        }
//
//        //count of copy and make clone
//        for (int i = 0; i < 4; i++) {
//            int index = i + 1;
//            int N = 6 / (index);
//            antibodyList.get(i).setCountOfClone(N);
//            makeClone(antibodyList.get(i), antibodiesCloneList);
//        }
//
//        Collections.sort(antibodiesCloneList, sortMaxToMin);
//        mutationClonePopulation(antibodiesCloneList);
//
//        //affinity clone to Ag
//        for (Antibody a : antibodiesCloneList) {
//            affinity(Ag2, a);
//        }
//
//        //Select
//        Collections.sort(antibodiesCloneList
//                , sortMinToMax);
//
//        //replace
//        for (int i = 0; i < 6; i++) {
//            if (antibodyList.get(i).getName().equals("Ab2")) {
//                if (antibodyList.get(i).getAffinity() >= antibodiesCloneList.get(0).getAffinity())
//                    antibodyList.get(i).setValue(antibodiesCloneList.get(0).getValue());
//            }
//
//        }
//
//
//        newPopulation.add(new Antibody("Ab1"));
//        newPopulation.add(new Antibody("Ab2"));
//        newPopulation.add(new Antibody("Ab3"));
//        newPopulation.add(new Antibody("Ab4"));
//        newPopulation.add(new Antibody("Ab5"));
//        newPopulation.add(new Antibody("Ab6"));
//
//
//        for (int i = 0; i < 6; i++) {
//
//            if (antibodyList.get(i).getName().equals("Ab4")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab5")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab6")) {
//                antibodyList.set(i, newPopulation.get(i));
//            }
//
//        }
//
//    }
//
//    private static void runAg3() {
//
//        List<Antibody> antibodiesCloneList = new ArrayList<Antibody>();
//        List<Antibody> newPopulation = new ArrayList<Antibody>();
//
//
//        for (Antibody a : antibodyList) {
//            affinity(Ag3, a);
//        }
//
//        // select by affinity
//        Collections.sort(antibodyList, sortMinToMax);
//
//        for (int i = 0; i < antibodyList.size(); i++) {
//
//            antibodyList.get(i).setPositionInPopulation(i + 1);
//        }
//
//        //count of copy and make clone
//        for (int i = 0; i < 4; i++) {
//            int index = i + 1;
//            int N = 6 / (index);
//            antibodyList.get(i).setCountOfClone(N);
//            makeClone(antibodyList.get(i), antibodiesCloneList);
//        }
//
//        Collections.sort(antibodiesCloneList, sortMaxToMin);
//        mutationClonePopulation(antibodiesCloneList);
//
//        //affinity clone to Ag
//        for (Antibody a : antibodiesCloneList) {
//            affinity(Ag3, a);
//        }
//
//        //Select
//        Collections.sort(antibodiesCloneList
//                , sortMinToMax);
//
//        //replace
//
//        for (int i = 0; i < 6; i++) {
//            if (antibodyList.get(i).getName().equals("Ab3")) {
//                if (antibodyList.get(i).getAffinity() >= antibodiesCloneList.get(0).getAffinity())
//                    antibodyList.get(i).setValue(antibodiesCloneList.get(0).getValue());
//            }
//
//        }
//
//
//        newPopulation.add(new Antibody("Ab1"));
//        newPopulation.add(new Antibody("Ab2"));
//        newPopulation.add(new Antibody("Ab3"));
//        newPopulation.add(new Antibody("Ab4"));
//        newPopulation.add(new Antibody("Ab5"));
//        newPopulation.add(new Antibody("Ab6"));
//
//
//        for (int i = 0; i < 6; i++) {
//
//            if (antibodyList.get(i).getName().equals("Ab4")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab5")) {
//                antibodyList.set(i, newPopulation.get(i));
//            } else if (antibodyList.get(i).getName().equals("Ab6")) {
//                antibodyList.set(i, newPopulation.get(i));
//            }
//
//        }
//    }
//
//
//    private static void mutationClonePopulation(List<Antibody> antibodiesCloneList) {
//
//        for (Antibody a : antibodiesCloneList) {
//
//            a.setpMutation((60 * (a.getPositionInPopulation() / 6.0)) / 100);
//            int index = 0;
//            int[] array = new int[12];
//            array = a.getValue();
//            for (int i = 0; i < 12 * a.getpMutation(); i++) {
//                index = random.nextInt(12);
//                if (array[index] == 0)
//                    array[index] = 1;
//                else array[index] = 0;
//            }
//            a.setValue(array);
//        }
//
//
//    }
//
//    private static void makeClone(Antibody antibody, List<Antibody> antibodiesCloneList) {
//        for (int i = 0; i < antibody.getCountOfClone(); i++) {
//            antibodiesCloneList.add(new Antibody(antibody));
//        }
//    }


    private static void affinity(Antibody currentAntBody) {

        double x1 = 0;
        double x2 = 0;

        for (int i = 0; i<currentAntBody.getX1().length-1;i++){

            x1 +=currentAntBody.getX1()[i]*Math.pow(2,i);
            x2 +=currentAntBody.getX2()[i]*Math.pow(2,i);

        }
        double f = Math.pow(x1,2)+Math.pow(x2,2)-Math.cos(18*x1)-Math.cos(18*x2);


//        int valueofaffinity = 0;
//        int[] array = currentAntBody.getValue();
//        for (int i = 0; i < 12; i++) {
//            if (antigen[i] != array[i]) {
//                valueofaffinity++;
//            }
//        }
//        currentAntBody.setAffinity(valueofaffinity);
    }
}
