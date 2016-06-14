package coursera.hennessee.kaelah.lab4b_modernartui;

/**
 * Created by Kaelah Hennessee in 2015.
 */

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int i = 0;
        final View blueView = (View)findViewById(R.id.blueTextView);
        final View purpleView = (View)findViewById(R.id.purpleTextView);
        final View redView = (View)findViewById(R.id.redTextView);
        final View grayView = (View)findViewById(R.id.grayTextView);
        final View aquaView = (View)findViewById(R.id.aquaTextView);
        SeekBar seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //Change color with seekBar movement.
                blueView.setBackgroundColor(Color.rgb(102 + i, 102 + i, 255));
                purpleView.setBackgroundColor(Color.rgb(255, 153 + i, 104 + i));
                redView.setBackgroundColor(Color.rgb(i+ 10, i+ 10, 10 + i));
                aquaView.setBackgroundColor(Color.rgb(0 + i + 100, 0 + i, 204));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //click one of them
        if (id == R.id.menu_art) {
            openDialogFragment();
            return true;
        }
        if (id == R.id.app_information){
            appInformationDialog();
            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    private void openDialogFragment() {
        FragmentManager fm=getFragmentManager();
        MyDialogFragment myDialogFragment=new MyDialogFragment();

        myDialogFragment.show(fm,"choose from here");
    }

    private void appInformationDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("About");
        alertDialog.setMessage("This app was made by Kaelah Hennessee, 2015.\nIt was made for " +
                "Coursera's Android Systems Part 1 with Dr.Adam Porter.");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CLOSE",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}

