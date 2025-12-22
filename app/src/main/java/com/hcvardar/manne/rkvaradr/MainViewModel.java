package com.hcvardar.manne.rkvaradr;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final NetworkMonitor networkMonitor;
    private final LiveData<Boolean> isConnected;

    public MainViewModel(NetworkMonitor networkMonitor) {
        this.networkMonitor = networkMonitor;
        this.isConnected = networkMonitor.getIsConnected();
        networkMonitor.start();
    }

    public LiveData<Boolean> isConnected() {
        return isConnected;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        networkMonitor.stop();
    }
}
