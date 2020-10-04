package com.nechaev.loftcoin.ui.rates;

import androidx.lifecycle.ViewModelProvider;

import com.nechaev.loftcoin.BaseComponent;
import com.nechaev.loftcoin.utils.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RatesModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
public abstract class RatesComponent {
    abstract ViewModelProvider.Factory viewModelFactory();
    abstract RatesAdapter ratesAdapter();
}
