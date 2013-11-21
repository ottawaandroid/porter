package ca.ottawaandroid.dooropener;

import android.app.Fragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_knock, container, false);

        knockButton = (Button) rootView.findViewById(R.id.btn_knock);
        knockButton.setOnClickListener(this);

        knockMediaPlayer = MediaPlayer.create(getActivity(), R.raw.knock);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        knockMediaPlayer.start();
    }
}