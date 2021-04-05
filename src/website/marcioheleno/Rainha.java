package website.marcioheleno;


import java.util.Arrays;

public class Rainha {

    static public int possibilidade = 0;

    public static int getPossibilidade() {
        return possibilidade;
    }

    public void criarTabuleiro(char[][] tabuleiro, int linha, int rowmask, int ldmask, int rdmask) {

        int n = tabuleiro.length;

        int todasAsLinhas = (1 << n) - 1;

        if (rowmask == todasAsLinhas) {
            possibilidade++;
            System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#");
            System.out.println("Rainha - " + possibilidade);
            System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#");
            imprimiTabuleiro(tabuleiro);
        }

        int safe = todasAsLinhas & (~(rowmask |
                ldmask | rdmask));
        while (safe > 0) {

            int p = safe & (-safe);
            int col = (int)(Math.log(p) / Math.log(2));
            tabuleiro[linha][col] = 'R';

            criarTabuleiro(tabuleiro, linha + 1, rowmask|p,
                    (ldmask|p) << 1, (rdmask|p) >> 1);

            safe = safe & (safe-1);

            tabuleiro[linha][col] = ' ';
        }
    }

    public void imprimiTabuleiro(char[][] tabuleiro) {
        Arrays.stream(tabuleiro).forEach(laterais -> {
            System.out.print("|");
            for (char div : laterais) System.out.print(div + "|");
            System.out.println();
        });
    }

}


