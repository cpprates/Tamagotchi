public class Principal {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi(Teclado.leString("Digite o nome do seu Tamagotchi:"));
        status(tamagotchi); // status do tamagotchi
        boolean vivo = true;
        int range = 3; // 3 opcoes de sentimento para o random

        while (vivo) {
            int rand = (int) (Math.random() * range) + 1; // + 1 pra não incluir o 0
            int opcao;
            switch (rand) {
                case 1: // Rand == 1 / Fome

                    opcao = Teclado.leInt(tamagotchi.fome()); // pega informacao do usuário
                    while (opcao > 3 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }

                    vivo = !(tamagotchi.comer(opcao)); // Se retornar true é porque ele morreu (vivo = false).
                    status(tamagotchi); // status do tamagotchi
                    break;
                case 2: // Rand == 2 / Sono

                    opcao = Teclado.leInt(tamagotchi.sono()); // pega informacao do usuario
                    while (opcao > 2 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }

                    vivo = !(tamagotchi.dormir(opcao)); // atualiza variável vivo se ele morrer
                    status(tamagotchi); // status do tamagotchi
                    break;

                case 3: // Rand == 3 / Tédio

                    opcao = Teclado.leInt(tamagotchi.tedio()); // pega informacao do usuário
                    while (opcao > 2 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }

                    vivo = !(tamagotchi.exercitar(opcao)); // atualiza variável vivo se ele morrer
                    status(tamagotchi); // status do tamagotchi
                    break;
            }
        }
    }

    static void status(Tamagotchi t) {
        System.out.println(t.toString());
    }
}