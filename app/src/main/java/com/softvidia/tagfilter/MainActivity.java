package com.softvidia.tagfilter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.softvidia.chipfilter.ChipFilter;
import com.softvidia.chipfilter.Filter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChipFilter chipFilter = findViewById(R.id.chip_filter);
        chipFilter.init(this);
        chipFilter.addFilter(new Filter("Speedo", "0", R.drawable.ic_directions_bus_white_24dp, "", true));
        chipFilter.addFilter(new Filter("HOV", "0", R.drawable.ic_directions_bus_white_24dp, "", false));
        chipFilter.addFilter(new Filter("LOV", "0", R.drawable.ic_directions_bus_white_24dp, "", false));
        chipFilter.addFilter(new Filter("Speedo", "0", R.drawable.ic_directions_bus_white_24dp, "", false));
        chipFilter.setOnFilterSelectListener(new ChipFilter.FilterSelect() {
            @Override
            public void onSelect(Filter tag) {
                Toast.makeText(MainActivity.this, "" + tag.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        Filter selectedChip = chipFilter.getSelectedChip();

    }
}
