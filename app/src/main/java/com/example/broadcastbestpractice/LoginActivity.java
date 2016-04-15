package com.example.broadcastbestpractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
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
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginButton;
    private Button cancelButton;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);  //加载布局文件
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 获取输入，密码框，登录，取消按钮实例
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.login);
        cancelButton = (Button) findViewById(R.id.cancel);

        loginButton.setOnClickListener(v->{
            String account = accountEdit.getText().toString();
            String password = passwordEdit.getText().toString();
            if(account.equals("admin") && password.equals("123456")){
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
