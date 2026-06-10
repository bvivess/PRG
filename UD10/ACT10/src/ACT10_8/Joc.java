package ACT10_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Joc {
    private Tauler tauler;
    private List<Posicio> cuc;
    private List<Posicio> fulles;
    private EstatJoc estat;

    private Scanner scanner;
    private Random random;

    public Joc() {
        cuc = new ArrayList<>();
        fulles = new ArrayList<>();
        estat = EstatJoc.EN_CURS;
    }
    
    public void iniciarJoc(int mida, int numFulles) {
        scanner = new Scanner(System.in);
        random = new Random();

        tauler = new Tauler(mida);

        // Inicialitzar 'cuc'
        cuc.add(generarPosicioAleatoria());

        // Inicialitzar 'fulles'
        for (int i = 0; i < numFulles; i++) {
            Posicio posFulla;

            do {
                posFulla = generarPosicioAleatoria();
            } while (ocupada(posFulla));

            fulles.add(posFulla);
        }
    }

    public void jugar(int mida, int nFulles) {
        iniciarJoc(mida, nFulles);
        do {
            mostrarTauler();

            Direccio direccio = llegirDireccio();

            if (direccio != null) {
                processarMoviment(direccio);
            }
        } while (estat == EstatJoc.EN_CURS);

        mostrarMissatgeFinal();
    }

    private void processarMoviment(Direccio direccio) {
        Posicio novaPosicio = calcularNovaPosicio(direccio);

        if (cuc.contains(novaPosicio)) 
            estat = EstatJoc.PERDUT;
        else {
            Posicio posFulla = cercarFulla(novaPosicio);

            if (posFulla != null) {
                cuc.add(novaPosicio);
                fulles.remove(posFulla);

                if (fulles.isEmpty())
                    estat = EstatJoc.GUANYAT;
            } else { 
                cuc.add(novaPosicio);
                cuc.remove(0);
            }
        }
    }

    private Direccio llegirDireccio() {
        System.out.print( "Puntuació: " + cuc.size() + " | 8:ALT 2:BAIX 4:ESQ 6:DRETA 0:SORTIR: ");

        int opcio = scanner.nextInt();

        switch(opcio) {
            case 8: return Direccio.AMUNT;
            case 2: return Direccio.AVALL;
            case 4: return Direccio.ESQUERRA;
            case 6: return Direccio.DRETA;
            case 0: 
                    estat = EstatJoc.SORTIDA;
                    return null;
            default: return null;
        }
    }

    private Posicio calcularNovaPosicio(Direccio direccio) {
        Posicio cap = cuc.get(cuc.size()-1);

        int fila = cap.getFila();
        int columna = cap.getColumna();

        switch (direccio) {
            case AMUNT    -> fila = (fila == 0) ? tauler.getMida() - 1 : fila - 1;
            case AVALL    -> fila = (fila == tauler.getMida() - 1) ? 0 : fila + 1;
            case ESQUERRA -> columna = (columna == 0) ? tauler.getMida() - 1 : columna - 1;
            case DRETA    -> columna = (columna == tauler.getMida() - 1) ? 0 : columna + 1;
        }
        
        return new Posicio(fila, columna);
    }

    private Posicio generarPosicioAleatoria() {
        return new Posicio(
                random.nextInt(tauler.getMida()),
                random.nextInt(tauler.getMida()));
    }
    
    private boolean ocupada(Posicio posicio) {
        if (cuc != null && cuc.contains(posicio))
            return true;

        for (Posicio f : fulles)
            if (f.equals(posicio))
                return true;

        return false;
    }

    private Posicio cercarFulla(Posicio posicio) {
        for (Posicio f : fulles)
            if (f.equals(posicio))
                return f;

        return null;
    }

    private void mostrarTauler() {
        tauler.mostrarTauler(cuc, fulles);
    }

    private void mostrarMissatgeFinal() {
        switch (estat) {
            case GUANYAT -> System.out.println("YOU WIN !!");
            case PERDUT -> System.out.println("YOU LOSE !!");
            case SORTIDA -> System.out.println("Joc finalitzat.");
            default -> {
            }
        }
    }
}