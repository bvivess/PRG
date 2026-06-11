package ex_extraordinario;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Marca> marcas = new HashSet<>();
        Set<Vehiculo> vehiculos = new HashSet<>();
        /*
        1,Toyota,Japón,4,RAV4,2022,Azul
            idMarca = 1
            nombreMarca = "Toyota"
            paisOrigen = "Japón"
        Vehiculo v = new Vehiculo(
            idVehiculo = 4 
            modelo = RAV4
            anio = 2022
            color = "Azul"
            marca = marca
        */

        /* c:\temp\vehiculos.csv
#idMarca,nombreMarca,paisOrigen,idVehiculo,modelo,anio,color
1,Toyota,Japón,1,Corolla,2020,Blanco
1,Toyota,Japón,2,Yaris,2021,Rojo
1,Toyota,Japón,3,Camry,2019,Negro
1,Toyota,Japón,4,RAV4,2022,Azul
1,Toyota,Japón,5,Aygo,2021,Gris
1,Toyota,Japón,6,C-HR,2023,Blanco
1,Toyota,Japón,7,Prius,2020,Verde
1,Toyota,Japón,8,Hilux,2022,Negro
1,Toyota,Japón,9,Land Cruiser,2021,Plata
1,Toyota,Japón,10,Supra,2023,Rojo
2,Ford,Estados Unidos,11,Fiesta,2019,Azul
2,Ford,Estados Unidos,12,Focus,2020,Blanco
2,Ford,Estados Unidos,13,Mondeo,2021,Negro
2,Ford,Estados Unidos,14,Kuga,2022,Gris
2,Ford,Estados Unidos,15,Puma,2023,Rojo
2,Ford,Estados Unidos,16,Mustang,2022,Amarillo
2,Ford,Estados Unidos,17,Explorer,2021,Negro
2,Ford,Estados Unidos,18,Ranger,2020,Blanco
2,Ford,Estados Unidos,19,Edge,2019,Azul
2,Ford,Estados Unidos,20,Bronco,2023,Verde
3,Volkswagen,Alemania,21,Golf,2020,Blanco
3,Volkswagen,Alemania,22,Polo,2021,Rojo
3,Volkswagen,Alemania,23,Passat,2019,Negro
3,Volkswagen,Alemania,24,Tiguan,2022,Azul
3,Volkswagen,Alemania,25,T-Roc,2023,Gris
3,Volkswagen,Alemania,26,Touareg,2021,Plata
3,Volkswagen,Alemania,27,Arteon,2020,Negro
3,Volkswagen,Alemania,28,Taigo,2022,Blanco
3,Volkswagen,Alemania,29,ID3,2023,Azul
3,Volkswagen,Alemania,30,ID4,2023,Rojo
4,BMW,Alemania,31,Serie 1,2020,Blanco
4,BMW,Alemania,32,Serie 2,2021,Negro
4,BMW,Alemania,33,Serie 3,2022,Azul
4,BMW,Alemania,34,Serie 4,2023,Rojo
4,BMW,Alemania,35,Serie 5,2021,Gris
4,BMW,Alemania,36,X1,2020,Blanco
4,BMW,Alemania,37,X3,2022,Negro
4,BMW,Alemania,38,X5,2023,Plata
4,BMW,Alemania,39,X7,2022,Azul
4,BMW,Alemania,40,Z4,2021,Amarillo
5,Mercedes,Alemania,41,Clase A,2020,Negro
5,Mercedes,Alemania,42,Clase B,2021,Blanco
5,Mercedes,Alemania,43,Clase C,2022,Azul
5,Mercedes,Alemania,44,Clase E,2023,Gris
5,Mercedes,Alemania,45,Clase S,2021,Plata
5,Mercedes,Alemania,46,GLA,2022,Rojo
5,Mercedes,Alemania,47,GLC,2023,Negro
5,Mercedes,Alemania,48,GLE,2021,Blanco
5,Mercedes,Alemania,49,GLS,2022,Azul
5,Mercedes,Alemania,50,AMG GT,2023,Amarillo
6,Renault,Francia,51,Clio,2020,Rojo
6,Renault,Francia,52,Megane,2021,Blanco
6,Renault,Francia,53,Captur,2022,Azul
6,Renault,Francia,54,Austral,2023,Gris
6,Renault,Francia,55,Arkana,2022,Negro
6,Renault,Francia,56,Espace,2021,Plata
6,Renault,Francia,57,Kangoo,2020,Blanco
6,Renault,Francia,58,Trafic,2022,Rojo
6,Renault,Francia,59,Scenic,2021,Azul
6,Renault,Francia,60,Twingo,2019,Verde
7,Seat,Espa?a,61,Ibiza,2020,Blanco
7,Seat,Espa?a,62,Leon,2021,Rojo
7,Seat,Espa?a,63,Ateca,2022,Negro
7,Seat,Espa?a,64,Arona,2023,Azul
7,Seat,Espa?a,65,Tarraco,2021,Gris
7,Seat,Espa?a,66,Toledo,2019,Plata
7,Seat,Espa?a,67,Alhambra,2020,Negro
7,Seat,Espa?a,68,Cordoba,2018,Blanco
7,Seat,Espa?a,69,Exeo,2017,Azul
7,Seat,Espa?a,70,Mii,2021,Rojo
8,Hyundai,Corea del Sur,71,i10,2020,Blanco
8,Hyundai,Corea del Sur,72,i20,2021,Rojo
8,Hyundai,Corea del Sur,73,i30,2022,Azul
8,Hyundai,Corea del Sur,74,Tucson,2023,Negro
8,Hyundai,Corea del Sur,75,Kona,2022,Gris
8,Hyundai,Corea del Sur,76,Santa Fe,2021,Plata
8,Hyundai,Corea del Sur,77,Bayon,2023,Blanco
8,Hyundai,Corea del Sur,78,Ioniq 5,2023,Azul
8,Hyundai,Corea del Sur,79,Ioniq 6,2023,Rojo
8,Hyundai,Corea del Sur,80,Staria,2022,Negro
9,Kia,Corea del Sur,81,Picanto,2020,Rojo
9,Kia,Corea del Sur,82,Rio,2021,Blanco
9,Kia,Corea del Sur,83,Ceed,2022,Azul
9,Kia,Corea del Sur,84,Sportage,2023,Negro
9,Kia,Corea del Sur,85,Niro,2022,Gris
9,Kia,Corea del Sur,86,Sorento,2021,Plata
9,Kia,Corea del Sur,87,Stonic,2023,Rojo
9,Kia,Corea del Sur,88,XCeed,2022,Blanco
9,Kia,Corea del Sur,89,EV6,2023,Azul
9,Kia,Corea del Sur,90,EV9,2024,Negro
10,Peugeot,Francia,91,208,2020,Amarillo
10,Peugeot,Francia,92,308,2021,Blanco
10,Peugeot,Francia,93,2008,2022,Rojo
10,Peugeot,Francia,94,3008,2023,Azul
10,Peugeot,Francia,95,5008,2022,Gris
10,Peugeot,Francia,96,Rifter,2021,Negro
10,Peugeot,Francia,97,Traveller,2020,Plata
10,Peugeot,Francia,98,508,2022,Blanco
10,Peugeot,Francia,99,e-208,2023,Azul
10,Peugeot,Francia,100,e-308,2024,Verde
        */
        
    }
    
}
