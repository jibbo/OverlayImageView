# OverlayImageView

![Alt text](https://img.shields.io/badge/license-MIT-green.svg?style=flat)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-OverlayImageView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/3239)

This library provides an Imageview which can paint a layer on top of the image. This feature could be used for text protection or to apply a tint to an image.

<img src="http://jibbo.altervista.org/gh/overlayimageview.gif" alt="sample preview" title="sample preview" width="250"/>

##Usage:
First thing you'll need import the project by adding this line to your **build.gradle**
```groovy
 compile 'eu.giovannidefrancesco:overlayimageview:1.0'
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
Of course, any color can be used.

###License
This library has been released with MIT license, a copy is inside the repo.
```
The MIT License (MIT)
Copyright © 2016 Giovanni De Francesco

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

#####Note:
This is my first Android library, please be patient and I would gladly accept
any criticism. Also, any help is appreciated!

#####Copyrights:
The picture of the mountain used in the sample app and above has been made by Romain Guy, it has not been modified and it is available <a href='https://www.flickr.com/photos/romainguy/5911366388'>here</a> with a copy of its license. 
