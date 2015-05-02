package com.FCI.SWE.SocialNetwork;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Esraa on 4/29/2015.
 */
public class CreatePageActivity extends Activity {
    Button createPage;
    EditText pageName;
    EditText pageCategory;
    EditText pageType;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_page);

        pageName =(EditText) findViewById(R.id.pagename);
        pageCategory =(EditText) findViewById(R.id.pagecategory);
        pageType =(EditText) findViewById(R.id.pagetype);
        createPage = (Button) findViewById(R.id.createpage_btn);
        createPage.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        new createPageService().execute(pageName.getText().toString(),
                pageCategory.getText().toString(),pageType.getText.toString());
        Intent returnIntent = new Intent();
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}
