import javax.script.*;
public class CalculateUsingJavascript{
	public static int evaluate(String s) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		int res = 0;
		try {
		res = (int) engine.eval(s);
		
		} catch(Exception e) {}
		return res;
	
	}//eom


}//eoc
