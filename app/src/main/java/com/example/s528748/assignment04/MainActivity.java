package com.example.s528748.assignment04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Event> events = new ArrayList<>();
    ArrayAdapter server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.Listview);

        server = new MyArrayAdapter(this, R.layout.event_item, R.id.textView1, events);
        
        listView.setAdapter(server);

        listView.setOnItemClickListener(new ListView.OnItemClickListener( ){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Event e = events.get(position);
                e.incrementCountByOne();
                TextView textView = (TextView) findViewById(R.id.textView2);
                textView.setText(e.getCount() + "");
                // redraws only updated ones
                server.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),
                        "You clicked: "+ e.getName(),
                        Toast.LENGTH_SHORT).show();
            }
            //   data.add(new Pet("xx", "mutt", 50.0));


        });


    }

    public void onClick(View v){
        EditText editText = (EditText) findViewById(R.id.edittext);
        String newEventName = editText.getText().toString();
        if(!newEventName.equals("")){
            Event e = new Event(newEventName);
            events.add(e);
            Toast.makeText(getApplicationContext(),
                    newEventName + " event created",
                    Toast.LENGTH_SHORT).show();
            server.notifyDataSetChanged();
        }
        else
            Toast.makeText(getApplicationContext(),
                    "Enter an Event Name",
                    Toast.LENGTH_SHORT).show();
        editText.setText("");

 /*       TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText(e.getCount());
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(e.getName());  */

    }

    public static Comparator<Event> getCompByName()
    {
        Comparator comp = new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2)
            {
                return e1.getName().compareTo(e2.getName());
            }
        };
        return comp;
    }

    public static Comparator<Event> getCompByCount()
    {
        Comparator comp = new Comparator<Event>(){
            @Override
            public int compare(Event e1, Event e2)
            {
                return Integer.compare(e1.getCount(), e2.getCount());
            }
        };
        return comp;
    }


    public void sortByName(View view) {
        Collections.sort(events, getCompByName() );
        server.notifyDataSetChanged();
    }

    public void sortByCount(View view) {
        Collections.sort(events, getCompByCount() );
        server.notifyDataSetChanged();

    }
}
