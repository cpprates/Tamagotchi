public class Tamagotchi {
    private String nome;
    private int idade; // dias
    private int peso; // quilos

    public Tamagotchi(String nome) {
        this.nome = nome;
        idade = 0; // dias
        peso = 1; // kg
    }

    // getters e setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getPeso() {
        return peso;
    }

    public String toString() {
        return "\nNome: " + nome + "\nIdade (dias): " + idade + "\nPeso (kg): " + peso + "\n";
    }

    // Sentimentos
    public String fome() {
        String fome = " *    *  *  *  *****  **** \n" + " * *  *  *  *  *   *  *    \n"
                + " *  * *  ****  * * *  *    \n" + " *    *  *  *  *   *  **** \n" + "           *               \n"
                + "          *                \n" + "   *******                 \n" + "  *       *                \n"
                + " *  ** **  *               \n" + " *  *****  *               \n" + " *  *   *  *               \n"
                + " *  *****  *               \n" + "  *********                \n" + "- " + nome
                + ": Estou com fome!\n" + "Escolha uma opcão:\n1) Comer pouco\n2) Comer muito\n3) Não comer\n";
        return fome;
    }

    public String sono() {
        String sono = "              ****  ****  ****\n" + "                 *     *     *\n"
                + "                *     *     * \n" + "               *     *     *  \n"
                + "              *     *     *   \n" + "              ****  ****  ****\n"
                + "           *                  \n" + "          *                   \n"
                + "   *******                    \n" + "  *       *                   \n"
                + " *  ** **  *                  \n" + " *         *                  \n"
                + " *    *    *                  \n" + "  *********                   \n" + "- " + nome
                + ": Estou com sono!\n" + "Escolha uma opcão:\n1) Dormir\n2) Permanecer acordado\n";
        return sono;
    }

    public String tedio() {
        String tedio = " ******  *     ***** ***** \n" + " *   **  *     *     *     \n"
                + " ****    *     ****  ****  \n" + " *   **  *     *     *     \n" + " ******  ****  ***** ***** \n"
                + "           *               \n" + "          *                \n" + "   *******                 \n"
                + "  *       *                \n" + " *  ** **  *               \n" + " *         *               \n"
                + " *  *****  *               \n" + "  *********                \n" + "- " + nome
                + ": Estou com tédio!\n" + "Escolha uma opcão:\n1) Caminhar 10 minutos\n2) Correr 10 minutos\n";
        return tedio;
    }

    // Acões
    public void comer(int comer) {

        switch (comer) {
            case 1: // pouco
                peso = peso + 1;
                break;

            case 2: // muito
                peso = peso + 5;
                if (!isObeso()) {
                    dormir(1); // deve dormir logo depois
                }
                break;

            case 3: // não comer
                peso = peso - 2;
                break;
        }
    }

    int acordado = 0;

    public void dormir(int dormir) {

        switch (dormir) {
            case 1: // dormir
                idade = idade + 1;
                acordado = 0;
                break;
            case 2: // permanecer acordado
                acordado = acordado + 1;
                // se permanecer acordado por 5x, dorme automaticamente
                if (acordado >= 5) {
                    acordado = 0;
                    idade = idade + 1; // dorme automaticamente
                }
                break;
        }
    }

    public void exercitar(int exercitar) {
        switch (exercitar) {
            case 1: // caminhar 10 min
                peso = peso - 1; // emagrece 1 kg

                if (!isDesnutrido()) {
                    System.out.println(toString());
                    int opcao = Teclado.leInt(fome());
                    while (opcao > 3 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }
                    comer(opcao);
                }
                break;

            case 2: // correr 10 min
                peso = peso - 4; // emagrece 4 kg

                if (!isDesnutrido()) {
                    comer(2); // come muito (opcao 2)
                }
                break;
        }
    }

    // verificadores de situacão vital
    public boolean isVelho() {
        return this.idade > 14 ? true : false;
    }

    public boolean isDesnutrido() {
        return this.peso <= 0 ? true : false;
    }

    public boolean isObeso() {
        return this.peso > 20 ? true : false;
    }

    // se o tamagotchi morrer retorna true
    public boolean isMorto() {
        if (isVelho()) { // velho
            morrerIdade();
            return true;
        } else if (isDesnutrido()) { // desnutrido
            morrerDesnutrido();
            return true;
        } else if (isObeso()) { // obeso
            morrerExplodir();
            return true;
        } else {
            System.out.println(toString());
            return false;
        }
    }

    public void morrerIdade() {
        String velho = "   *******                 \n" + "  *       *                \n"
                + " *  ** **  *               \n" + " *         *               \n" + " *   ***   *               \n"
                + " *  *   *  *               \n" + "  *********                \n"
                + "Morri de velho. Cheguei em 15 dias de vida!";
        System.out.println(velho);
    }

    public void morrerDesnutrido() {
        String desnutrido = "   ****                 \n" + "  *    *                \n" + " * *  * *               \n"
                + " *  **  *               \n" + " * *  * *               \n" + "  ******                \n"
                + "Morri desnutrido. Meu peso foi a 0 kg!";
        System.out.println(desnutrido);
    }

    public void morrerExplodir() {
        String obeso = "    ***********                 \n" + "  *             *                \n"
                + " *     ** **     *               \n" + " *               *               \n"
                + " *     *****     *               \n" + " *    *     *    *               \n"
                + " *    *     *    *               \n" + "  ***************                \n"
                + "Explodi de tão gordo. Meu peso passou de 20 kg!";
        System.out.println(obeso);
    }
}