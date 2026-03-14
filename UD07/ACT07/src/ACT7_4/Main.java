package ACT7_4;


public class Main {
    public static void main(String[] args) {
        // Cotxe1
        System.out.println("------------------------");
        Cotxe cotxe1 = new Cotxe("Toyota", "Corolla", 20000, 120, "gasolina");
        cotxe1.afegeixCaracteristica(new Caracteristica("Color", "Blanc"));
        cotxe1.afegeixCaracteristica(new Caracteristica("Portes", "5"));
        cotxe1.afegeixCaracteristica(new Caracteristica("Equipament", "Sport"));
        cotxe1.afegeixExtra(new Extra("Climatitzador", 1200));
        System.out.println(cotxe1.toString());
        
        // Cotxe2
        System.out.println("------------------------");
        Cotxe cotxe2 = new Cotxe("Toyota", "Corolla", 20000, 120, "benzina");
        cotxe2.afegeixCaracteristica(new Caracteristica("Color", "Blau"));
        cotxe2.afegeixCaracteristica(new Caracteristica("Portes", "3"));
        cotxe2.afegeixExtra(new Extra("Climatitzador", 1200));
        System.out.println(cotxe2.toString());
        
        // Furgoneta
        System.out.println("------------------------");
        Furgoneta furgoneta = new Furgoneta("Ford", "Transit", 25000, 150, "diesel");
        cotxe1.afegeixCaracteristica(new Caracteristica("Color", "Verd"));
        furgoneta.afegeixExtra(new Extra("Porta lateral", 800));
        System.out.println(furgoneta.toString());

        // Moto
        System.out.println("------------------------");
        Moto moto = new Moto("Yamaha", "MT-07", 7000, 75, "gasolina");
        cotxe1.afegeixCaracteristica(new Caracteristica("Color", "Blau"));
        moto.afegeixExtra(new Extra("Porta equipatge", 1000));
        System.out.println(moto.toString());
        
        // Patinet
        System.out.println("------------------------");
        Patinet patinet = new Patinet("Xiaomi", "Pro", 500, 10, 60);
        cotxe1.afegeixCaracteristica(new Caracteristica("Color", "Negre"));
        patinet.afegeixExtra(new Extra("Llums", 50));
        System.out.println(patinet.toString());

        System.out.println("------------------------");
        System.out.println("Cotxe i Moto són iguals? " + cotxe1.equals(cotxe2));
    }
}
