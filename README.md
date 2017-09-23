# FancyDialog
************************************** Sorry, currently this app is outdated **************************************
<a href='https://play.google.com/store/apps/details?id=com.geniusforapp.fancysample'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height="70" width="180"/></a> <br />
************************************** Sorry, currently this app is outdated **************************************

A customisable AlertDialog for Android.

<img src="https://raw.githubusercontent.com/ahmadnajar10/fancyDialog/master/device-2017-03-08-171007.png" width="1024" hight="500"/>


# Whats new
* set text gravity for title, subtitle and text body
* set dialog cancelable


## Add Library
```
repositories {
        jcenter()
}    
compile 'com.geniusforapp.fancydialog:FancyDialog:0.1.2'
```
## Code Sample
```java
FancyAlertDialog.Builder alert = new FancyAlertDialog.Builder(MainActivity.this)
                        .setImageRecourse(R.drawable.ic_cloud_computing)
                        .setTextTitle("UPLOAD")
                        .setTextSubTitle("128GB/500GB")
                        .setBody("New DATA has ben added to the device do you want to sync it with the service")
                        .setNegativeColor(R.color.colorNegative)
                        .setNegativeButtonText("Later")
                        .setOnNegativeClicked(new FancyAlertDialog.OnNegativeClicked() {
                            @Override
                            public void OnClick(View view, Dialog dialog) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButtonText("Continue")
                        .setPositiveColor(R.color.colorPositive)
                        .setOnPositiveClicked(new FancyAlertDialog.OnPositiveClicked() {
                            @Override
                            public void OnClick(View view, Dialog dialog) {
                                Toast.makeText(MainActivity.this, "Updating", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setBodyGravity(FancyAlertDialog.TextGravity.LEFT)
                        .setTitleGravity(FancyAlertDialog.TextGravity.CENTER)
                        .setSubtitleGravity(FancyAlertDialog.TextGravity.RIGHT)
                        .setCancelable(false)
                        .build();
                alert.show();           
```

## Code Sample for custom font
```java
/* To change the the title font and body and content 
 you can use this methods */
 
 builder.setPositiveButtonFont("fonts/lato.ttf");
 builder.setNegativeButtonFont("fonts/lato.ttf");
 builder.setTitleFont("fonts/lato.ttf");
 builder.setSubTitleFont("fonts/lato.ttf");
```

## Code sample for change button panel gravity
```java
builder.setButtonsGravity(PanelGravity.CENTER)
```

### Pull requests are welcome!

Feel free to contribute to FancyDialog.

If you've fixed a bug or have a feature you've added, just create a pull request. If you've found a bug, want a new feature, or have other questions, file an issue. I will try to answer as soon as possible.

### Applications using FancyDialog

Please send a pull request if you would like to be added here.

## License

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
