package com.example.user.android_assignment_18_1;
//Package objects contain version information about the implementation and specification of a Java package.
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        //public is a method and fields can be accessed by the members of any class.
        //class is a collections of objects.
        //created MainActivity and extends with AppCompatActivity which is Parent class.
    TextView txt;
    MyReceiver myReceiver;
        //Intializing the variables.

    BroadcastReceiver broadcastReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //craeting the instance of the broadcast receiver.
            int level= intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            //craeting the int as level and connecting with intent with battery manager so that we can get the level of battery
            txt.setText( "BATTERY LEVEL IS  "+ String.valueOf(level));
            //setting the batter level to the text in the form of string.
        }
    };

    @Override
        //we use override to tells the compiler that the following method overrides a method of its superclass.
    protected void onCreate(Bundle savedInstanceState) {
        //protected can be accessed by within the package and class and subclasses
        //The Void class is an uninstantiable placeholder class to hold a reference to the Class object
        //representing the Java keyword void.
        //The savedInstanceState is a reference to a Bundle object that is passed into the onCreate method of every Android Activity
        // Activities have the ability, under special circumstances, to restore themselves to a previous state using the data stored in this bundle.
        super.onCreate(savedInstanceState);
        //Android class works in same.You are extending the Activity class which have onCreate(Bundle bundle) method in which meaningful code is written
        //So to execute that code in our defined activity. You have to use super.onCreate(bundle)
        setContentView(R.layout.activity_main);
        //R means Resource
        //layout means design
        //main is the xml you have created under res->layout->main.xml
        //Whenever you want to change your current Look of an Activity or when you move from one Activity to another .
        //he other Activity must have a design to show . So we call this method in onCreate and this is the second statement to set
        //the design.
        txt = findViewById(R.id.text);
        //giving id as text
        this.registerReceiver(broadcastReceiver,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        //Context-registered receivers receive broadcasts as long as their registering context is valid.
    }


    private class MyReceiver {
        //created class as MyReceiver.
    }
}

