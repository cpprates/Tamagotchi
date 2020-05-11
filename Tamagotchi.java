public class Tamagotchi {
    private String nome;
    private int idade; // dias
    private int peso; // quilos

    public Tamagotchi(String nome) {
        this.nome = nome;
        idade = 0; // dias
        peso = 1; // kg
    }

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
        return "- " + nome + ": Nhamm fominha...\nEscolha uma opcão:\n1). Comer pouco\n2). Comer muito\n3). Não comer";
    }

    public String sono() {
        return "- " + nome + ": Estou com sono zZzzZ\nEscolha uma opcão:\n1). Dormir\n2). Permanecer acordado";
    }

    public String tedio() {
        return "- " + nome
                + ": Nada pra fazer, tédio :/\nEscolha uma opcão:\n1). Caminhar 10 minutos\n2). Correr 10 minutos";
    }

    // Acões
    public boolean comer(int comer) {

        switch (comer) {
            case 1: // pouco
                peso = peso + 1;
                if (isMorto()) {
                    return true;
                }
                break;

            case 2: // muito
                peso = peso + 5;
                if (isMorto()) {
                    return true;
                } else {
                    dormir(1); // deve dormir logo depois
                }
                break;

            case 3: // não comer
                peso = peso - 2;

                if (isMorto()) {
                    return true;
                }
                break;
        }
        return false;
    }

    int acordado = 0;

    public boolean dormir(int dormir) {

        switch (dormir) {
            case 1: // dormir
                idade = idade + 1;
                if (isMorto()) {
                    return true;
                }
                break;
            case 2: // permanecer acordado
                acordado = acordado + 1;
                if (acordado >= 5) { // se permanecer acordado por 5x, dorme automaticamente
                    acordado = 0;
                    idade = idade + 1; // dorme automaticamente
                }
                if (isMorto()) {
                    return true;
                }
                break;
        }
        return false; // retorna false porque ta vivo
    }

    public boolean exercitar(int exercitar) {
        switch (exercitar) {
            case 1: // caminhar 10 min
                peso = peso - 1; // emagrece 1 kg
                if (isMorto()) {
                    return true; // morreu
                } else {
                    System.out.println(toString());
                    int opcao = Teclado.leInt(fome());
                    while (opcao > 3 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }
                    if (comer(opcao)) {
                        return true; // morreu
                    }
                    return false;
                }

            case 2: // correr 10 min
                peso = peso - 4; // emagrece 4 kg
                if (isMorto()) {
                    return true;
                } else {
                    comer(2); // come muito (opcao 2)
                    System.out.println("ATENCÃO: " + nome + " comeu muito depois do exercício\ne engordou 5kg!");
                    if (isMorto()) {
                        return true;
                    } else {
                        return false;
                    }
                }
        }
        return false;
    }

    public boolean isMorto() { // se morre retorna true
        if (idade > 14) { // velho
            System.out.println("Morri de velho. Cheguei em 15 dias de vida.");
            return true;
        } else if (peso <= 0) { // desnutrido
            System.out.println("Morri desnutrido. Meu peso foi a 0 kg.");
            return true;
        } else if (peso > 20) { // obeso
            System.out.println("Explodi de tão gordo. Meu peso passou de 20 kg.");
            return true;
        }
        return false;
    }
}