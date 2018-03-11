package sokoban;

public abstract class Entity {

    private Cell place;
    private Entity owner;
    private Warehouse warehouse;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public Cell getPlace() {
        return place;
    }

    public void setPlace(Cell place) {
        this.place = place;
    }

    public Entity() {
        place = new Cell();
    }

    Entity(Cell p)
    {
        place = p;
    }

    public abstract void addScore(int amount);

    public abstract boolean move(Directions dir, Entity mOwner);





    public abstract void stepOnGoal(Entity mOwner);

    public abstract void stepOnHole(Entity mOwner);

    public abstract void die();

    public abstract void stepOnSwitch(SwitchableHole aSwitch);
}
