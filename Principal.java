public class Principal {
    public static void main(String[] args) {

        System.out.println("Digite um nome pro seu Tamagotchi:");
        String nome = Teclado.leString();
        Tamagotchi tamagotchi = new Tamagotchi(nome);
        System.out.println(tamagotchi.toString());

        int range = 3; // 3 opcoes
        for (int i = 0; i < 20; i++) {
            int rand = (int) (Math.random() * range) + 1; // + 1 pra não incluir o 0
            // System.out.println(rand);
            if (rand == 1) { // fome
                tamagotchi.sentirFome(); // sentimento
                tamagotchi.menuComer(); // menu
                // pega informacao do usuário
                int opcao = Teclado.leInt();
                // se voltar true é pq o bicho morreu
                if (tamagotchi.comer(opcao)) {
                    System.out.println(tamagotchi.toString());
                    // para o loop pq o bicho morreu
                    break;
                }
                // status do bicho
                System.out.println(tamagotchi.toString());
            } else if (rand == 2) { // sono
                tamagotchi.sentirSono(); // sentimento
                tamagotchi.menuSono(); // menu
                // pega info do user
                int opcao = Teclado.leInt();
                if (tamagotchi.dormir(opcao)) {
                    // se true é pq ele morreu
                    System.out.println(tamagotchi.toString());
                    break;
                }
                System.out.println(tamagotchi.toString());

            } else { // rand == 3 | tédio
                tamagotchi.sentirTedio(); // sentimento
                tamagotchi.menuExercicio(); // menu
                // pega info do usuário
                int opcao = Teclado.leInt();
                if (tamagotchi.exercitar(opcao) == 1) {
                    // se 1 é pq ele morreu
                    System.out.println(tamagotchi.toString());
                    break;
                } else if (tamagotchi.exercitar(opcao) == 2) {
                    // se 2 é pra mostrar menu de fome
                    tamagotchi.menuComer();
                    opcao = Teclado.leInt();
                    if (tamagotchi.comer(opcao)) {
                        System.out.println(tamagotchi.toString());
                        // para o loop pq o bicho morreu
                        break;
                    }
                    // status do bicho
                    System.out.println(tamagotchi.toString());
                } else { // se 3 é pra seguir o baile
                    System.out.println(tamagotchi.toString());
                }
            }
        }
    }
}