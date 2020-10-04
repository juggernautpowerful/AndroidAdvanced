package com.nechaev.loftcoin.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.nechaev.loftcoin.ui.converter.ConverterFragment;
import com.nechaev.loftcoin.ui.currency.CurrencyDialog;
import com.nechaev.loftcoin.ui.rates.RatesFragment;
import com.nechaev.loftcoin.ui.wallets.WalletsFragment;
import com.nechaev.loftcoin.utils.LoftFragmentFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainModule {

    @Binds
    abstract FragmentFactory fragmentFactory(LoftFragmentFactory impl);

    @Binds
    @IntoMap
    @ClassKey(RatesFragment.class)
    abstract Fragment ratesFragment(RatesFragment impl);

    @Binds
    @IntoMap
    @ClassKey(WalletsFragment.class)
    abstract Fragment walletsFragment(WalletsFragment impl);

    @Binds
    @IntoMap
    @ClassKey(ConverterFragment.class)
    abstract Fragment converterFragment(ConverterFragment impl);

    @Binds
    @IntoMap
    @ClassKey(CurrencyDialog.class)
    abstract Fragment currencyDialog(CurrencyDialog impl);
}
