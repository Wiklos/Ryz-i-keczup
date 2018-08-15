package pawel.wiklo.ryzikeczupv2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class active extends Fragment {

    private CountDownTimer countDownTimer;
    //private long timeLeftInMilliseconds = 60000; //600000 //10min
    public static long timeLeftInMilliseconds = 60000;
    private static boolean timerRunning;

    TextView tv;

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
        //db.add(firstValue,secondValue);
        //db.add("11","22");
        Log.e("TAG","End onCreateView");

        //timer


        View returnView = inflater.inflate(R.layout.fragment_main, container, false);
        tv = (TextView) returnView.findViewById(R.id.textView);
        //tv.setText("hello");
        tv.setText("BBBBBBBBBBBBBB");
//        if(!timerRunning){
//            startTimer();
//        }
//        else
//        {
//            updateTimer();
//        }
        startTimer();

        //timer

        //return inflater.inflate(R.layout.fragment_active, container, false);
        return returnView;
    }
    @Override
    public void onStart() {

        super.onStart();
        getActivity().setTitle("Lista Usuarios Check In");
        //startTimer();
        Log.d("START","On start log");
    }
    private void startTimer() {
        Log.d("TIMER","Start timer");
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
                Log.d("TIMER","On tick imer");
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                timeLeftInMilliseconds = 60000;
                startTimer();

            }
        }.start();

        timerRunning = true;
    }
    public void updateTimer()
    {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;

        String timeLeft;
        timeLeft = "" + minutes;
        timeLeft += ":";
        if(seconds < 10) timeLeft += "0";
        timeLeft += seconds;

        tv.setText(timeLeft);
        Log.d("TIMER",timeLeft);
    }

}