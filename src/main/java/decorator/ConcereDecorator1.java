package decorator;

public class ConcereDecorator1 extends Decorator{

    public static void main(String[] args) {
        ConcereDecorator1 decorator1 = new ConcereDecorator1(new ConcereCompent());
        decorator1.operation();
    }

    public ConcereDecorator1(Compent compent) {
        super(compent);
    }

    @Override
    public void operation() {
        System.out.println("美颜");
        compent.operation();
    }
}
