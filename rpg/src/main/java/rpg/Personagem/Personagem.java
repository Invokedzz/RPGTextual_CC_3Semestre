package rpg.Personagem;

public class Personagem {

    private String name;

    private Integer life;

    private Weapon weapon;

    public Personagem (String name, Integer life, Weapon weapon) {

        this.name = name;
        this.life = life;
        this.weapon = weapon;

    }


    public void attack() {

        System.out.println(name + " ataca com " + weapon.getDamage() + " de dano!");

    }

    public void damageReceived(Integer damage){

        life -= damage;
        System.out.println(name + " recebeu " + damage + " de dano. Vida restante: " + life);

    }

    public void status() {

        System.out.println("Nome: "
                + name
                + " | Vida: "
                + life
                + " | Ataque: "
                + weapon.getDamage());

    }

    @Override
    public String toString() {

        return "Personagem{" +
                "name='" + name + '\'' +
                ", life=" + life +
                ", weapon=" + weapon +
                '}';
    }

}
