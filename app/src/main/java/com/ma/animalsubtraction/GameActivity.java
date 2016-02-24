package com.ma.animalsubtraction;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.maza.animalsubtraction.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    TextView pointsCounter, correctView;
    Button enterButton, closeButton, playButton;
    TextView mathText, mathText2, helpText;
    ImageView mSymbolImageView;
    EditText enterAnsText;
    int points = 0;
    String level;
    int a, b, answer;
    Random rand = new Random();
    MediaPlayer mp, mp1, mp2, mp3;
    LinearLayout mainLinearLayout;
    RelativeLayout helpScreen;
    ImageView animal1, animal2, animal3, animal4, starsView1, starsView2, starsView3, starsView4,
            starsView5, qImageView;

    public int makeNewProblem() {

        if (points <= 50) {
            level = "One";
            a = rand.nextInt(6);
            b = rand.nextInt(4);
            while (b > a) {
                b = rand.nextInt(4);
            }
        } else if ((points >= 51) && (points <= 100)) {
            level = "Two";
            a = rand.nextInt(11);
            b = rand.nextInt(10);
            while (b > a) {
                b = rand.nextInt(10);
            }
        } else if ((points >= 101) && (points <= 150)) {
            level = "Three";
            a = rand.nextInt(16);
            b = rand.nextInt(16);
            while (b > a) {
                b = rand.nextInt(16);
            }
        } else if ((points >= 151) && (points <= 200)) {
            level = "Four";
            a = rand.nextInt(26);
            b = rand.nextInt(21);
            while (b > a) {
                b = rand.nextInt(21);
            }
        }

        mathText.setText(Integer.toString(a));
        mathText2.setText(Integer.toString(b));

        answer = a - b;
        return answer;

    }

    // main game mechanism

    public void answerQ (View view) {

        if (enterAnsText.getText().toString().length() > 0) {

            if (answer == (Integer.valueOf(enterAnsText.getText().toString()))) {
                points++;
                pointsCounter.setText(Integer.toString(points));
                mp2.start();
                correctView.setText("CORRECT!");

            } else {
                correctView.setText("OOPS!");
                mp1.start();
            }


            enterAnsText.setText("");

            if ((points > 0) && (points < 201)) {
                switch (points) {
                    case 10:
                        starsView1.setImageResource(R.drawable.zebra);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 20:
                        starsView2.setImageResource(R.drawable.zebra);
                        correctView.setText("Keep it up!");
                        mp.start();
                        break;
                    case 30:
                        starsView3.setImageResource(R.drawable.zebra);
                        correctView.setText("Awesome!");
                        break;
                    case 40:
                        starsView4.setImageResource(R.drawable.zebra);
                        correctView.setText("On a roll!");
                        mp.start();
                        break;
                    case 50:
                        starsView5.setImageResource(R.drawable.zebra);
                        animal1.setImageResource(R.drawable.zebra);
                        correctView.setText("Level Two!");
                        mp.start();
                        break;
                    case 60:
                        starsView1.setImageResource(R.drawable.monkey);
                        correctView.setText("Awesome!");
                        mp.start();
                        break;
                    case 70:
                        starsView2.setImageResource(R.drawable.monkey);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 80:
                        starsView3.setImageResource(R.drawable.monkey);
                        correctView.setText("Keep Going!");
                        mp.start();
                        break;
                    case 90:
                        starsView4.setImageResource(R.drawable.monkey);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 100:
                        starsView5.setImageResource(R.drawable.monkey);
                        animal2.setImageResource(R.drawable.monkey);
                        correctView.setText("Level Three!");
                        mp.start();
                        break;
                    case 110:
                        starsView1.setImageResource(R.drawable.giraffe);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 120:
                        starsView2.setImageResource(R.drawable.giraffe);
                        correctView.setText("Keep it up!");
                        mp.start();
                        break;
                    case 130:
                        starsView3.setImageResource(R.drawable.giraffe);
                        correctView.setText("Awesome!");
                        break;
                    case 140:
                        starsView4.setImageResource(R.drawable.giraffe);
                        correctView.setText("On a roll!");
                        mp.start();
                        break;
                    case 150:
                        starsView5.setImageResource(R.drawable.giraffe);
                        animal3.setImageResource(R.drawable.giraffe);
                        correctView.setText("Level Four!");
                        mp.start();
                        break;
                    case 160:
                        starsView1.setImageResource(R.drawable.elephant);
                        correctView.setText("Awesome!");
                        mp.start();
                        break;
                    case 170:
                        starsView2.setImageResource(R.drawable.elephant);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 180:
                        starsView3.setImageResource(R.drawable.elephant);
                        correctView.setText("Keep Going!");
                        mp.start();
                        break;
                    case 190:
                        starsView4.setImageResource(R.drawable.elephant);
                        correctView.setText("Great job!");
                        mp.start();
                        break;
                    case 200:
                        starsView5.setImageResource(R.drawable.elephant);
                        animal4.setImageResource(R.drawable.elephant);
                        correctView.setText("200! You won!");
                        helpScreen.setVisibility(View.VISIBLE);
                        helpText.setVisibility(View.INVISIBLE);
                        closeButton.setVisibility(View.INVISIBLE);
                        playButton.setVisibility(View.VISIBLE);
                        playButton.setText("You won! Play again?");
                        mp3.start();

                        break;
                    default:
                        break;
                }
            }
        }else {
            Toast.makeText(GameActivity.this, "You didn't enter an answer! Try again!", Toast
                    .LENGTH_SHORT).show();
        }
        makeNewProblem();
    }


    public void displayHelp(View view) {
        helpScreen.setVisibility(View.VISIBLE);
        closeButton.setVisibility(View.VISIBLE);
        playButton.setVisibility(View.INVISIBLE);
    }

    public void closeHelp(View view) {

        helpScreen.setVisibility(View.INVISIBLE);
    }

    public void startGame(View view) {
        mainLinearLayout.setVisibility(View.VISIBLE);
        helpScreen.setVisibility(View.INVISIBLE);
        pointsCounter.setText("0");
        correctView.setText("Good Luck!");
        makeNewProblem();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //set up screens & buttons

        mainLinearLayout = (LinearLayout) findViewById(R.id.mainLinearLayout);
        pointsCounter = (TextView) findViewById(R.id.pointsCounter);
        correctView = (TextView) findViewById(R.id.correctView);
        mathText = (TextView) findViewById(R.id.mathText);
        mathText2 = (TextView) findViewById(R.id.mathText2);
        enterAnsText = (EditText) findViewById(R.id.enterAnsText);
        helpText = (TextView) findViewById(R.id.helpText);
        helpScreen = (RelativeLayout) findViewById(R.id.helpScreen);
        closeButton = (Button) findViewById(R.id.closeButton);
        playButton = (Button) findViewById(R.id.playButton);


        //set up imageViews
        mSymbolImageView = (ImageView) findViewById(R.id.mSymbolImageView);
        mSymbolImageView.setImageResource(R.drawable.minusymbol);
        qImageView = (ImageView) findViewById(R.id.qImageView);
        animal1 = (ImageView) findViewById(R.id.animal1);
        animal2 = (ImageView) findViewById(R.id.animal2);
        animal3 = (ImageView) findViewById(R.id.animal3);
        animal4 = (ImageView) findViewById(R.id.animal4);
        starsView1 = (ImageView) findViewById(R.id.starsView1);
        starsView2 = (ImageView) findViewById(R.id.starsView2);
        starsView3 = (ImageView) findViewById(R.id.starsView3);
        starsView4 = (ImageView) findViewById(R.id.starsView4);
        starsView5 = (ImageView) findViewById(R.id.starsView5);

        //set up audio files

        mp = MediaPlayer.create(getApplicationContext(), R.raw.tencorrect);
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.buzzer);
        mp2 = MediaPlayer.create(getApplicationContext(), R.raw.bell);
        mp3 = MediaPlayer.create(getApplicationContext(), R.raw.tada);

        // set up help text

        helpText.setText("Get 10 correct answers and earn an animal.\n Every 50 points," +
                        " you get to keep that animal and start the mext level.\n" +
                        "Each new level is more difficult than the last, so be careful!\n" +
                        "Win the game with all four creatures at 200 points."
        );

        helpText.setMovementMethod(new ScrollingMovementMethod());

        //set up ad

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        //set up initial visibilities
        mainLinearLayout.setVisibility(View.INVISIBLE);
        helpScreen.setVisibility(View.VISIBLE);
        helpText.setVisibility(View.VISIBLE);
        closeButton.setVisibility(View.INVISIBLE);
        playButton.setVisibility(View.VISIBLE);

        //soft keyboard

        enterAnsText.setInputType(InputType.TYPE_CLASS_NUMBER);

        enterAnsText.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            answerQ(null);

            return true;
        }
        return false;
    }
}
