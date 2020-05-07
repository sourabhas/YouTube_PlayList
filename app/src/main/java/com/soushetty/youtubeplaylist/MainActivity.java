package com.soushetty.youtubeplaylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends YouTubeBaseActivity {

    YouTubePlayerView youTubePlayerView;
    public Button playbutton;
    YouTubePlayer.OnInitializedListener onInitializedListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Test","Starting");

        playbutton=findViewById(R.id.play_button);
        youTubePlayerView=findViewById(R.id.player_view);


        //overriding OnIntialized listner class
        onInitializedListener=new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Log.d("Test","sucess initializing");

                //creating a List of videos to pass
                List<String> listofvideos=new ArrayList<>();
                //paste the last characters of the url of the video's you want to add to the playlist(after = sign)
                listofvideos.add("SD4Z8dlZPd8");
                listofvideos.add("x6Q7c9RyMzk");
                listofvideos.add("C3jlOlzSL8I");
                listofvideos.add("TjkPEBV0Vh4");
                //calling the load videos method through the youtube player variable passed to this overridden method
                youTubePlayer.loadVideos(listofvideos);

                /*other ways would be to add each video separately
                youTubePlayer.loadVideo("");*/

                /* to add an already created playlist in YouTube, copy the link and paste here as below
                 youTubePlayer.loadPlaylist("paste the url after copy everything after "=");
                 */



            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d("Test","Failed initializing");
            }
        };

        //on clicking the play button
        playbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize(YouTubeConfig.getApi_key(),onInitializedListener);
            }
        });

    }
}
