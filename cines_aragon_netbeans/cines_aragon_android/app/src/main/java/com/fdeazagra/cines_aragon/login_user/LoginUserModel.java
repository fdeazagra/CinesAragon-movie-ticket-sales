package com.fdeazagra.cines_aragon.login_user;

import android.os.AsyncTask;
import android.util.Log;

import com.fdeazagra.cines_aragon.model.Cine;
import com.fdeazagra.cines_aragon.model.Constantes;
import com.fdeazagra.cines_aragon.model.User;
import com.fdeazagra.cines_aragon.utils.Post;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginUserModel implements LoginUserContract.Model {
    private ArrayList<User> lstUsers;
    private OnLoginUserListener onLoginUserListener;
    @Override
    public void getUserService(final OnLoginUserListener onLoginUserListener,
                               User usuario) {

        this.onLoginUserListener = onLoginUserListener;
        HashMap<String,String> param = new HashMap<>();
        param.put("ACTION", "USUARIO.LOGIN");
        param.put("EMAIL", usuario.getEmail());
        param.put("PASSWORD", usuario.getPassword());

        TareaSegundoPlano miTarea = new TareaSegundoPlano(param);
        //Cambiar URL según IP
        miTarea.execute(Constantes.USER_LOGIN);


    }

    /*Clase ASYNKTASK*/
// HILO ASYNCTASK
class TareaSegundoPlano extends AsyncTask<String, Integer, Boolean> {
    private HashMap<String, String> parametros = null;

    public TareaSegundoPlano( HashMap<String, String> parametros) {
        super();
        this.parametros = parametros;
    }

    @Override
    protected Boolean  doInBackground(String... params) {
        String url_select = params[0];
        try {
            Post post = new Post();
            JSONArray result = post.getServerDataPost(parametros,url_select);
            lstUsers = User.getArrayListFromJSon(result);
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }
        return true;
    }

    @Override
    protected void onPostExecute(Boolean resp) {
        try {
            if(resp){
                onLoginUserListener.onFinished(lstUsers.get(0));
            }
        }catch (Exception e) {
                onLoginUserListener.onFailure("Fallo:Login User");
        }
    }
}

}
