package ACT7_4;


public class Main {
    public static void main(String[] args) {
        // Cotxe
        Cotxe cotxe = new Cotxe("Toyota", "Corolla", 20000, 120, "gasolina");
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Blanc"));
        cotxe.afegeixExtra(new Extra("Climatitzador", 1200));
        System.out.println(cotxe.toString());

        // Furgoneta
        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 25000, 150, "diesel");
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Verd"));
        furgoneta.afegeixExtra(new Extra("Porta lateral", 800));
        System.out.println(furgoneta.toString());

        // Moto
        Moto moto = new Moto("Yamaha", "MT-07", 7000, 75, "gasolina");
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Blau"));
        moto.afegeixExtra(new Extra("Porta equipatge", 1000));
        System.out.println(moto.toString());
        
        // Patinet
        Patinet patinet = new Patinet("Xiaomi", "Pro", 500, 10, 60);
        cotxe.afegeixCaracteristica(new Caracteristica("Color", "Negre"));
        patinet.afegeixExtra(new Extra("Llums", 50));
        System.out.println(patinet.toString());

        System.out.println("Cotxe i Moto són iguals? " + cotxe.equals(moto));
    }
}
