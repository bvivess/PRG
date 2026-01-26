package ACT7_4;


public class Main {
    public static void main(String[] args) {
        Cotxe cotxe = new Cotxe("Toyota", "Corolla", 20000, 120, "gasolina");
        cotxe.afegeixExtra(new Extra("Climatitzador", 1200));
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Blanc"));

        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 25000, 150, "diesel");
        furgoneta.afegeixExtra(new Extra("Porta lateral", 800));

        Moto moto = new Moto("Yamaha", "MT-07", 7000, 75, "gasolina");
        Patinet patinet = new Patinet("Xiaomi", "Pro", 500, 10, 60);

        System.out.println(cotxe);
        System.out.println(furgoneta);
        System.out.println(moto);
        System.out.println(patinet);

        System.out.println("Cotxe i Moto són iguals? " + cotxe.equals(moto));
    }
}
