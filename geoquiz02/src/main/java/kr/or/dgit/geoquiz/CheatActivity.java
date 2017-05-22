package kr.or.dgit.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
