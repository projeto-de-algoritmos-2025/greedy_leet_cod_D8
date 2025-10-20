class Solution {
    /**
     * Implementa o casamento de padrões com curingas '?' e '*'.
     *
     * @param s A string de entrada.
     * @param p O padrão com curingas.
     * @return true se s corresponder a p, false caso contrário.
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        // dp[i][j] será true se o prefixo s[0..i-1] corresponder ao prefixo p[0..j-1]
        // O tamanho é (n+1) x (m+1) para incluir o caso de string vazia (índice 0)
        boolean[][] dp = new boolean[n + 1][m + 1];

        // 1. Caso Base: Duas strings vazias correspondem.
        dp[0][0] = true;

        // 2. Lidar com o '*' no padrão quando a string s está vazia.
        // Se p = "***", dp[0][3] deve ser true.
        for (int j = 1; j <= m; j++) {
            // O caractere atual no padrão é p.charAt(j - 1)
            if (p.charAt(j - 1) == '*') {
                // Se for um '*', a correspondência depende de p[0..j-2]
                dp[0][j] = dp[0][j - 1];
            }
        }

        // 3. Preencher a tabela DP
        for (int i = 1; i <= n; i++) { // Iterar sobre a string s
            for (int j = 1; j <= m; j++) { // Iterar sobre o padrão p
                
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                // Caso 1: Caractere Normal ou '?'
                if (sChar == pChar || pChar == '?') {
                    // A correspondência é verdadeira se os prefixos anteriores correspondiam
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // Caso 2: Curinga '*'
                else if (pChar == '*') {
                    // O '*' pode ser:
                    // a) Não utilizado (representa sequência vazia): dp[i][j-1]
                    //    A correspondência é verdadeira se s[0..i-1] corresponde a p[0..j-2]
                    // OU
                    // b) Corresponder a sChar (o '*' "come" s[i-1]): dp[i-1][j]
                    //    A correspondência é verdadeira se s[0..i-2] corresponde a p[0..j-1]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                // Caso 3: Caracteres diferentes sem curinga
                // Permanece false (já inicializado assim)
            }
        }

        // O resultado final é se a string s inteira corresponde ao padrão p inteiro
        return dp[n][m];
    }
}

