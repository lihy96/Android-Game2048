package win.lihy.game2048;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

	private TextView tvScore,tvHighScore;
	private GameView gameView;
	private Button btnRestart;
	private static MainActivity mainActivity = null;
	private int score = 0;// 计分器
	private MyAnimation myAnimation = null;
	

	public MainActivity() {
		mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		tvScore = (TextView) findViewById(R.id.tvScore);
		myAnimation = (MyAnimation) findViewById(R.id.myAnimation);
		tvHighScore = (TextView) findViewById(R.id.tvHighScore);
		gameView = (GameView) findViewById(R.id.gameView);
		btnRestart = (Button) findViewById(R.id.btnRestart);
		
		btnRestart.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				gameView.startGame();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static MainActivity getMainActivity() {
		return mainActivity;
	}

	public void clearScore() {
		score = 0;
		showScore();
	}

	public void showScore() {
		tvScore.setText(score + "");
	}
	public void showHighScore(){
		tvHighScore.setText(WelcomePage.getWelcomePage().getBestScore()+"");
	}

	public void addScore(int s) {
		score += s;
		showScore();
		int highScore = Math.max(WelcomePage.getWelcomePage().getBestScore(), score);
		WelcomePage.getWelcomePage().saveBestScore(highScore);
		showHighScore();
	}

	public MyAnimation getMyAnimation() {
		return myAnimation;
	}
	
	
	
	
	
	

}
