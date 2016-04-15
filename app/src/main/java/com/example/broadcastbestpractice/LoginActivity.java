package com.example.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.example.broadcastbestpractice.LoginActivity.java
 * @author: yyxyz
 * @date: 2016-04-15 14:21
 */
public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button cancelButton;
    private CheckBox rememberPass;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);  //加载布局文件

        // 获取输入，密码框，登录，取消按钮实例
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        cancelButton = (Button) findViewById(R.id.cancel);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);

        pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if(isRemember){
            String account = pref.getString("account", "");
            String password = pref.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }

        loginButton.setOnClickListener(v->{
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if(account.equals("admin") && password.equals("123456")){
                editor = pref.edit();
                if(rememberPass.isChecked()){ //检查复选框是否被选中
                    editor.putBoolean("remember_password", true);
                    editor.putString("account", account);
                    editor.putString("password", password);
                }else{
                    editor.clear();
                }
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
            }
        });
        cancelButton.setOnClickListener(v->{
            accountEdit.setText("");
            passwordEdit.setText("");
        });
    }
}
