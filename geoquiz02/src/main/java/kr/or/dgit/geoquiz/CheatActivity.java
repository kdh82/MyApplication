package kr.or.dgit.geoquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CheatActivity extends AppCompatActivity {
    private static final String EXTRA_ANSWER_IS_TRUE = "kr.or.dgit.geoquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "kr.or.dgit.geoquiz.answer_shown";

    private boolean mAnswerIsTrue;
    private TextView mShowAnswerTextView;

    public static Intent newIntent(Context packageContext, boolean answerIsTrue){
        Intent i  = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mShowAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
    }

    public void mShowAnswerBtnClicked(View view){
        if(mAnswerIsTrue){
            mShowAnswerTextView.setText(R.string.true_button);
        }else{
            mShowAnswerTextView.setText(R.string.false_button);
        }
        setAnswerShownResult(true);
        final Button mShowAnswerBtn = (Button) view;
        int cx = mShowAnswerBtn.getWidth()/2;
        int cy = mShowAnswerBtn.getHeight()/2;
        float radios = mShowAnswerBtn.getWidth();
        Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerBtn, cx, cy, radios, 0);
        anim.addListener(new AnimatorListenerAdapter() {
        @Override
            public void onAnimationEnd(Animator animation){
            super.onAnimationEnd(animation);
            mShowAnswerBtn.setVisibility(View.INVISIBLE);
        }
        });
        anim.start();
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }
    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }
}
