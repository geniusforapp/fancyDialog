# FancyDialog

<a href='https://play.google.com/store/apps/details?id=com.geniusforapp.fancysample'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/images/generic/en_badge_web_generic.png' height="70" width="180"/></a> <br />
 Sorry, currently this app is outdated 

A customisable AlertDialog for Android.

<img src="https://raw.githubusercontent.com/ahmadnajar10/fancyDialog/master/device-2017-03-08-171007.png" width="1024" hight="500"/>


## Add Library
```gradle
repositories {
       maven { url 'https://jitpack.io' }
}    
implementation 'com.github.geniusforapp:fancyDialog:1.0'
```


## Code Sample
```kotlin
  val dialog = FancyDialogBuilder(this)
                .withCanCancel(false)
                .withTitleTypeFace(R.font.roboto_bold)
                .withSubTitleTypeFace(R.font.roboto_medium)
                .withActionPositiveTypeFace(R.font.roboto)
                .withActionNegativeTypeFace(R.font.roboto)
                .withTextGravity(START)
                .withPanelGravity(END)
                .withTitle(R.string.dialog_text_title)
                .withSubTitle(R.string.dialog_text_message)
                .withPositive(R.string.dialog_action_yes, object : OnActionClickedListener {
                    override fun onClick(view: View, dialog: Dialog) {
                        Toast.makeText(this@MainActivity, "Why Me ?", Toast.LENGTH_LONG).show()
                    }
                })
                .withNegative(R.string.dialog_action_no, object : OnActionClickedListener {
                    override fun onClick(view: View, dialog: Dialog) {
                        dialog.dismiss()

                    }
                })
        dialog.show()
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
