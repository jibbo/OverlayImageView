# OverlayImageView

This library provides an Imageview which can  paint a layer on top of the image.The main usages of this feature are: text protection or to apply a tint to an image.

##Usage:
First thing you'll need to import the project by adding this line to your *build.gradle*

```
 not yet in JCenter (please wait a few hours)
``` 
Second, you can just drop this Tag in your xml:

```xml
<eu.giovannidefrancesco.overlayimageview.OverlayImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:src="@drawable/my_beautiful_picture" />
```

Now you can replace **my_beatiful_picture with** your own image and you are ready to go.

##Customization
By default the app put a transparent black overlay on the image. However, you can always set a different color by adding the following tags to your xml:

```xml
<eu.giovannidefrancesco...
xmlns:app="http://schemas.android.com/apk/res-auto"
app:tintColor="@color/my_beatiful_color"/>
```
Or set it programmatically:
```java
//red tint
int color = Color.argb(80, 200, 0,0);
//mOverlayImageView has been already set with findViewById...
mOverlayImageView.setTintColor(color);
```

#####Note:
This is my first Android library, please be patient and I would gladly accept
any criticism. Also, any help is appreciated!
