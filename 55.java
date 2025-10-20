class Solution {
    /**
     * @brief Determina se é possível alcançar o último índice do array.
     * * @param nums O array onde cada elemento é o comprimento máximo do salto.
     * @return true se o último índice for alcançável, false caso contrário.
     */
    public boolean canJump(int[] nums) {
        // 'goal' (meta) representa o índice mais à esquerda que pode alcançar o fim.
        // Inicialmente, é o último índice do array.
        int goal = nums.length - 1;

        // Percorremos o array de trás para frente, do penúltimo índice até o primeiro (índice 0).
        for (int i = nums.length - 2; i >= 0; i--) {
            
            // Calculamos o alcance máximo a partir do índice atual (i).
            // alcance = (índice atual + valor do salto máximo)
            int alcance = i + nums[i];

            // Verificamos se, a partir do índice 'i', conseguimos alcançar 
            // a posição 'goal' (ou seja, a posição mais à esquerda que alcança o final).
            if (alcance >= goal) {
                // Se sim, o índice 'i' se torna a nova 'goal',
                // pois agora ele é o novo ponto mais à esquerda que leva ao final.
                goal = i;
            }
        }

        // Se a 'goal' final for 0, significa que o índice inicial (0) 
        // consegue alcançar o último índice (direta ou indiretamente).
        return goal == 0;
    }
}

