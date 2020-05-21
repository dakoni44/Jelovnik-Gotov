package com.example.termin18_d;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.example.termin18_d.model.JeloProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragment.OnItemClickListener{

    private boolean isLandscape=false;
    private DetailFragment detaljiFragment;
    List<String> drawerItems;
    ListView drawerList;
    DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    Toolbar toolbar;
    AlertDialog dijalog;
    public static final int NOTIF_ID = 101;
    public static final String NOTIF_CHANNEL_ID = "notif_channel_007";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList();
        if(findViewById(R.id.flDetail)!=null){
            isLandscape=true;
            detaljiFragment=new DetailFragment();
            detaljiFragment.setContent(JeloProvider.getJela().get(0).getId());
            FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flDetail,detaljiFragment);
            transaction.commit();
        }
        createNotificationChannel();
        fillData();
        setupToolbar();
        setupDrawer();

    }

    private void showList(){
        ListFragment fragment=new ListFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFrame,fragment);
        transaction.commit();
    }

    private void showListOfCategories(){
        CategoryFragment fragment=new CategoryFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFrame,fragment);
        transaction.commit();
    }

    @Override
    public void OnItemClicked(int id) {


        if(isLandscape){
            detaljiFragment.updateContent(id);
        }else {
            DetailFragment fragment = new DetailFragment();
            fragment.setContent(id);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flFrame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIF_CHANNEL_ID);
        builder.setContentTitle("Porudzbina")
                .setContentText("Uspesno ste porucili jelo")
                .setSmallIcon(R.drawable.ic_notif_icon);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIF_ID, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Description of My Channel";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NOTIF_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void fillData(){
        drawerItems = new ArrayList<>();
        drawerItems.add("Kategorije");
        drawerItems.add("Jela");
        drawerItems.add("Preferences");
        drawerItems.add("Info");

    }

    private void setupToolbar(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_dehaze_black_24dp);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }
    }

    private void setupDrawer(){
        drawerList = findViewById(R.id.left_drawer);
        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, drawerItems));
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = "Unknown";
                switch (i){
                    case 0:
                        title = "Kategorije";
                        showListOfCategories();
                        break;
                    case 1:
                        title = "Jela";
                        showList();
                        break;
                    case 2:
                        title = "Preferences";
                        showPrefs();
                        break;

                    case 3:
                        title = "Info";
                        showDialog();
                        break;
                    default:
                        break;
                }
                //drawerList.setItemChecked(i, true);
                setTitle(title);
                drawerLayout.closeDrawer(drawerList);
            }
        });

        drawerToggle = new ActionBarDrawerToggle(
                this,                           /* host Activity */
                drawerLayout,                   /* DrawerLayout object */
                toolbar,                        /* nav drawer image to replace 'Up' caret */
                R.string.app_name,           /* "open drawer" description for accessibility */
                R.string.app_name           /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                //getSupportActionBar().setTitle("");
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                //getSupportActionBar().setTitle("");
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }
        };
    }

    private void showDialog(){
        if (dijalog == null){
            dijalog = new NasDijalog(this).prepareDialog();
        } else {
            if (dijalog.isShowing()){
                dijalog.dismiss();
            }
        }
        dijalog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                showNotification();
                break;
            case R.id.action_update:
                Toast.makeText(this, "Action update executed.", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this, "Action delete executed.", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showPrefs(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        PrefsFragment fragment = new PrefsFragment();
        transaction.replace(R.id.flFrame, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
