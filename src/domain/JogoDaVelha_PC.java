package domain;

public class JogoDaVelha_PC {
    private JogoDaVelha_Mapa mapa;
    private char letra;

    public JogoDaVelha_PC(JogoDaVelha_Mapa pMapa) {
        mapa = pMapa;
        letra = 'O';
    }

    public boolean joga() {
        boolean movimentoValido = false;
        while (!movimentoValido) {
            int linha = mapa.sortear(1, 3);
            int coluna = mapa.sortear(1, 3);
            movimentoValido = mapa.jogar(linha, coluna, letra);
            if (movimentoValido) {
                System.out.println("PC[" + linha + ", " + coluna + "]");
            }
        }
        if (mapa.ganhou(letra)) {
            System.out.println(" ... PC GANHOU!");
            return true;
        }
        return false;
    }
}
