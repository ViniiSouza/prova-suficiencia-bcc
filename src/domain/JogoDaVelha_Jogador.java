package domain;

import java.util.Scanner;

public class JogoDaVelha_Jogador {
    private JogoDaVelha_Mapa mapa;
    private char letra;

    public JogoDaVelha_Jogador(JogoDaVelha_Mapa pMapa) {
        mapa = pMapa;
        letra = 'X';
    }

    public boolean joga(Scanner teclado) {
        mapa.limpaMapa(); //temp
        boolean movimentoValido = false;
        do {
            int numeroLinha = 0;
            int numeroColuna = 0;

            boolean linhaValida = false;
            boolean colunaValida = false;

            do {
                System.out.println("Digite o número da linha (1 a 3):");
                String linha = teclado.nextLine();
                try {
                    numeroLinha = Integer.parseInt(linha);
                    if (numeroLinha > 0 && numeroLinha < 4)
                        linhaValida = true;
                }
                catch (NumberFormatException ex) {
                    linhaValida = false;
                }
            } while (!linhaValida);

            do {
                System.out.println("Digite o número da coluna (1 a 3):");
                String coluna = teclado.nextLine();
                try {
                    numeroColuna = Integer.parseInt(coluna);
                    if (numeroColuna > 0 && numeroColuna < 4)
                        colunaValida = true;
                }
                catch (NumberFormatException ex) {
                    colunaValida = false;
                }
            } while (!colunaValida);

            movimentoValido = mapa.jogar(numeroLinha, numeroColuna, letra);
        } while (!movimentoValido);

        mapa.desenha(2);
        return true;   
    }
}
