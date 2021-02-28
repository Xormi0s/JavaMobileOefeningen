package be.ucll.javamobileoefeningen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class Ex4_1Service extends Service {

    public Ex4_1Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        new Thread(){
            @Override
            public void run(){

            }
        }.start();
        return Service.START_STICKY;
    }
}