package rpg.Personagem;

public class Personagem {
    private String name;
    private int life;
    private int damage;
    private Arma arma;

    public Personagem(String name, int life, int damage, Arma arma) {
        this.name = name;
        this.life = life;
        this.damage = damage;
        this.arma = arma;
    }

    public void SetArma(Arma arma) {
        this.arma = arma;
    }

    public Arma GetArma() {
        return arma;
    }

    public void attack() {
        System.out.println(name + " ataca com " + damage + " de dano!");
    }

    public void damageReceived(){
        life -= damage;
        System.out.println(name + " recebeu " + damage + " de dano. Vida restante: " + life);
    }

    public void status() {
        System.out.println("Nome: "
                + name
                + " | Vida: "
                + life
                + " | Ataque: "
                + damage);
    }

    public String toString() {
        return "Nome: "
                + name
                + " | Vida: "
                + life
                + " | Ataque: "
                + damage;
    }




}
