package domain;

import java.util.Scanner;

public class JogoDaVelha {
    private JogoDaVelha_Mapa jogoMapa;
    private JogoDaVelha_PC jogoPC;
    private JogoDaVelha_Jogador jogoJogador;

    private void jogar(Scanner teclado) {
        int jogada = 1;

        jogoMapa.limpaMapa();
        jogoMapa.desenha(jogada);

        boolean jogadorGanhou = false;
        boolean pcGanhou = false;
        boolean empate = false;

        int inicioJogada = jogoMapa.sortear(1, 2);

        if (inicioJogada == 2) {
            System.out.println("Computador começa!");
            jogoPC.joga();
            jogoMapa.desenha(jogada);
            jogada++;
        } else {
            System.out.println("Você começa!");
        }

        while (!jogadorGanhou && !pcGanhou && !empate) {
            jogadorGanhou = jogoJogador.joga(teclado);
            jogoMapa.desenha(jogada);
            jogada++;
            empate = jogoMapa.ganhou(' ');
            if (!jogadorGanhou && !empate)
                pcGanhou = jogoPC.joga();
                jogoMapa.desenha(jogada);
                jogada++;
        }

        if (empate)
            System.out.println("... EMPATOU!");
    }

    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        jogoMapa = new JogoDaVelha_Mapa();
        jogoPC = new JogoDaVelha_PC(jogoMapa);
        jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

        boolean continuarJogando = true;
        while (continuarJogando) {
            jogar(sc);
            System.out.println("Deseja jogar novamente (s/n)?");
            String jogarNovamente = sc.nextLine().toUpperCase();
            continuarJogando = jogarNovamente.equals("S");
        }
    }
}