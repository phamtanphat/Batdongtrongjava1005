package khoapham.ptp.phamtanphat.batdongtrongjava1005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ống nước : thread
        //nguồn nước : runable
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "Xin chao", Toast.LENGTH_SHORT).show();
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //running

            }
        });
        thread.start();
    }
}
