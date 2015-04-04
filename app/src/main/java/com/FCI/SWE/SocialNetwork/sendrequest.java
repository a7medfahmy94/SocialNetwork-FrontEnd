package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.FCI.SWE.Controllers.Application1;
import com.FCI.SWE.Controllers.Controllsendrequest;
import com.FCI.SWE.Controllers.Controllsendrequest;
import com.FCI.SWE.Controllers.UserController;

public class sendrequest extends Activity  {

    Button btnSendRequest;
    EditText eText;
    EditText text;
    private String email = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sendrequest);

        btnSendRequest = (Button) findViewById(R.id.btnSendRequest);
        eText = (EditText) findViewById(R.id.edittext);
        eText.setVisibility(View.INVISIBLE);
        btnSendRequest.setOnClickListener(
                new Button.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Controllsendrequest con;
                        Button button = (Button) view;
                        eText.setVisibility(View.VISIBLE);
                        //text = (EditText)findViewById(R.id.thatEditText);
                       // EditText et=(EditText)findViewById(R.id.thatEditText);
                        //email =
                        ((Button) view).setText("enter user's email");
                        String str = eText.getText().toString();
                        Toast msg = Toast.makeText(getBaseContext(),str,
                                Toast.LENGTH_LONG);
                        msg.show();
                        msg.show();
                        button.setOnClickListener(
                            con = Application1.getUserController();
                            con.sendFriendRequest(eText.getText().toString());

                        );
                    }

                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sendrequest, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
