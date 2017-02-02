package me.urbanowicz.samuel.preservely.sample;

import java.lang.ref.WeakReference;

public class Presenter implements Contract.Presenter<Contract.View>{
    private WeakReference<Contract.View> view;
    private int counter = 0;

    @Override
    public void onViewAttached(Contract.View v) {
        this.view = new WeakReference<>(v);
        view.get().displayMessage("Presenter instance reloaded for: " + counter++ + " times.");
    }
}
