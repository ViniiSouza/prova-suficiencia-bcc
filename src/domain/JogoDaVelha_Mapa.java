package domain;

public class JogoDaVelha_Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim) {
        return (int)Math.floor(Math.random() * (fim - inicio + 1) + inicio);
    }

    public void limpaMapa() {
        mapa[0] = new char[]{ ' ', ' ', ' '};
        mapa[1] = new char[]{ ' ', ' ', ' '};
        mapa[2] = new char[]{ ' ', ' ', ' '};
    }

    public void desenha(int jogada) {
        System.out.println("|-----------------| .. Jogada: " + jogada);
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
        return false;
    }

    public boolean ganhou(char jogador) {
        boolean ganhou = false;

        // testa empate
        if (jogador == ' ') {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (mapa[i][j] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }

        for (int i = 0; i < 3; i++)
            {
                for (int j = 0; j < 1; j++)
                {
                    if (mapa[i][j] == jogador && mapa[i][j] == mapa[i][j + 1] && mapa[i][j + 1] == mapa[i][j + 2])
                    {
                        return true;
                    }
                }
            }

            for (int i = 0; i < 1; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    if (mapa[i][j] == jogador && mapa[i][j] == mapa[i + 1][j] && mapa[i + 1][j] == mapa[i + 2][j])
                    {
                        return true;
                    }
                }
            }

            if ((mapa[0][0] == jogador && mapa[0][0] == mapa[1][1] && mapa[1][1] == mapa[2][2]) || (mapa[2][0] == jogador && mapa[2][0] == mapa[1][1] && mapa[1][1] == mapa[0][2])) return true;

            //

        if (ganhou) {
            return true;
        }
        return false;
    }
}
