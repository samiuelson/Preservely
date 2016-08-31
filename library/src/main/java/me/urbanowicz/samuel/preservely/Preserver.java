package me.urbanowicz.samuel.preservely;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

/**
 * Preserver class provides ready to use API for preserving instance of some object
 * across orientation changes.
 *
 * Preserver uses {@link android.content.Loader} API under the hood.
 * On Android platform Loaders are used to provide resources / data async loading.
 * However, Loaders has special property of preserving instance of the object when it's reloaded.
 * For example while reloading after orientation change occured.
 */
public class Preserver {

    /**
     * Should be called from {@link android.app.Activity} or {@link android.app.Fragment}
     * @param activity Instance of the current Activity
     *
     * @param loaderId The id of the loader that is being used to provide cache for the instance that
     *                 is being preserved. You should pass here different ids for each instance you
     *                 are preserving for each Activity or Fragment. Keep in mind that Preserved class
     *                 uses {@link Loader} under the hood. For that reason the id should be different
     *                 from any other Loader ids in the Activity / Fragment too.
     *
     * @param factory Instance of {@link PreservedInstanceFactory} class. Used to construct the instance
     *                that is going to be preserved for the first time.
     *
     * @param onInstanceReloaded Callback action fired after preserved instance was reloaded.
     *
     * @param onInstanceDestroyed Function that will be called when Preserver was cleared. For example,
     *                            when Activity was closed, abandoned and will no longer used.
     *
     * @param <I> Type of the object being preserved
     */
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
