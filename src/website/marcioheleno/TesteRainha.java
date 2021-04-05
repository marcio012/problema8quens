package website.marcioheleno;

public class TesteRainha {

    public static void main(String args[]) {

        int tamanhoMatriz = 8;

        char[][] board = tabuleiro(tamanhoMatriz);

        int mm = 0;
        int linhaM = 0;
        int colM = 0;
        int linha = 0;

        Rainha rainha = new Rainha();

        rainha.criarTabuleiro(board, linha, mm, linhaM, colM);
        System.out.println();
        System.out.println("Numero de possibilidade de movimento " + tamanhoMatriz + " rainha : " + Rainha.getPossibilidade());
    }

    private static char[][] tabuleiro(int tamanhoMatriz) {
        char tabuleiro[][] = new char[tamanhoMatriz][tamanhoMatriz];
        int i = 0;
        while (i < tamanhoMatriz) {
            for (int j = 0; j < tamanhoMatriz; j++) tabuleiro[i][j] = ' ';
            i++;
        }
        return tabuleiro;
    }
}
