package com.company;

import java.util.Random;


public class Antibody {

    private String name;
    private int[] x1;
    private int[] x2;
    private int affinity;
    private int countofclone;
    private double pMutation;
    private int positionInPopulation;

    private Random r = new Random();


    public Antibody(String name) {
        this.name = name;
        this.x1 = new int [22];
        this.x2 = new int [22];
        for (int i = 0; i < x1.length; i++) {
            this.x1[i] = r.nextInt(2);
            this.x2[i] = r.nextInt(2);
        }
        affinity = 0;
        countofclone = 0;
        pMutation = 0;
        positionInPopulation = 0;
    }

    public Antibody(Antibody ab) {
        // this.name = ab.getName();
        this.x1 = new int[22];
        this.x2 = new int[22];

        for (int i = 0; i < 22; i++) {

            this.x1[i] = ab.getX1()[i];
            this.x2[i] = ab.getX2()[i];
        }

        this.affinity = ab.getAffinity();
        this.countofclone = ab.getCountOfClone();
        this.pMutation = ab.getpMutation();
        this.positionInPopulation = ab.getPositionInPopulation();

    }

    public int[] getX1() {
        return x1;
    }

    public void setX1(int[] x1) {
        this.x1 = x1;
    }

    public int[] getX2() {
        return x2;
    }

    public void setX2(int[] x2) {
        this.x2 = x2;
    }

    public int getPositionInPopulation() {
        return positionInPopulation;
    }

    public void setPositionInPopulation(int positionInPopulation) {
        this.positionInPopulation = positionInPopulation;
    }

    public double getpMutation() {
        return pMutation;
    }

    public void setpMutation(double pMutation) {
        this.pMutation = pMutation;
    }

    public int getCountOfClone() {
        return countofclone;
    }

    public void setCountOfClone(int countofclone) {
        this.countofclone = countofclone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getAffinity() {
        return affinity;
    }

    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }
}

