package com.seals.shubham.connect_vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText user,pass;
    Button log,reg;
    RequestQueue mQueue;
    private String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mQueue = Volley.newRequestQueue(LoginActivity.this);

        user = (EditText)findViewById(R.id.editText);
        pass = (EditText)findViewById(R.id.editText2);
        log = (Button)findViewById(R.id.button);
        reg = (Button)findViewById(R.id.button3);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = user.getText().toString();
                final String password = pass.getText().toString();

                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int ans = 0;
                        for(int i=0;i<response.length();i++){
                            try{
                                JSONObject jsonObject = response.getJSONObject(i);
                                String user_n = jsonObject.getString("Username");
                                String pass_w = jsonObject.getString("Password");
                                if(username.equals(user_n) && password.equals(pass_w)){
                                    ans = 1;
                                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                                    startActivity(intent);
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                        if(ans == 0){
                            Toast.makeText(LoginActivity.this,"Invalid User",Toast.LENGTH_LONG).show();
                            user.setText(null);
                            pass.setText(null);
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoginActivity.this,"Error is "+error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
