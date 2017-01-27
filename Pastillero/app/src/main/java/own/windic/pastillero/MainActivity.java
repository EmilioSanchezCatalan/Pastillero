package own.windic.pastillero;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ImageButton test_med;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test_med = (ImageButton)findViewById(R.id.activity_main_testmed_imagenbutton);
        preferences = getSharedPreferences("tester", 0);

        if (Timer.now().equals(preferences.getString("fecha", "")) && preferences.getBoolean("test", false) == true){
            test_med.setImageDrawable(getResources().getDrawable(R.drawable.pastilla_true));
        }else {
            test_med.setImageDrawable(getResources().getDrawable(R.drawable.pastilla_false));
            test_med.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_testmed_imagenbutton:
                SharedPreferences.Editor  prefedit= preferences.edit();
                prefedit.putString("fecha", Timer.now());
                prefedit.putBoolean("test", true);
                prefedit.commit();
                test_med.setImageDrawable(getResources().getDrawable(R.drawable.pastilla_true));
                break;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_reset_item:
                SharedPreferences.Editor editorPref = preferences.edit();
                editorPref.putString("fecha", "");
                editorPref.putBoolean("test", false);
                editorPref.commit();
                finish();
                startActivity(getIntent());
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
