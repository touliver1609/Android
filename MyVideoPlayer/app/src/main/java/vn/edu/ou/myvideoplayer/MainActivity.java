package vn.edu.ou.myvideoplayer;

import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    MediaController mediaController;
    ToggleButton btn;
    LinearLayout mainLayout;
    TextView txt;
    int count = 0, color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        videoView = (VideoView) findViewById(R.id.MyVideoView);
        btn = (ToggleButton) findViewById(R.id.btn);
        mainLayout = (LinearLayout) findViewById(R.id.main_layout);
        txt = (TextView) findViewById(R.id.txt);


        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.tomjerry;
        videoView.setVideoURI(Uri.parse(videoPath));

        mediaController = new android.widget.MediaController(this);
        mediaController.setAnchorView(videoView);

        videoView.setMediaController(mediaController);
        videoView.start();

        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked)
                    color = R.color.colorDark;
                else
                    color = R.color.colorWhite;
                mainLayout.setBackgroundResource(color);
            }
        });
        SharedPreferences sharedPreferences = getSharedPreferences("AppLaunchCount", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        int countDefault = 0;

        if(sharedPreferences == null || (sharedPreferences != null && !sharedPreferences.contains("Count")))
            editor.putInt("Count", count);
        else if(sharedPreferences != null && sharedPreferences.contains("Count"))
            count = sharedPreferences.getInt("Count", countDefault);
        count++;
        txt.setText(getString(R.string.app_launch_count) + count);
        editor.putInt("Count", count);
        editor.commit();
    }


    @Override
    protected void onStop() {
        super.onStop();
        videoView.stopPlayback();
    }
}
