package com.nechaev.loftcoin.data;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

import java.io.IOException;
import java.util.List;

public interface CoinsRepository {

    @NonNull
    @WorkerThread
    List<? extends Coin> listings(@NonNull String currency) throws IOException;
}
