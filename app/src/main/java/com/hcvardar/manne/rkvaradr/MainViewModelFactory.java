package com.hcvardar.manne.rkvaradr;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private final NetworkMonitor networkMonitor;

    public MainViewModelFactory(NetworkMonitor networkMonitor) {
        this.networkMonitor = networkMonitor;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(networkMonitor);
    }
}
