package me.urbanowicz.samuel.bonnie.base;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

public class Preserver {

    public static <I> void init(
            final AppCompatActivity activity,
            final int loaderId,
            final PreservedInstanceFactory<I> factory,
            final OnInstanceReloadedAction<I> onInstanceReloaded,
            final OnInstanceDestroyedAction onInstanceDestroyed) {

        activity.getSupportLoaderManager()
                .initLoader(
                        loaderId,
                        Bundle.EMPTY,
                        new LoaderManager.LoaderCallbacks<I>() {
            @Override
            public Loader<I> onCreateLoader(int i, Bundle bundle) {
                return new PreservedInstanceLoader<>(activity.getApplicationContext(), factory);
            }

            @Override
            public void onLoadFinished(Loader<I> loader, I instance) {
                onInstanceReloaded.performAction(instance);
            }

            @Override
            public void onLoaderReset(Loader<I> loader) {
                onInstanceDestroyed.performAction();
            }
        });
    }

    public interface OnInstanceDestroyedAction {
        void performAction();
    }

    public interface OnInstanceReloadedAction<I> {
        void performAction(I instance);
    }

}
