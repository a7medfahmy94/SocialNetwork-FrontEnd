package com.FCI.SWE.SocialNetwork;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Esraa on 4/29/2015.
 */
public class CreatePageActivity extends Activity {
    Button pagePost;
    EditText pageName;
    EditText post;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page);
        pageName =(EditText) findViewById(R.id.Page__Name);
        post =(EditText) findViewById(R.id.pagePost);
        pagePost = (Button) findViewById(R.id.writePostPage_btn);
        pagePost.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new PagePostService().execute(pageName.getText().toString(),
                post.getText().toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
