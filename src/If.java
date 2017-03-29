import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksey.Popov on 17.03.2017.
 */
public class If extends Operator {
    public If(String code) {
        super(code);
    }

    @Override
    //40 IF //x < 3 THEN GOTO 40
    public void exec(Interpreter inte) {
        Pattern pattern = Pattern.compile("(.*) THEN GOTO (.*)");
        Matcher matcher = pattern.matcher(code);
        inte.next();
        if(!matcher.find()) {
            System.err.println("Wrong IF pattern, use template IF ... THEN GOTO ...");
        } else {
            String cond = matcher.group(1);
            int nextLine = Integer.parseInt(matcher.group(2));
            Object val = null;
            try {
                val = Expression.eval(inte.getVars(), cond);
                if(Boolean.valueOf(val.toString())) {
                    inte.goTo(nextLine);
                }
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
}
