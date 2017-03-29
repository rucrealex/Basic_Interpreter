import javax.script.ScriptException;

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class Let extends Operator {

    public Let(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        String[] parts = this.code.split("=");
        try {
            Object val = Expression.eval(inte.getVars(), parts[1]);
            inte.getVars().put(parts[0].trim(), Double.valueOf(val.toString()));
            inte.next();
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}
