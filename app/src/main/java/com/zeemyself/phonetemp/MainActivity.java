package com.zeemyself.phonetemp;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView temp;
    private Sensor temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = (TextView) findViewById(R.id.temp);

        SensorManager sensor = (SensorManager)getSystemService(SENSOR_SERVICE);

        temperature = sensor.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperature != null)
            temp.setText(temperature.getPower()+"");
        else
            temp.setText("Your device doesn't have sensor");
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() != Sensor.TYPE_AMBIENT_TEMPERATURE) return;

        temp.setText(""+temperature.getPower());

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
