package rpg.Personagem;

public class Personagem {
    private String name;
    private int life;
    private int damage;

    public Personagem(String name, int life, int damage) {
        this.name = name;
        this.life = life;
        this.damage = damage;
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
