package win.lihy.game2048;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class MyAudio {
	private SoundPool sp;
	private Map<Integer, Integer> map;
	private Context context;

	public MyAudio(Context context) {
		this.context = context;
		init();
	}

	public void init() {
		sp = new SoundPool(2,// 同时播放的音效
				AudioManager.STREAM_MUSIC, 0);
		map = new HashMap<Integer, Integer>();
		map.put(1, sp.load(context, R.raw.merge, 1));
		map.put(2, sp.load(context, R.raw.move, 1));
	}
	
	public void play(int num) {
		 sp.play(map.get(num), 1, 1, 0, 0, 1); 
	}
}
