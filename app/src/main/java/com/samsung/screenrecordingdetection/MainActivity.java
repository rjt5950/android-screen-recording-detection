package com.samsung.screenrecordingdetection;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {
    private static final String RECORDING_MESSAGE = "We're being recorded";
    private static final String NOT_RECORDING_MESSAGE = "We're not being recorded";
    private final String TAG = "ScreenRecordingDetection";
    private final int SCREEN_RECORDING_STATE_VISIBLE = 1;
    private final int SCREEN_RECORDING_STATE_NOT_VISIBLE = 0;
    private int screen_recording_status = SCREEN_RECORDING_STATE_NOT_VISIBLE;
    private Context mContext;
    private final Consumer<Integer> mCallback = state -> {
        switch (state) {
            case SCREEN_RECORDING_STATE_VISIBLE:
                Log.i(TAG, RECORDING_MESSAGE);
                screen_recording_status = SCREEN_RECORDING_STATE_VISIBLE;
                Toast.makeText(mContext, RECORDING_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            case SCREEN_RECORDING_STATE_NOT_VISIBLE:
                Log.i(TAG, NOT_RECORDING_MESSAGE);
                screen_recording_status = SCREEN_RECORDING_STATE_NOT_VISIBLE;
                Toast.makeText(mContext, NOT_RECORDING_MESSAGE, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    };
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView infoText = findViewById(R.id.info_text);
        String message = getString(R.string.display_app_info_message);
        infoText.setText(message);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mContext = this;
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);

        Button getRecordingStateButton = findViewById(R.id.recording_status_button);
        getRecordingStateButton.setOnClickListener(view -> {
            new CustomToast().show_Toast(getApplicationContext(), view,
                    (screen_recording_status == SCREEN_RECORDING_STATE_VISIBLE));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "Adding screen recording callback");
        int initialState = mWindowManager.addScreenRecordingCallback(mContext.getMainExecutor(),
                mCallback);
        Log.i(TAG, "Recording InitialState: " + initialState);
        mCallback.accept(initialState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "Removing screen recording callback");
        mWindowManager.removeScreenRecordingCallback(mCallback);
    }

    private static class CustomToast {
        private void show_Toast(Context context, View view, boolean showErrorIcon) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.custom_toast,
                    view.findViewById(R.id.toast_root));
            TextView text = layout.findViewById(R.id.toast_error);
            //text.setText(msg);

            Drawable errorIcon = ContextCompat.getDrawable(context, R.drawable.error);
            if (showErrorIcon) {
                text.setText(RECORDING_MESSAGE);
                text.setCompoundDrawablesWithIntrinsicBounds(errorIcon, null, null, null);
            } else {
                text.setText(NOT_RECORDING_MESSAGE);
                text.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }

            Toast toast = new Toast(context);
            toast.setGravity(Gravity.NO_GRAVITY | Gravity.FILL_HORIZONTAL, 0, 0);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(layout);
            toast.show();
        }
    }
}
