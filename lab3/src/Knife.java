public class Knife {
    private Owner owner;
    private int id;

    public Knife(int id) {
        this.id = id;
        owner = Owner.NOBODY;
    }
    public Knife(int id, Owner owner) {
        this.id = id;
        this.owner = owner;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Owner isOwner() {
        return owner;
    }
    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Owner getOwner() {
        return owner;
    }

    public String toString(){
        return getClass().getName() + " " + this.getOwner();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Knife knife = (Knife) obj;
        return this.getId() == knife.getId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        result = prime * result + (this.getOwner() != null ? getOwner().hashCode():0);
        return result;
    }
}
