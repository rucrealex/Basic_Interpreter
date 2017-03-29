

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
abstract public class Operator {
    String code;

    public Operator(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.getClass().getName().toUpperCase()+" "+code;
    }

    abstract public void exec(Interpreter inte);

}
