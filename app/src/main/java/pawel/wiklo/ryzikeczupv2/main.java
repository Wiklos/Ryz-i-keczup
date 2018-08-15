package pawel.wiklo.ryzikeczupv2;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class main extends Fragment {
    public static main newInstance() {
        main fragment = new main();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("TAG","onCreate main");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG","Start onCreateView main");
        //        DbHelper db = new DbHelper(this);
        DbHelper db = new DbHelper(getActivity());

        Cursor k = db.getAll();

//        View view = inflater.inflate(R.layout.fragment_main, container, false);
//        TextView tv = (TextView)view.findViewById(R.id.textView);

        View returnView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView tv = (TextView) returnView.findViewById(R.id.textView);
        //tv.setText("hello");

        tv.setText("AAAAAAAAAAAAAAAAAAA");
        while(k.moveToNext())
        {
            tv.setText(tv.getText()+ "\n"+ k.getString(1) +" "+ k.getString(2) );
            //tv.setText(k.getString(2) );
            Log.e("TAG","Inside while k.moveToNext main");
        }
        Log.e("TAG","End onCreateView main");
//        return inflater.inflate(R.layout.fragment_main, container, false);
        return returnView;
    }
}