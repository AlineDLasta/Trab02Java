package jogo.combate;

import java.util.Scanner;

//Classe que representa um campeão em combate
class Campeao {
    private String nome;
    private int vida;
    private int ataque;
    private int armadura;

    public Campeao(String nome, int vida, int ataque, int armadura) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.armadura = armadura;
    }

    public void takeDamage(int danoRecebido) {
        int danoEfetivo = Math.max(1, danoRecebido - this.armadura);
        this.vida = Math.max(0, this.vida - danoEfetivo);
    }

    // Método para retornar o status de vida do campeão
    public String status() {
        if (this.vida == 0) {
            return this.nome + ": 0 de vida (morreu)";
        } else {
            return this.nome + ": " + this.vida + " de vida";
        }
    }

    // Métodos de acesso para obter o nome, vida e ataque do campeão
    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
}

//Classe principal que controla o combate entre dois campeões
public class Combate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("********* Vamos começar! *********");
        System.out.println("Digite os dados do primeiro campeão:");
        // Coleta os dados do primeiro campeão
        System.out.print("Nome: ");
        String nome1 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida1 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque1 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura1 = scanner.nextInt();
        scanner.nextLine();

        Campeao campeao1 = new Campeao(nome1, vida1, ataque1, armadura1);

        System.out.println("Digite os dados do segundo campeão:");
        // Coleta os dados do segundo campeão
        System.out.print("Nome: ");
        String nome2 = scanner.nextLine();
        System.out.print("Vida inicial: ");
        int vida2 = scanner.nextInt();
        System.out.print("Ataque: ");
        int ataque2 = scanner.nextInt();
        System.out.print("Armadura: ");
        int armadura2 = scanner.nextInt();

        Campeao campeao2 = new Campeao(nome2, vida2, ataque2, armadura2);

        System.out.print("Quantos turnos você deseja executar? ");
        int turnos = scanner.nextInt();

        // Loop de combate que executa o número de turnos informados
        for (int turno = 1; turno <= turnos; turno++) {
            if (campeao1.getVida() == 0 || campeao2.getVida() == 0) {
                break;
            }

            campeao1.takeDamage(campeao2.getAtaque());
            campeao2.takeDamage(campeao1.getAtaque());

            System.out.println("Resultado do turno " + turno + ":");
            System.out.println(campeao1.status());
            System.out.println(campeao2.status());
            System.out.println();

            if (campeao1.getVida() == 0 || campeao2.getVida() == 0) {
                break;
            }
        }

        System.out.println("*** FIM DO COMBATE ***");
        scanner.close();
    }
}
