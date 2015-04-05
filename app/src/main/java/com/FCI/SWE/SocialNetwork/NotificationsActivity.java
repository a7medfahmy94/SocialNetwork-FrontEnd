package com.FCI.SWE.SocialNetwork;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

/**
 * Created by root on 4/5/15.
 */
public class NotificationsActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // storing string resources into Array
        String[] adobe_products = new String[]{
                "Fahmy" , "Hala"
        };

        // Binding resources Array to ListAdapter
        this.setListAdapter(
                new ArrayAdapter<String>(this, R.layout.list_item, R.id.label, adobe_products));

    }

}
