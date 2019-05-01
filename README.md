# FancyDialog

<img src="/images/img1.jpg" height="350"/>
<img src="/images/img2.jpg" height="350"/>


> FancyDialog is a AlertDialog with some fancy styling and them the new version of it is completely build with kotlin 

## Add Library
```gradle
repositories {
       maven { url 'https://jitpack.io' }
}    
implementation 'com.github.geniusforapp:fancyDialog:1.0.2'
```

## Code Sample
```kotlin
      val dialog = FancyDialogBuilder(this, R.style.CustomDialog)
                .withImageIcon(R.drawable.ic_new_message)
                .withTitleTypeFace(R.font.roboto_bold)
                .withSubTitleTypeFace(R.font.roboto_medium)
                .withActionPositiveTypeFace(R.font.roboto_bold)
                .withActionNegativeTypeFace(R.font.roboto_bold)
                .withTextGravity(CENTER)
                .withPanelGravity(END)
                .withTitle(R.string.dialog_text_title)
                .withSubTitle(R.string.dialog_text_message)
                .withPositive(R.string.dialog_action_yes) { view, dialog -> dialog.dismiss() }
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
