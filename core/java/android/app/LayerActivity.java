/*
 * Copyright (C) 2013 - 2014 MoKee OpenSource Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.app;

import android.app.Activity;
import android.os.Bundle;

public class LayerActivity extends Activity {

    private Bundle mSavedInstanceState;
    private boolean mRestarted = false;
    private boolean mShouldFinish = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSavedInstanceState = savedInstanceState;
    }

    @Override
    public void onRestart() {
        super.onRestart();
        mRestarted = true;
    }

    @Override
    public void onStart() {
        super.onStart();
        mShouldFinish = mRestarted;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!mShouldFinish) {
            mShouldFinish = true;
            return;
        }
        mShouldFinish = false;
        finish();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mSavedInstanceState != null) {
            finish();
        }
    }
}