public class Tamagotchi {
    String nome;
    int idade; // dias
    int peso; // quilos

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
        // se passar de 20 kg ele explode
    }

    public String toString() {
        return "\nNome: " + nome + "\nIdade (dias): " + idade + "\nPeso (kg): " + peso + "\n";
    }

    public void sentirSono() {
        System.out.println("- " + nome + ": Estou com sono zZzzZ");
    }

    public void sentirFome() {
        System.out.println("- " + nome + ": Nhamm fominha...");
    }

    public void sentirTedio() {
        System.out.println("- " + nome + ": Nada pra fazer, tédio :/");
    }

    public boolean comer(int comer) {
        if (comer == 1) { // pouco
            peso = peso + 1;
            if (peso > 20) {
                explodir();
                // retorna true para acabar o programa
                return true;
            }
        } else if (comer == 2) { // muito
            peso = peso + 5;
            // explode se o peso for maior que 20kg
            if (peso > 20) {
                explodir();
                // retorna true para acabar o programa
                return true;
            } else {
                // deve dormir logo depois
                dormir(1);
            }
        } else if (comer == 3) { // não comer
            peso = peso - 2;
            // se chegar a 0 kg ele morre
            if (peso <= 0) {
                desnutrido();
                // retorna true para acabar com o programa
                return true;
            }
        }
        return false;
    }

    int acordado = 0;

    public boolean dormir(int dormir) {
        if (dormir == 1) { // dormmir
            idade = idade + 1;
        } else if (dormir == 2) { // permanecer acordado
            // se permanecer acordado por 5x ele dorme automaticamente
            acordado = acordado + 1;
            if (acordado >= 5) {
                acordado = 0;
                // dorme automaticamente
                idade = idade + 1;
            }
        }
        if (idade >= 15) {
            morrer();
            // retorna true se ele morrer
            return true;
        }
        // retorna false pq ele ta vivo ainda
        return false;
    }

    public int exercitar(int quanto) {
        if (quanto == 1) { // caminhar 10 min
            peso = peso - 1; // emagrece 1 kg
            // verifica peso
            if (peso <= 0) {
                desnutrido();
                return -1; // se ele morrer volta -1
            } else {
                // fica com fome
                sentirFome();
                // retorna 2 para mostrar menu com fome
                return 2;
            }
        } else if (quanto == 2) { // correr 10 min
            peso = peso - 4; // emagrece 4 kg
            if (peso <= 0) {
                desnutrido();
                return -1; // se ele morrer volta -1
            } else {
                // come muito (opcao 2)
                comer(2);
                System.out.println("ATENCÃO: " + nome + "comeu muito depois do exercício\ne engordou 5kg!");
                return 3; // retorna 3 p seguir o baile
            }
        }
        return 3; // retorna 3 pra seguir o baile
    }

    public void morrer() {
        System.out.println("Morri de velho. Cheguei em 15 dias de vida.");
    }

    public void desnutrido() {
        System.out.println("Morri desnutrido. Meu peso foi a 0 kg.");
    }

    public void explodir() {
        System.out.println("Explodi de tão gordo. Meu peso passou de 20 kg.");
    }

    public void menuComer() {
        System.out.println("Digite o número:");
        System.out.println("(1). Comer pouco");
        System.out.println("(2). Comer muito");
        System.out.println("(3). Não comer");
    }

    public void menuSono() {
        System.out.println("Digite o número:");
        System.out.println("(1). Dormir");
        System.out.println("(2). Permanecer acordado");
    }

    public void menuExercicio() {
        System.out.println("Digite o número:");
        System.out.println("(1). Caminhar 10 minutos");
        System.out.println("(2). Correr 10 minutos");
    }
}