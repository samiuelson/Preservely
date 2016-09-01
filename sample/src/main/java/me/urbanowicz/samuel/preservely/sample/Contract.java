package me.urbanowicz.samuel.preservely.sample;

public interface Contract {
    interface View {
        void displayMessage(String msg);
    }

    interface Presenter<View> {
        void onViewAttached(View v);
    }
}
