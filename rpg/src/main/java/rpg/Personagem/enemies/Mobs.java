package rpg.Personagem.enemies;

import rpg.Personagem.main_characters.Personagem;

public class Mobs extends Personagem {

    private Integer damage;

    private Skill skill;

    public Mobs (String name, Integer lifePoints, Integer damage, Skill skill) {

        super(name, lifePoints);

        this.damage = damage;

        this.skill = skill;

    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

}
