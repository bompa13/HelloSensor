package com.example.hellosensor;

import androidx.appcompat.app.AppCompatActivity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class Acc extends AppCompatActivity implements SensorEventListener{
    SensorManager mSensorManager;
    Sensor mAccelerometer;
    private TextView outputX, outputY, outputZ, lutningX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc);

        outputX = findViewById(R.id.AccX);
        outputY = findViewById(R.id.AccY);
        outputZ = findViewById(R.id.AccZ);
        lutningX =findViewById(R.id.textView6);


        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_UI);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if(mySensor.getType() == Sensor.TYPE_ACCELEROMETER){
            outputX.setText(String.valueOf(event.values[0]));
            outputY.setText(String.valueOf(event.values[1]));
            outputZ.setText(String.valueOf(event.values[2]));
        }
        if (event.values[0] < 0 ){
            lutningX.setText("Mot höger");
        } else {
            lutningX.setText("Mot vänster");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
