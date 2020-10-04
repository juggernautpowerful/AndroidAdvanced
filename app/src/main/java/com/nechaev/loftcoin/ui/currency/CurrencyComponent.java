package com.nechaev.loftcoin.ui.currency;


import androidx.lifecycle.ViewModelProvider;

import com.nechaev.loftcoin.BaseComponent;
import com.nechaev.loftcoin.utils.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        CurrencyModule.class,
        ViewModelModule.class
}, dependencies = {
        BaseComponent.class
})
abstract class CurrencyComponent {
    abstract ViewModelProvider.Factory viewModelFactory();
}
