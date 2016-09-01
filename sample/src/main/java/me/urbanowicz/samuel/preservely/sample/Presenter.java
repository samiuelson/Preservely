package me.urbanowicz.samuel.preservely.sample;

public class Presenter implements Contract.Presenter<Contract.View>{
    private Contract.View view;
    private int counter = 0;

    @Override
    public void onViewAttached(Contract.View v) {
        this.view = v;
        view.displayMessage("Presenter instance reloaded for: " + counter++ + " times.");
    }
}
