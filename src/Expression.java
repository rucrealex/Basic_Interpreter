import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class Expression {

    public static Object eval(Map<String, Double> vars, String code) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        for(String var : vars.keySet()) {
            engine.put(var, vars.get(var));
        }
        return engine.eval(code);
    }
}

