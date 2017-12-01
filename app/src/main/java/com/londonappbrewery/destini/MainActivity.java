package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStory;
    Button mTopButton;
    Button mBottomButton;

    int mStoryTracker = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStory = (TextView)findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button)findViewById(R.id.buttonBottom);

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Destini", "Top button clicked ");
                boolean mTop = true;
                updateStory(mTop);
            }

        });

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Destini", "Bottom button clicked ");
                boolean mBottom = false;
                updateStory(mBottom);
            }
        });

    }

    private void updateStory(boolean topOrBottom){



        if (topOrBottom && mStoryTracker == 2 ){
            mStory.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
            mStoryTracker = 3;
        } else if (topOrBottom && mStoryTracker == 3){
            mStory.setText(R.string.T6_End);
            endAlert();
            mTopButton.setText("Good bye");
            mBottomButton.setText("Story over");
        } else if (!topOrBottom && mStoryTracker == 3){
            mStory.setText(R.string.T5_End);
            endAlert();
            mTopButton.setText("Good bye");
            mBottomButton.setText("Story over");
        } else if (!topOrBottom && mStoryTracker == 2){
            mStory.setText(R.string.T4_End);
            endAlert();
            mTopButton.setText("Good bye");
            mBottomButton.setText("Story over");
        } else if (topOrBottom ){
            mStory.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
            mStoryTracker = 3;
        } else if(!topOrBottom) {
            mStory.setText(R.string.T2_Story);
            mTopButton.setText(R.string.T2_Ans1);
            mBottomButton.setText(R.string.T2_Ans2);
            mStoryTracker = 2;
        }

    }

    private void endAlert(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Game over");
        alert.setCancelable(false);
        alert.setMessage("So long and thanks for all the fish  !!!!!");
        alert.setPositiveButton("Restart Adventure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        alert.show();
    }
}
