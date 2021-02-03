package qi.quiz.computerscience;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

/*import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;*/

public class ResultActivity extends AppCompatActivity {

    TextView txtHighScore;
    TextView txtTotalQuizQues,txtCorrectQues,txtWrongQues;

    Button btStartQuiz;
    Button btMainMenu;

    private int highScore;
    public static final String SHARED_PREFERRENCE = "shread_prefrence";
    public static final String SHARED_PREFERRENCE_HIGH_SCORE = "shread_prefrence_high_score";

    private long backPressedTime;

    String CategoryAgainValue="";
    private InterstitialAd mInterstitialAd, mInterstitialAd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        btMainMenu = findViewById(R.id.result_bt_mainmenu);
        btStartQuiz = findViewById(R.id.result_bt_playAgain);
        txtHighScore = findViewById(R.id.result_text_High_Score);
        txtTotalQuizQues = findViewById(R.id.result_total_Ques);
        txtCorrectQues = findViewById(R.id.result_Correct_Ques);
        txtWrongQues = findViewById(R.id.result_Wrong_Ques);

        //interstition ads
        mInterstitialAd = new InterstitialAd(this);
        //mInterstitialAd.setAdUnitId("ca-app-pub-8312201966570453/7125139067");
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

      mInterstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                intent.putExtra("Category",CategoryAgainValue);
                startActivity(intent);
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

        //interstition ads2
        mInterstitialAd2 = new InterstitialAd(this);
        //mInterstitialAd2.setAdUnitId("ca-app-pub-8312201966570453/7583657263");
        mInterstitialAd2.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd2.loadAd(new AdRequest.Builder().build());

        mInterstitialAd2.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed() {
                super.onAdClosed();

                Intent intent = new Intent(ResultActivity.this,CatgActivity.class);
                startActivity(intent);
                mInterstitialAd2.loadAd(new AdRequest.Builder().build());
            }
        });



        btMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd2.isLoaded())
                {
                    mInterstitialAd2.show();
                }
                else {
                    Intent intent = new Intent(ResultActivity.this, CatgActivity.class);
                    startActivity(intent);
                }

            }
        });

        btStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (mInterstitialAd.isLoaded())
                {
                    mInterstitialAd.show();
                }
                else {
                    Intent intent = new Intent(ResultActivity.this,MainActivity.class);
                    intent.putExtra("Category",CategoryAgainValue);
                    startActivity(intent);
                    }
            }
        });


        loadHighScore();

        Intent intent = getIntent();

        int score = intent.getIntExtra("UserScore",0);
        int totalQuestion = intent.getIntExtra("TotalQuestion",0);
        int correctQues = intent.getIntExtra("CorrectQues",0);
        int wrongQues = intent.getIntExtra("WrongQues",0);
        CategoryAgainValue = intent.getStringExtra("Category");


        txtTotalQuizQues.setText("Total Ques: " + String.valueOf(totalQuestion));
        txtCorrectQues.setText("Correct: " + String.valueOf(correctQues));
        txtWrongQues.setText("Wrong: " + String.valueOf(wrongQues));

        if (score > highScore){

            updatHighScore(score);
        }


    }

    private void updatHighScore(int newHighScore) {

        highScore = newHighScore;
        txtHighScore.setText("High Score: " + String.valueOf(highScore));

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SHARED_PREFERRENCE_HIGH_SCORE,highScore);
        editor.apply();


    }

    private void loadHighScore() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERRENCE,MODE_PRIVATE);
        highScore = sharedPreferences.getInt(SHARED_PREFERRENCE_HIGH_SCORE,0);
        txtHighScore.setText("High Score: " + String.valueOf(highScore));

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){

            Intent intent = new Intent(ResultActivity.this,CatgActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();

        }
        backPressedTime = System.currentTimeMillis();
    }
}
