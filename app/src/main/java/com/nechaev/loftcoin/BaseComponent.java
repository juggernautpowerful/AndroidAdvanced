package com.nechaev.loftcoin;

import android.content.Context;

import com.nechaev.loftcoin.data.CoinsRepository;
import com.nechaev.loftcoin.data.CurrencyRepository;
import com.nechaev.loftcoin.utils.ImageLoader;

public interface BaseComponent {
    Context context();
    CoinsRepository coinsRepository();
    CurrencyRepository currencyRepository();
    ImageLoader imageLoader();
}
