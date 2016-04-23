package com.company;

import java.util.Random;


public class Antibody {

    private String name;
    private int[] value;
    private int affinity;
    private int countofclone;
    private double pMutation;
    private int positionInPopulation;

    private Random r = new Random();


    public Antibody(String name) {
        this.name = name;
        this.value = new int[12];
        for (int i = 0; i < 12; i++) {
            this.value[i] = r.nextInt(2);
        }
        affinity = 0;
        countofclone = 0;
        pMutation = 0;
        positionInPopulation = 0;
    }

    public Antibody(Antibody ab){
        // this.name = ab.getName();
        this.value = new int[12];
        for(int i=0;i<ab.getValue().length;i++)
            this.value[i] = ab.getValue()[i];
        this.affinity = ab.getAffinity();
        this.countofclone = ab.getCountOfClone();
        this.pMutation = ab.getpMutation();
        this.positionInPopulation = ab.getPositionInPopulation();

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

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    public int getAffinity() {
        return affinity;
    }

    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }
}

