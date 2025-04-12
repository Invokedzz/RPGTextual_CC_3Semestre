package rpg.Personagem.enemies;

public class Mobs {

    private Integer lifePoints;

    private Integer damage;

    private Skill skill;

    public Mobs (Integer lifePoints, Integer damage, Skill skill) {

        this.lifePoints = lifePoints;

        this.damage = damage;

        this.skill = skill;

    }

    public Integer getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(Integer lifePoints) {
        this.lifePoints = lifePoints;
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
