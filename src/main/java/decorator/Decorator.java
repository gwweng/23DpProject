package decorator;

public abstract class Decorator implements Compent{
    public Compent compent;

    public Decorator(Compent compent) {
        this.compent = compent;
    }
}
