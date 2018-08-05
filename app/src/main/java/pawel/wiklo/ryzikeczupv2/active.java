package pawel.wiklo.ryzikeczupv2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class active extends Fragment {
    public static active newInstance() {
        active fragment = new active();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("TAG","onCreate active");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("TAG","Start onCreateView active");
        //DbHelper db = new DbHelper(this);
        DbHelper db = new DbHelper(getActivity());
        String firstValue = "first Value";
        String secondValue = "secondValue";
        //db.deleteAll();
        db.add(firstValue,secondValue);
        db.add("11","22");
        Log.e("TAG","End onCreateView");
        return inflater.inflate(R.layout.fragment_active, container, false);
    }
}