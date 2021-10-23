package com.fdeazagra.cines_aragon.utils;

import android.util.Log;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class Post {
    private InputStream is = null;
    private String respuesta = "";

    private String getEncodedData(Map<String,String> data) {

        StringBuilder sb = new StringBuilder();
        for(String key : data.keySet()) {
            String value = null;
            try {
                value = URLEncoder.encode(data.get(key), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            if(sb.length()>0)
                sb.append("&");

            sb.append(key + "=" + value);
        }
        return sb.toString();
    }
    private HttpURLConnection con = null;
    private OutputStreamWriter writer = null;
            private void conectaPost(Map<String,String> dataToSend, String pagina) {
                try {

                    String encodedStr = getEncodedData(dataToSend);

                    URL url = new URL(pagina);

                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("POST");
                    con.setDoOutput(true);

                    writer = new OutputStreamWriter(con.getOutputStream());
                    writer.write(encodedStr);
                    writer.flush();


                    is = con.getInputStream();

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection " + e.toString());
                } finally {

                }

            }

            private void conectaGet(String pagina) {
                HttpURLConnection con = null;
                try {

                    URL url = new URL(pagina);

                    con = (HttpURLConnection) url.openConnection();

                    is = con.getInputStream();

                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection " + e.toString());
                } finally {
                    try {
                        if(con!=null)
                        {
                            con.disconnect();
                        }
                    } catch (Exception e) {
                        Log.e("log_tag", "Error in http connection " + e.toString());
                    }
                }

            }

            private JSONArray getRespuestaPostEnJson() {
                JSONArray jArray = null;
                try {
                    if(is!=null){
                        BufferedReader reader = new BufferedReader
                                (new InputStreamReader(is, "iso-8859-1"));
                        StringBuilder sb = new StringBuilder();
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                        }
                        is.close();
                        respuesta = sb.toString();
                        jArray = new JSONArray(respuesta);
                    }
                    Log.e("log_tag", "Cadena JSon " + respuesta);
                } catch (Exception e) {
                    Log.e("log_tag", "Error converting result " + e.toString());
                }finally {
                    try {
                        if(writer!=null) {
                            writer.close();
                        }
                        if(con!=null)
                        {
                            con.disconnect();
                        }
                    } catch (Exception e) {
                        Log.e("log_tag", "Error in http connection " + e.toString());
                    }
                    return jArray;
                }
            }

    public JSONArray getServerDataPost(Map<String,String> dataToSend, String URL) {
        conectaPost(dataToSend, URL);
        return     getRespuestaPostEnJson();

    }
    public JSONArray getServerDataGet(String URL) {
        conectaGet(URL);
        return     getRespuestaPostEnJson();

    }
}

