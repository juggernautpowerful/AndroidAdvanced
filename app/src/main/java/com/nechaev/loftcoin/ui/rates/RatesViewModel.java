package com.nechaev.loftcoin.ui.rates;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.nechaev.loftcoin.data.Coin;
import com.nechaev.loftcoin.data.CoinsRepository;
import com.nechaev.loftcoin.data.CurrencyRepository;
import com.nechaev.loftcoin.data.SortBy;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.inject.Inject;

public class RatesViewModel extends ViewModel {

    private final MutableLiveData<Boolean> isRefreshing = new MutableLiveData<>();

    private final MutableLiveData<AtomicBoolean> forceRefresh = new MutableLiveData<>(new AtomicBoolean(true));

    private Future<?> future;

   private final MutableLiveData<SortBy> sortBy = new MutableLiveData<>(SortBy.RANK);

   private final LiveData<List<Coin>> coins;

    private int sortingIndex = 1;

    @Inject
    public RatesViewModel(CoinsRepository coinsRepository, CurrencyRepository currencyRepository) {

        final LiveData<CoinsRepository.Query> query = Transformations.switchMap(forceRefresh, (r) -> {
            return Transformations.switchMap(currencyRepository.currency(), (c) -> {
                r.set(true);
                isRefreshing.postValue(true);
                return Transformations.map(sortBy, (s) -> {
                    return CoinsRepository.Query.builder()
                            .currency(c.code())
                            .forceUpdate(r.getAndSet(false))
                            .sortBy(s)
                            .build();
                });
            });
        });
        final LiveData<List<Coin>> coins = Transformations.switchMap(query, coinsRepository::listings);
        this.coins = Transformations.map(coins, (c) -> {
            isRefreshing.postValue(false);
            return c;
        });
    }

    @NonNull
    LiveData<List<Coin>> coins() {
        return coins;
    }

    @NonNull
    LiveData<Boolean> isRefreshing() {
        return isRefreshing;
    }

    final void refresh() {
        forceRefresh.postValue(new AtomicBoolean(true));
    }

    @Override
    protected void onCleared() {
        if (future != null) {
            future.cancel(true);
        }
    }

    void switchSortingOrder() {
        sortBy.postValue(SortBy.values()[sortingIndex++ % SortBy.values().length]);
    }
}
