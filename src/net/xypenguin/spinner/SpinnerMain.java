package net.xypenguin.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerMain extends Activity implements OnClickListener {
	private EditText editText;
	private Button top;
	private Button bot;
	private Button objectRemove;
	private Button indexRemove;
	private Button initialization;
	private Button allClear;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner_main);

		editText = (EditText) this.findViewById(R.id.editText1);
		top = (Button) this.findViewById(R.id.button1);
		top.setOnClickListener(this);
		bot = (Button) this.findViewById(R.id.button2);
		bot.setOnClickListener(this);
		objectRemove = (Button) this.findViewById(R.id.button3);
		objectRemove.setOnClickListener(this);
		indexRemove = (Button) this.findViewById(R.id.button4);
		indexRemove.setOnClickListener(this);
		initialization = (Button) this.findViewById(R.id.button5);
		initialization.setOnClickListener(this);
		allClear = (Button) this.findViewById(R.id.button6);
		allClear.setOnClickListener(this);
		textView = (TextView) this.findViewById(R.id.textView1);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		adapter.add("ラーメン");
		adapter.add("パスタ");
		adapter.add("うどん");
		spinner = (Spinner) this.findViewById(R.id.spinner1);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO 自動生成されたメソッド・スタブ
				Spinner spinner = (Spinner) arg0;
				// 選択されたアイテムを取得します
				String item = (String) spinner.getSelectedItem();
				textView.setText(item);
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO 自動生成されたメソッド・スタブ

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_spinner_main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ
		String text = editText.getText().toString();
		if (v == top) {
			adapter.insert(text, 0);
		} else if (v == bot) {
			adapter.add(text);
		} else if (v == objectRemove) {
			adapter.remove(text);
		} else if (v == indexRemove) {
			int num = Integer.parseInt(text);
			adapter.remove(adapter.getItem(num));
		} else if (v == initialization) {
			adapter.clear();
			adapter.add("ラーメン");
			adapter.add("パスタ");
			adapter.add("うどん");
		} else if (v == allClear) {
			adapter.clear();
		}
		editText.setText("");
	}

}
