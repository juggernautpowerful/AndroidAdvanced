package com.nechaev.loftcoin.ui.currency;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nechaev.loftcoin.data.Currency;
import com.nechaev.loftcoin.data.CurrencyRepository;

import java.util.List;

import javax.inject.Inject;

public class CurrencyViewModel extends ViewModel {

    private final CurrencyRepository currencyRepository;

    @Inject
    public CurrencyViewModel(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @NonNull
    LiveData<List<Currency>> allCurrencies() {
        return currencyRepository.availableCurrencies();
    }

    void updateCurrency(@NonNull Currency currency) {
        currencyRepository.updateCurrency(currency);
    }
}
