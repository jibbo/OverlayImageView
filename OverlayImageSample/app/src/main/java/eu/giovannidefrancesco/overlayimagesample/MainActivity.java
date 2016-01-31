package eu.giovannidefrancesco.overlayimagesample;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Checkout this amazing Library =)");
                intent.putExtra(Intent.EXTRA_TEXT, "The Library paints an overlay on an Imageview to provide text protection" +
                        "<br/> Check it out <a href='https://github.com/jibbo/OverlayImageView'>here</a>!");
                startActivity(Intent.createChooser(intent, "Send to Friends"));
            }
        });
    }

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

        TextView tv = (TextView) getLayoutInflater().inflate(R.layout.dialog_info,null,false);
        tv.setText(Html.fromHtml("This app showcases the OverlayImageView library, which is " +
                "available <a href='https://github.com/jibbo/OverlayImageView'>here</a>. " +
                "The example picture shown here has been made by " +
                "<a href='https://www.flickr.com/photos/romainguy/5911366388'>Romain Guy.</a>"));
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {

            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
            dialogBuilder.setTitle("Info")
                    .setView(tv)
                    .setPositiveButton("Ok",null)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
