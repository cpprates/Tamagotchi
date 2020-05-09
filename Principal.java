public class Principal {
    public static void main(String[] args) {

        // Pede que o usuário digite o nome do Tamagotchi e o cria
        String nome = Teclado.leString("Digite um nome para o seu Tamagotchi:");
        Tamagotchi tamagotchi = new Tamagotchi(nome);
        status(tamagotchi); //imprime status

        int range = 3; // 3 opcoes
        while (true) {
            int rand = (int) (Math.random() * range) + 1; // + 1 pra não incluir o 0
            // System.out.println(rand);
            if (rand == 1) { // fome
                tamagotchi.sentirFome(); // sentimento
                tamagotchi.menuComer(); // menu

                // pega informacao do usuário
                int opcao = Teclado.leInt();

                if (tamagotchi.comer(opcao)) { // se voltar true é pq o bicho morreu
                    status(tamagotchi);
                    // para o loop pq o bicho morreu
                    break;
                }
                status(tamagotchi); // status do bicho
            } else if (rand == 2) { // sono
                tamagotchi.sentirSono(); // sentimento
                tamagotchi.menuSono(); // menu
                
                // pega info do usuario
                int opcao = Teclado.leInt();
                if (tamagotchi.dormir(opcao)) {
                    // se true é pq ele morreu
                    status(tamagotchi);
                    break;
                }
                // imprime status
                status(tamagotchi);

            } else { // rand == 3 | tédio
                tamagotchi.sentirTedio(); // sentimento
                tamagotchi.menuExercicio(); // menu
                // pega info do usuário
                int opcao = Teclado.leInt();
                int res = tamagotchi.exercitar(opcao);
                if (res == -1) {
                    // se voltar 1 é pq ele morreu
                    status(tamagotchi);
                    break;
                } else if (res == 2) {
                    // se voltar 2 é pra mostrar menu de fome
                    tamagotchi.menuComer();
                    opcao = Teclado.leInt();
                    if (tamagotchi.comer(opcao)) {
                        status(tamagotchi);
                        // para o loop pq o bicho morreu
                        break;
                    }
                    // status do bicho
                    status(tamagotchi);
                } else if (res == 3) { // se 3 é pra seguir o baile
                    status(tamagotchi);
                }
            }
        }
    }

    static void status(Tamagotchi t) {
        System.out.println(t.toString());
    }
}