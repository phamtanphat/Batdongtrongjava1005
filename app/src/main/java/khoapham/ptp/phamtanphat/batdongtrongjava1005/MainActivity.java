package khoapham.ptp.phamtanphat.batdongtrongjava1005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a ,b ,c = 0;
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ống nước : thread
        //nguồn nước : runable
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
               for (int i = 0 ; i<= 100 ; i++){
                   a += 1;
                   Log.d("BBB","Thead A " + a + " , Vi tri "+ i );
               }
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                for (int i = 0 ; i<= 100 ; i++){
                    b += 2;
                    Log.d("BBB","Thead B " + b + " , Vi tri "+ i );
                }
            }
        });
        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                for (int i = 0 ; i<= 100 ; i++){
                    c = a + b;
                    Log.d("BBB","Thead C " + c + " , Vi tri "+ i );
                }
            }
        });
        threada.start();
        threadb.start();
        threadc.start();
    }

}
