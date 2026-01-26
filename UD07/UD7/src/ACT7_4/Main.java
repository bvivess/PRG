package ACT7_4;


public class Main {
    public static void main(String[] args) {
        // Cotxe
        Cotxe cotxe = new Cotxe("Toyota", "Corolla", 20000, 120, "gasolina");
        cotxe.afegeixExtra(new Extra("Climatitzador", 1200));
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Blanc"));
        System.out.println(cotxe.toString());

        // Furgoneta
        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 25000, 150, "diesel");
        furgoneta.afegeixExtra(new Extra("Porta lateral", 800));
        System.out.println(furgoneta.toString());

        // Moto
        Moto moto = new Moto("Yamaha", "MT-07", 7000, 75, "gasolina");
        System.out.println(moto.toString());
        
        // Patinet
        Patinet patinet = new Patinet("Xiaomi", "Pro", 500, 10, 60);
        System.out.println(patinet.toString());

        System.out.println("Cotxe i Moto són iguals? " + cotxe.equals(moto));
    }
}
