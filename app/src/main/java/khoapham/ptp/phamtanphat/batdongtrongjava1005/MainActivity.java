package khoapham.ptp.phamtanphat.batdongtrongjava1005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    synchronized protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ống nước : thread
        //nguồn nước : runable
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
               handle("Thead A");
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                handle("Thead B");
            }
        });
        threadb.start();
        threada.start();
    }
    synchronized public void handle(String key){
        for (int i = 0 ; i<= 1000 ; i++){
            Log.d("BBB",key + " : " + i);
        }
    }
}
