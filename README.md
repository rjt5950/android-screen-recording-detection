# Screen-Recording-Detection-TestApp
This android application detects when the app's screen is being recorded or shared.

## Overview
This Screen Recording Detection Test is a simple android application designed to detect that it is being recorded. A callback is invoked whenever the app transitions between being visible or invisible within a screen recording.  An app is considered visible if activities owned by the registering process's UID are being recorded. This way, if your app is performing a sensitive operation, you can inform the user that they're being recorded.

## SRDTest-app-debug.apk
This APK file is attached for testing purpose only. Due to project contraints, a full project build on github server is not possible at the moment. Please install this apk for testing using adb command:
'adb install -t SRDTest-app-debug.apk'

## Features
- Detects when the app is visible and it's screen being recorded or not
- Updates UI based on screen recording state
- Logs messages for debugging purpose
- Utilizes 'WindowManager' for managing callbacks


| Recording Toast                     | Recording State                     | Not Recording State                         |
| ----------------------------------- | ----------------------------------- | ------------------------------------------- |
| <img src="https://media.github.sec.samsung.net/user/83641/files/107d6830-2416-41d1-ab10-df5b7ad2ae00" width="220" height="auto" /> | <img src="https://media.github.sec.samsung.net/user/83641/files/57eb53bd-a0a1-4eeb-86f6-9585aeec60d4" width="220" height="auto" /> | <img src="https://media.github.sec.samsung.net/user/83641/files/472498bb-b8db-4b27-900e-f4405e40e1ea" width="220" height="auto" /> |


### Usages
1. Clone the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator.

### Code Structure
- 'MainActivity.java': contains the main logic for managing screen recording callbacks and state.
- 'activity_main.xml': Layout file for the main activity UI.
- 'CustomToast.java': Custom toast class for displaying recording state.
- 'custom_toast.xml': Layout file for CustomToast class.

## Dependencies
- minSdkPreview "VanillaIceCream"
- Requires Manifest.permission.DETECT_SCREEN_RECORDING
- This app does not depend on any external libraries or SDKs beyong the Android SDK.

## Contributing
Contributions are welcome! If you find any issues or have suggestions for improvements, feel free to open an issue or create a pull request.
