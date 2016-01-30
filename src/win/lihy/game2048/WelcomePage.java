package win.lihy.game2048;

import java.util.ArrayList;
import java.util.List;

import android.R.bool;
import android.R.integer;
import android.app.Activity;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class WelcomePage extends Activity {

	private ViewPager vp;
	private ViewPagerAdapter vpAdapter;
	private List<View> views;
	private Button btnStart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.welcome_page);
		initViews();

		handler.sendEmptyMessageDelayed(0, 2000);
	}

	private void initViews() {
		LayoutInflater inflater = LayoutInflater.from(this);
		views = new ArrayList<View>();
		views.add(inflater.inflate(R.layout.one, null));
		views.add(inflater.inflate(R.layout.two, null));

		vpAdapter = new ViewPagerAdapter(views, this);
		vp = (ViewPager) findViewById(R.id.viewPager);
		vp.setAdapter(vpAdapter);

		btnStart = (Button) views.get(1).findViewById(R.id.btnStart);
		btnStart.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				startActivity(new Intent(WelcomePage.this, MainActivity.class));
			}
		});

	}

	private boolean isrunning = false;
	private Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			// 让ViewPager滑到下一页
			int now = vp.getCurrentItem();
			if(now == 0){
				vp.setCurrentItem(now + 1);
			}else {
				isrunning = false;
			}
			// 延时，循环调用handler
			if (isrunning) {
				handler.sendEmptyMessageDelayed(0, 2000);
			}
		};
	};

	protected void onDestroy() {
		super.onDestroy();
		isrunning = false;
	};
}