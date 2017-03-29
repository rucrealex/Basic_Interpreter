/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class Goto extends Operator {
    public Goto(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        inte.goTo(Integer.parseInt(this.code));
    }
}
