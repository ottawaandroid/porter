package ca.ottawaandroid.dooropener;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by carson on 2013-11-20.
 */
public class KnockFragment extends Fragment implements Button.OnClickListener {

    public static KnockFragment newInstance() {
        KnockFragment fragment = new KnockFragment();
        return fragment;
    }

    Button knockButton;
    MediaPlayer knockMediaPlayer;

    View actionView;
    View loadingView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_knock, container, false);

        actionView = rootView.findViewById(R.id.knock_action_layout);
        loadingView = rootView.findViewById(R.id.knock_loading_layout);
        loadingView.setAlpha(0.0f);

        knockButton = (Button) rootView.findViewById(R.id.btn_knock);
        knockButton.setOnClickListener(this);

        knockMediaPlayer = MediaPlayer.create(getActivity(), R.raw.knock);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        knockButton.setEnabled(false);
        knockMediaPlayer.start();

        actionView.animate().alpha(0.0f);
        loadingView.animate().alpha(1.0f);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        actionView.animate().alpha(1.0f);
                        loadingView.animate().alpha(0.0f);
                        knockButton.setEnabled(true);
                    }
                });
            }
        }, 2000);

    }
}