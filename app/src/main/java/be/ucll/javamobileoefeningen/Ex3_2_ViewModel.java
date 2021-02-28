package be.ucll.javamobileoefeningen;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Ex3_2_ViewModel extends ViewModel {
    private MutableLiveData<String> text1 = new MutableLiveData<>();
    private MutableLiveData<String> text2 = new MutableLiveData<>();
}
