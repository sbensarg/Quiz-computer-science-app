package qi.quiz.computerscience;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;




public class CatgActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btn1:
                Intent intentLevel1 = new Intent(CatgActivity.this, MainActivity.class);
                intentLevel1.putExtra("Category", Constants.LEVEL1);
                startActivity(intentLevel1);
            break;

            case R.id.btn2:
                Intent intentLevel2 = new Intent(CatgActivity.this, MainActivity.class);
                intentLevel2.putExtra("Category", Constants.LEVEL2);
                startActivity(intentLevel2);
                break;

            case R.id.btn3:
                Intent intentLevel3 = new Intent(CatgActivity.this, MainActivity.class);
                intentLevel3.putExtra("Category", Constants.LEVEL3);
                startActivity(intentLevel3);
                break;
            case R.id.btn4:
                Intent intentLevel4 = new Intent(CatgActivity.this, MainActivity.class);
                intentLevel4.putExtra("Category", Constants.LEVEL4);
                startActivity(intentLevel4);
                break;

            case R.id.btn5:
                Intent intentLevel5 = new Intent(CatgActivity.this, MainActivity.class);
                intentLevel5.putExtra("Category", Constants.LEVEL5);
                startActivity(intentLevel5);
                break;
}

    }
}
