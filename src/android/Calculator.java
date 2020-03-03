package cordova-plugin-calculator;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class Calculator extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        return false;
    }

    private void add(JSONArray args, CallbackContext callbackContext) {
        if(args != null) {
            try {
                int param1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int param2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));

                callbackContext.success("Sum of two numbers: " + (param1+param2));
            } catch (Exception e) {
                callbackContext.error("JSON exception happened: "+e);
            }
        } else {
            callbackContext.error("Arguments cannot be null");
        }
    }
}
