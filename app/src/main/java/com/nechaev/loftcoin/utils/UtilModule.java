package com.nechaev.loftcoin.utils;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UtilModule  {
    @Binds
    abstract ImageLoader imageLoader(PicassoImageLoader impl);
}
