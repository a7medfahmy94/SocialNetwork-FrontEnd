package com.FCI.SWE.SocialNetwork;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Esraa on 4/29/2015.
 */
public class CreatePageActivity extends Activity {
    Button likePage;
    EditText pageName;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_likepage);
        pageName =(EditText) findViewById(R.id.PageNamee);
        likePage = (Button) findViewById(R.id.LikePage_btn);
        createPage.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new likePageService().execute(pageName.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
