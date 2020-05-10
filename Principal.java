public class Principal {
    public static void main(String[] args) {

        // Pede que o usuário digite o nome do Tamagotchi e o cria
        Tamagotchi tamagotchi = new Tamagotchi(Teclado.leString("Digite o nome do seu Tamagotchi:"));
        status(tamagotchi); // imprime status
        boolean vivo = true;

        int range = 3; // 3 opcoes de sentimento para o random

        while (vivo) {
            int rand = (int) (Math.random() * range) + 1; // + 1 pra não incluir o 0
            int opcao;
            switch (rand) {
                case 1: // Rand == 1 / Fome

                    // pega informacao do usuário
                    opcao = Teclado.leInt(tamagotchi.fome());
                    if (tamagotchi.comer(opcao)) { // se retornar true é porque morreu
                        vivo = false; // tamagotchi morre
                    }
                    status(tamagotchi); // status do tamagotchi
                    break;
                case 2: // Rand == 2 / Sono

                    // pega informacao do usuario
                    opcao = Teclado.leInt(tamagotchi.sono());
                    if (tamagotchi.dormir(opcao)) { // se retornar true é porque morreu
                        vivo = false; // tamagotchi morre
                    }
                    status(tamagotchi); // status do tamagotchi
                    break;

                case 3: // Rand == 3 / Tédio

                    // pega informacao do usuário
                    opcao = Teclado.leInt(tamagotchi.tedio());
                    int res = tamagotchi.exercitar(opcao);
                    if (res == -1) { // se retornar -1 é porque morreu
                        vivo = false; // tamagotchi morre

                    } else if (res == 2) { // se retornar 2 é pra mostrar menu de fome

                        // pega informacao do usuário
                        opcao = Teclado.leInt(tamagotchi.fome());
                        if (tamagotchi.comer(opcao)) { // se retornar true é porque morreu
                            vivo = false; // tamagotchi morre
                        }
                    } // se retornar 3 é para continuar
                    status(tamagotchi);
                    break;
            }
        }
    }

    static void status(Tamagotchi t) {
        System.out.println(t.toString());
    }
}