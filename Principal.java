public class Principal {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi(Teclado.leString("Digite o nome do seu Tamagotchi:"));
        System.out.println(tamagotchi.toString()); // status do tamagotchi
        boolean vivo = true;
        int range = 3; // 3 opcoes de sentimento para o random

        while (vivo) {
            int rand = (int) (Math.random() * range) + 1; // + 1 pra não incluir o 0
            int opcao;
            switch (rand) {
                // Fome
                case 1:
                    opcao = Teclado.leInt(tamagotchi.fome()); // pega informacao do usuário
                    while (opcao > 3 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }
                    tamagotchi.comer(opcao);
                    vivo = !(tamagotchi.isMorto()); // se retornar true é porque ele morreu
                    break;
                // Sono
                case 2:
                    opcao = Teclado.leInt(tamagotchi.sono()); // pega informacao do usuario
                    while (opcao > 2 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }
                    tamagotchi.dormir(opcao);
                    vivo = !(tamagotchi.isMorto()); // atualiza variável vivo se ele morrer
                    break;
                // Tédio
                case 3:
                    opcao = Teclado.leInt(tamagotchi.tedio()); // pega informacao do usuário
                    while (opcao > 2 || opcao < 1) {
                        opcao = Teclado.leInt("Valor inválido, tente novamente:");
                    }
                    tamagotchi.exercitar(opcao);
                    vivo = !(tamagotchi.isMorto()); // atualiza variável vivo se ele morrer
                    break;
            }
        }
    }
}