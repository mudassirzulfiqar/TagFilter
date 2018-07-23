# Tag Filter

## Installing

Add following 
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Import the library into gradle

```
dependencies {
	        implementation 'com.github.mudassirzulfiqar:TagFilter:0.4-beta'
	}
```

### Getting Started

Define layout in your xml file.

**your_layout.xml**
```xml
 <com.github.mudassirzulfiqar.ChipFilter
        android:id="@+id/chip_filter"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="5sp" />
```



```java
  ChipFilter chipFilter = findViewById(R.id.chip_filter);
        chipFilter.init(this);
        chipFilter.addFilter(new Filter("Bus", "0", R.drawable.ic_bus, "", true));
        chipFilter.addFilter(new Filter("Train", "1", R.drawable.ic_train, "", false));
        chipFilter.addFilter(new Filter("Car", "2", R.drawable.ic_card, "", false));
        chipFilter.setOnFilterSelectListener(new ChipFilter.FilterSelect() {
            @Override
            public void onSelect(Filter tag) {
                Toast.makeText(MainActivity.this, "" + tag.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        Filter selectedChip = chipFilter.getSelectedChip();
```


## Contributing

* File [bug report](https://github.com/mudassirzulfiqar/TagFilter/issues/new)
* Request [feature](https://github.com/mudassirzulfiqar/TagFilter/issues/new)
* Create [Pull request](https://github.com/mudassirzulfiqar/TagFilter/pulls)

## Authors

* **Mudassir Zufiqar** - [Linkedin](https://www.linkedin.com/in/mudassir-zulfiqar-872b1884)


## License

This project is licensed under the Apache 2.0 License.

## Acknowledgments

* Inspiration - Google Maps Filter
