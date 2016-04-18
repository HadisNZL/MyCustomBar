package com.example.mycustombar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.progress_two)
    RoundCornerProgressBar progressTwo;
    @Bind(R.id.edittext)
    EditText editText;
    @Bind(R.id.btn)
    Button button;
    @Bind(R.id.tv_show)
    TextView textView;
    String getNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void OnClickBtn(View view) {
        getNum = editText.getText().toString();
        float mm = Float.parseFloat(getNum);
        float num = mm / 10;
        updateProgressTwoColor(num);
    }

    private void updateProgressTwoColor(float num) {
        //设置textview%
        if (num > 100.0f) {
            textView.setText("100%");
        }
        textView.setText(getNum + "%");
        progressTwo.setProgressColor(getResources().getColor(R.color.custom_progress_orange_progress));
        //progress的进度基本是从1~10.0f范围
        progressTwo.setProgress(num);
        float progress = progressTwo.getProgress();
        if (progress <= 3) {
            progressTwo.setProgressColor(getResources().getColor(R.color.custom_progress_red_progress));
        } else if (progress > 3 && progress <= 6) {
            progressTwo.setProgressColor(getResources().getColor(R.color.custom_progress_orange_progress));
        } else if (progress > 6) {
            progressTwo.setProgressColor(getResources().getColor(R.color.custom_progress_green_progress));
        }
    }
}
