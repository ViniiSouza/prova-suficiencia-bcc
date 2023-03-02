package domain;

public class JogoDaVelha_Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) {
        return 1;
    }

    public void limpaMapa() {
        mapa[0] = new char[]{ ' ', ' ', ' '};
        mapa[1] = new char[]{ ' ', ' ', ' '};
        mapa[2] = new char[]{ ' ', ' ', ' '};
    }

    public void desenha(int jogada) {
        System.out.println("|-----------------|");
        System.out.println(String.format("|  %s  |  %s  |  %s  |", mapa[0][0], mapa[0][1], mapa[0][2]));
        System.out.println("|-----------------|");
        System.out.println(String.format("|  %s  |  %s  |  %s  |", mapa[1][0], mapa[1][1], mapa[1][2]));
        System.out.println("|-----------------|");
        System.out.println(String.format("|  %s  |  %s  |  %s  |", mapa[2][0], mapa[2][1], mapa[2][2]));
        System.out.println("|-----------------|");
    }

    public boolean jogar(int l, int c, char jogador) {
        l--;
        c--;
        if (mapa[l][c] == ' ') {
            mapa[l][c] = jogador;
            return true;
        }
        System.out.println("O campo já foi preenchido. Tente novamente!");
        return false;
    }

    public boolean ganhou(char jogador) {
        return true;
    }
}
