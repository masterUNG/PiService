package app.ewtc.masterung.piservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.ewtc.masterung.piservice.MainActivity;
import app.ewtc.masterung.piservice.R;

/**
 * Created by masterung on 31/10/2017 AD.
 */

public class RegisterFragment extends Fragment{

//    Create Main Method คือ เมธอดที่ ทำหน้าที่ เป็น ผู้จัดการ
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

    }   // Main Method

    private void createToolbar() {

//        Initial View  คือการ Inflater View เข้ามาทำงาน ใน Java
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);
//        Setup Toolbar คือการกำหนดให้ Toolbar ทำงาน
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

    }

    //    เมธอด ที่ใช่ในการสร้าง หน้ากาก
//    Create Fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;
    }
}   // Main Class
