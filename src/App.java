import java.util.Scanner;

import domain.JogoDaVelha_Jogador;
import domain.JogoDaVelha_Mapa;
import domain.JogoDaVelha_Jogador;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        new JogoDaVelha_Jogador(new JogoDaVelha_Mapa()).joga(sc);
    }
}
