import javax.script.ScriptException;

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class Print extends Operator {

    public Print(String code) {
        super(code);
    }

    @Override
    public void exec(Interpreter inte) {
        Object result = null;
        try {
            result = Expression.eval(inte.getVars(), code);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        inte.next();
    }
}
