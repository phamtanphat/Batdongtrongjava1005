package khoapham.ptp.phamtanphat.batdongtrongjava1005;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int a, b, c = 0;
    Laco laco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        laco = new Laco();
        laco.vitri = 0;

        //ống nước : thread
        //nguồn nước : runable
        Thread threada = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                for (int i = 0; i <= 100; i++) {
                    synchronized (laco) {
                        if (laco.vitri == 0) {
                            a += 1;
                            Log.d("BBB", "Thead A " + a + " , Vi tri " + i);
                            laco.vitri = 1;
                        }else{
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });
        Thread threadb = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                for (int i = 0; i <= 100; i++) {
                    synchronized (laco){
                        if (laco.vitri == 1){
                            b += 2;
                            Log.d("BBB", "Thead B " + b + " , Vi tri " + i);
                            laco.vitri = 2;
                        }else{
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });
        Thread threadc = new Thread(new Runnable() {
            @Override
            public void run() {
                //running
                for (int i = 0; i <= 100; i++) {
                    synchronized (laco){
                        if (laco.vitri == 2){
                            c = a + b;
                            Log.d("BBB", "Thead C " + c + " , Vi tri " + i);
                            laco.vitri = 0;
                        }else{
                            try {
                                laco.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });
        threada.start();
        threadb.start();
        threadc.start();
    }

}
