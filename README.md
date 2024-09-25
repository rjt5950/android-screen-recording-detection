# Screen-Recording-Detection-App
An Android application to detect screen recording or screen sharing, ensuring user privacy and security.  

## Overview
The __Screen-Recording-Detection-App__ is a powerful android screen recording detection tool that can detect when this app's screen is being recorded or shared, offering an extra layer of security for sensitive operations. 
This open-source Android app provides real-time detection by triggering a callback whenever the app becomes visible to a screen recorder or sharing tool. It is especially useful for developers working in industries where data privacy is critical, such as banking, healthcare, and enterprise applications.

## Key Features
- **Real-Time Screen Recording Detection:** Detects when the app's screen is being recorded or shared.
- **Privacy and Security Enhancements:** Ensure app privacy by preventing unauthorized screen recordings in sensitive environments.
- **UI Updates:** Automatically updates the user interface to reflect the recording state.
- **Debug Logs:** Provides detailed logging for debugging screen recording detection.
- **Custom Toasts:** Displays custom notifications when recording is detected.
- **Efficient Resource Management:** Utilizes Android's WindowManager to handle callbacks efficiently.


## Why Use Screen-Recording-Detection-App Logic?
- __Privacy and Security:__ Prevent unauthorized screen recordings in sensitive apps.
- __Easy Integration:__ Can be integrated into any Android application with minimal setup.
- __Ideal for Secure Applications:__ Perfect for applications where data protection is paramount, such as in financial apps, corporate environments, and medical software.

## Getting Started
### APK for Testing
You can download the APK file for quick testing. To install the app, use the following ADB command:  
`adb install -t app-debug.apk`  

### How to Use
1. Clone this repository to your local machine:  
    ```
    git clone https://github.com/rjt5950/screen-recording-detection-app.git
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator (preferably on Android 14+ to ensure compatibility with screen recording detection APIs).
4. The app will automatically detect when screen recording is initiated, and a custom toast notification will appear.  

### Code Structure
- **MainActivity.java:** Contains logic for detecting and managing screen recording state.
- **activity_main.xml:** Layout file for the main activity's UI.
- **CustomToast.java:** Custom class for displaying state notifications when recording is detected.
- **custom_toast.xml:** Defines the layout for custom toast notifications.


## Screenshots
| Screen Recording Detected           | Not Recording                       | Toast Notification                          |
| ----------------------------------- | ----------------------------------- | ------------------------------------------- |
| <img src="https://media.github.sec.samsung.net/user/83641/files/107d6830-2416-41d1-ab10-df5b7ad2ae00" width="220" height="auto" /> | <img src="https://media.github.sec.samsung.net/user/83641/files/57eb53bd-a0a1-4eeb-86f6-9585aeec60d4" width="220" height="auto" /> | <img src="https://media.github.sec.samsung.net/user/83641/files/472498bb-b8db-4b27-900e-f4405e40e1ea" width="220" height="auto" /> |


## Technical Specifications
- **Minimum SDK:** Android 15 (API level 35)
- **Permissions Required:** `Manifest.permission.DETECT_SCREEN_RECORDING`
- **No External Dependencies:** The app is built entirely on Android SDK features and does not rely on third-party libraries.


## Use Cases
- **Enterprise Apps:** Prevent screen recording in confidential business apps.
- **Banking & Finance:** Add an extra layer of protection for financial transactions.
- **Healthcare:** Secure patient data by detecting unauthorized screen captures.
- **Personal Security Apps:** Ensure user privacy by notifying them when screen activity is being recorded.


## Contribution Guidelines
Contributions to the project are highly encouraged! If you encounter any issues or have suggestions, please feel free to:
- Open an issue
- Submit a pull request  
Your contributions will help improve privacy for all Android app users!
