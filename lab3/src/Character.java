public abstract class Character {
    private Status status;
    private boolean havingKnife;

    public Character(Status status) {
        this.status = status;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public boolean getHavingKnife(){
        return this.havingKnife;
    }
    public void setHavingKnife(boolean havingKnife){
        this.havingKnife = havingKnife;
    }

    public abstract void takeKnife(Knife knife);
    public abstract int takeCoin(MoneyBox pig);

}
