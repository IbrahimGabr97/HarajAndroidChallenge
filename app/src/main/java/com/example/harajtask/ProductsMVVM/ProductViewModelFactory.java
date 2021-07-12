package com.example.harajtask.ProductsMVVM;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ProductViewModelFactory  implements ViewModelProvider.Factory {

        private final Application mApplication;



        public ProductViewModelFactory(Application application) {
            mApplication = application;

        }
        @Override
        public <T extends ViewModel> T create(Class<T> modelClass) {
            return (T) new ProductViewModel(mApplication);
        }
    }



