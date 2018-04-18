package daybook.vishukumar.com.daybook;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class AllNotesActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DiaryStatusAdapter diaryStatusAdapter;

    List<DiaryStatus> diaryStatusList;


    StatusDatabaseHelper statusDatabaseHelper;

    int angryCount,
            anxiousCount,
            demotivatedCount,
            happyCount,
            sadCount,
            worthlessCount;

    //For months dropdown
    Spinner spinner;
    String[] allMonths =  {
            "...",
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
    };

    ArrayList<String> months = new ArrayList<>();

    //4 buttons on top
    ImageButton quitButton, graphButton, newStatusButton, quotesButton;

    //Main Scroll View
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);

        Log.d("tag", "All notes activity");

        //Reference scroll view and scroll it to top
        scrollView = (ScrollView) findViewById(R.id.mainScrollViewId);
        scrollView.smoothScrollTo(0,0);


        diaryStatusList = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewId);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Read all status from database and create DiaryStatus objects
        //Read data from database
        statusDatabaseHelper = new StatusDatabaseHelper(this);

        Cursor cursor = statusDatabaseHelper.getAllStatus();
        if(cursor.getCount() == 0) {
            Log.d("tag", "No Entries in Database");
        } else {
            Log.d("tag", "***********Printing entries from Database");
            String dbDate, dbStatus, dbMood;
            while (cursor.moveToNext()) {
                dbDate = cursor.getString(1);
                dbStatus = cursor.getString(2);
                dbMood = cursor.getString(3);

                diaryStatusList.add(new DiaryStatus(dbDate, dbMood, dbStatus));

                Log.d("tag", dbDate);
                Log.d("tag", dbStatus);
                Log.d("tag", dbMood);
                Log.d("tag", "\n");
            }
        }

        System.out.println(diaryStatusList);
        diaryStatusAdapter = new DiaryStatusAdapter(this, diaryStatusList);


        recyclerView.setAdapter(diaryStatusAdapter);
    }
}
