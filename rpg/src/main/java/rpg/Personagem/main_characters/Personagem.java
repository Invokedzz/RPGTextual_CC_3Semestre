package rpg.Personagem.main_characters;

public class Personagem {

    private String name;

    private Integer life;

    private Weapon weapon;

    public Personagem (String name, Integer life, Weapon weapon) {

        this.name = name;
        this.life = life;
        this.weapon = weapon;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLife() {
        return life;
    }

    public void setLife(Integer life) {
        this.life = life;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
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

    public String changeEnumNames (String name) {

        name = name.replace("_", " ");

        return name;

    }

    public String toString() {

        return "Personagem escolhido: \n"
                + "Nome: "
                + name
                + " | Vida: "
                + life
                + " | Arma: "
                + changeEnumNames(weapon.getWeaponType().name());
    }

}
